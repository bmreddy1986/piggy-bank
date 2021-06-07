package com.piggy.bank.domain.impl;

import java.time.OffsetDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.mapstruct.factory.Mappers;

import com.piggy.bank.domain.interfaces.IAppConstants;
import com.piggy.bank.domain.interfaces.ICalculateEMIService;
import com.piggy.bank.domain.interfaces.ICalculateInterestService;
import com.piggy.bank.domain.interfaces.IGroupDomainService;
import com.piggy.bank.exceptions.ResourceNotFoundException;
import com.piggy.bank.repository.DepositRepository;
import com.piggy.bank.repository.GroupRepository;
import com.piggy.bank.repository.GrpAndMemRepository;
import com.piggy.bank.repository.IdentifierUtil;
import com.piggy.bank.repository.LoanRepository;
import com.piggy.bank.repository.MemberRepository;
import com.piggy.bank.repository.models.DepositDM;
import com.piggy.bank.repository.models.GroupDM;
import com.piggy.bank.repository.models.GrpAndMemRelationDM;
import com.piggy.bank.repository.models.LoanDM;
import com.piggy.bank.repository.models.MemberDM;
import com.piggy.bank.repository.models.MemberIdentity;
import com.piggy.bank.resource.mappers.AppMapper;
import com.piggy.bank.resource.models.Deposit;
import com.piggy.bank.resource.models.EMI;
import com.piggy.bank.resource.models.Group;
import com.piggy.bank.resource.models.Loan;
import com.piggy.bank.resource.models.LoanProposal;
import com.piggy.bank.resource.models.Member;

public class GroupDomainService implements IGroupDomainService {

	@Inject
	private GroupRepository groupRepository;
	@Inject
	private MemberRepository memberRepository;
	@Inject
	private DepositRepository depositRepository;
	@Inject
	private LoanRepository loanRepository;
	@Inject
	private GrpAndMemRepository m2mRepository;
	@Inject
	private IdentifierUtil identifierUtil;
	@Inject
	private ICalculateInterestService interestService;
	@Inject
	private ICalculateEMIService emiService;

	private AppMapper mapper = Mappers.getMapper(AppMapper.class);

	@Override
	public Group getGroupById(String id) {
		Group group = mapper.mapGroupDM2Group(groupRepository.getById(id));
		if (null == group)
			throw new ResourceNotFoundException(String.format("Group {%s} Not found", id));
		
		return group.setMember(getMembersByGroupId(id));
	}
	
	@Override
	public List<Member> getMembersByGroupId(String groupId) {
		List<GrpAndMemRelationDM> m2mList = m2mRepository.findByMemberIdentityGroupid(groupId);
		List<String> memList = m2mList.stream().map(GrpAndMemRelationDM::getMemberIdentity)
				.map(MemberIdentity::getMemberid).collect(Collectors.toList());
		List<MemberDM> members = memList.stream().map(x->memberRepository.getById(x)).collect(Collectors.toList());
		return members.stream().map(x->mapper.mapMemberDM2Member(x)).collect(Collectors.toList());
	}
	
	@Override
	public List<Group> searchGroup(String organizerId) {
		return mapper.mapGroupDM2Group(groupRepository.findByOrganizerid(organizerId));
	}

	@Override
	public Group createGroup(Group group) {
		GroupDM groupDM = mapper.mapGroup2GroupDM(group);
		groupDM.setId(identifierUtil.getGroupSeqId());
		return mapper.mapGroupDM2Group(groupRepository.save(groupDM));
	}

	@Override
	public Member addMember(String groupId, Member member) {
		if (null == memberRepository.getById(member.getId())) {
			memberRepository.save(mapper.mapMember2MemberDM(member));
		}

		GrpAndMemRelationDM relDM = new GrpAndMemRelationDM();
		relDM.setMemberIdentity(new MemberIdentity().setGroupid(groupId).setMemberid(member.getId()))
				.setGroupstatus(IAppConstants.ACTIVE).setMemberstatus(IAppConstants.ACTIVE);
		m2mRepository.save(relDM);
		return member.setGroup(Arrays.asList(groupId));
	}

	@Override
	public Member getMemberById(String id) {
		Member member = mapper.mapMemberDM2Member(memberRepository.getById(id));
		List<GrpAndMemRelationDM> m2mList = m2mRepository.findByMemberIdentityMemberid(id);
		return member.setGroup(m2mList.stream().map(GrpAndMemRelationDM::getMemberIdentity)
				.map(MemberIdentity::getGroupid).collect(Collectors.toList()));
	}	

	@Override
	public Deposit addDeposit(String groupId, String memberId, Deposit deposit) {
		DepositDM depositDM = mapper.mapDeposit2DepositDM(deposit).setGroupid(groupId).setMemberid(memberId);
		depositDM.setId(identifierUtil.getDepositSeqId());
		return mapper.mapDepositDM2Deposit(depositRepository.save(depositDM));
	}
	
	@Override
	public List<Deposit> getMemberDepositInGruop(String groupId, String memberId) {
		Deposit memDeposit = new Deposit();
		return mapper.mapDepositDM2Deposit(depositRepository.findByGroupidAndMemberid(groupId, memberId));
	}

	@Override
	public List<Deposit> getMemberDeposit(String memberId) {
		Deposit memDeposit = new Deposit();
		return mapper.mapDepositDM2Deposit(depositRepository.getDepsitByMemberid(memberId));
	}
	
	@Override
	public Loan createLoan(String groupId, String memberId, Loan loan) {
		LoanDM loanDM = mapper.mapLoan2LoanDM(loan).setGroupid(groupId).setMemberid(memberId);
		loanDM.setId(identifierUtil.getLoanSeqId());
		return mapper.mapLoanDM2Loan(loanRepository.save(loanDM));
	}

	@Override
	public LoanProposal proposeLoan(String groupId, String memberId, LoanProposal loanProposal) {
		int roi = groupRepository.getById(groupId).getRoi();
		double partialEMI = interestService.calcPartialInterest(loanProposal.getLoanAmount(), roi);
		OffsetDateTime current = OffsetDateTime.now();
		List<EMI> emis = new ArrayList<>();
		// Partial month EMI calculation
		if (partialEMI > 0) {
			EMI e = new EMI();
			e.setOutstanding(loanProposal.getLoanAmount()).setInterest(partialEMI);
			e.setStartDate(current);
			e.setEndDate(current.with(TemporalAdjusters.lastDayOfMonth()));
			emis.add(e);

		}
		// Full month EMI calculation
		int noOfEMIs = loanProposal.getLoanAmount() / 5000;
		for (int i = 0; i < noOfEMIs; i++) {
			EMI e = new EMI();
			e.setOutstanding(loanProposal.getLoanAmount() - 5000 * i);
			e.setInterest(interestService.calcInterest(e.getOutstanding(), roi));
			if (partialEMI > 0 || i != 0) {
				e.setStartDate(emis.get(i).getEndDate().with(TemporalAdjusters.firstDayOfNextMonth()));
				e.setEndDate(emis.get(i).getEndDate().with(TemporalAdjusters.firstDayOfNextMonth())
						.with(TemporalAdjusters.lastDayOfMonth()));
				emis.add(e);
			} else {
				e.setStartDate(current);
				e.setStartDate(current.with(TemporalAdjusters.lastDayOfMonth()));
			}
		}
		// If loanAmoun is not multiples of 5000, then calculating the last EMI for
		// remaining
		if (noOfEMIs * 5000 < loanProposal.getLoanAmount() && loanProposal.getLoanAmount() > 5000) {
			int remain = loanProposal.getLoanAmount() - noOfEMIs * 5000;
			EMI e = new EMI();
			e.setOutstanding(remain);
			e.setInterest(interestService.calcInterest(remain, roi));
			noOfEMIs = partialEMI > 0 ? noOfEMIs : noOfEMIs - 1;
			e.setStartDate(emis.get(noOfEMIs).getEndDate().with(TemporalAdjusters.firstDayOfNextMonth()));
			e.setEndDate(emis.get(noOfEMIs).getEndDate().with(TemporalAdjusters.firstDayOfNextMonth())
					.with(TemporalAdjusters.lastDayOfMonth()));
			emis.add(e);
		}

		return loanProposal.setMonthlyInstallment(5000).setEmi(emis).setGroupid(groupId).setMemberid(memberId);
	}
}
