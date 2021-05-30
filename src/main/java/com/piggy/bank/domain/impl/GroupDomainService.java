package com.piggy.bank.domain.impl;

import java.time.OffsetDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import com.piggy.bank.domain.interfaces.IGroupDomainService;
import com.piggy.bank.domain.interfaces.IAppConstants;
import com.piggy.bank.domain.interfaces.ICalculateEMIService;
import com.piggy.bank.domain.interfaces.ICalculateInterestService;
import com.piggy.bank.exceptions.ResourceNotFoundException;
import com.piggy.bank.repository.DepositRepository;
import com.piggy.bank.repository.GroupRepository;
import com.piggy.bank.repository.GrpAndMemRepository;
import com.piggy.bank.repository.IdentifierUtil;
import com.piggy.bank.repository.MemberRepository;
import com.piggy.bank.repository.models.DepositDM;
import com.piggy.bank.repository.models.GroupDM;
import com.piggy.bank.repository.models.GrpAndMemRelationDM;
import com.piggy.bank.repository.models.MemberIdentity;
import com.piggy.bank.resource.mappers.AppMapper;
import com.piggy.bank.resource.models.Deposit;
import com.piggy.bank.resource.models.EMI;
import com.piggy.bank.resource.models.Group;
import com.piggy.bank.resource.models.LoanProposal;
import com.piggy.bank.resource.models.Member;

public class GroupDomainService implements IGroupDomainService {

	@Autowired
	GroupRepository grpRepo;
	@Autowired
	MemberRepository memRepo;
	@Autowired
	DepositRepository depositRepo;
	@Autowired
	GrpAndMemRepository m2mRepo;
	@Autowired
	IdentifierUtil identifierUtil;
	@Autowired
	ICalculateInterestService interestService;
	@Autowired
	ICalculateEMIService emiService;

	private AppMapper mapper = Mappers.getMapper(AppMapper.class);

	@Override
	public Group getGroupById(String id) {
		Group group = mapper.mapGroupDM2Group(grpRepo.getById(id));
		if(null == group)
			throw new ResourceNotFoundException(String.format("Group {%s} Not found", id));
		List<GrpAndMemRelationDM> m2mList = m2mRepo.findByMemberIdentityGroupid(id);
		return group.setMembers(m2mList.stream().map(GrpAndMemRelationDM::getMemberIdentity)
				.map(MemberIdentity::getMemberid).collect(Collectors.toList()));
	}

	@Override
	public Group createGroup(Group group) {
		GroupDM groupDM = mapper.mapGroup2GroupDM(group);
		groupDM.setId(identifierUtil.getGroupSeqId());
		return mapper.mapGroupDM2Group(grpRepo.save(groupDM));
	}

	@Override
	public Member addMember(String groupId, Member member) {
		if (null == memRepo.getById(member.getId())) {
			memRepo.save(mapper.mapMember2MemberDM(member));
		}

		GrpAndMemRelationDM relDM = new GrpAndMemRelationDM();
		relDM.setMemberIdentity(new MemberIdentity().setGroupid(groupId).setMemberid(member.getId()))
				.setGroupstatus(IAppConstants.ACTIVE).setMemberstatus(IAppConstants.ACTIVE);
		m2mRepo.save(relDM);
		return member.setGroup(Arrays.asList(groupId));
	}

	@Override
	public Member getMemberById(String id) {
		Member member = mapper.mapMemberDM2Member(memRepo.getById(id));
		List<GrpAndMemRelationDM> m2mList = m2mRepo.findByMemberIdentityMemberid(id);
		return member.setGroup(m2mList.stream().map(GrpAndMemRelationDM::getMemberIdentity)
				.map(MemberIdentity::getGroupid).collect(Collectors.toList()));
	}

	@Override
	public Deposit addDeposit(String groupId, String memberId, Deposit deposit) {
		DepositDM depositDM = mapper.mapDeposit2DepositDM(deposit).setGroupid(groupId).setMemberid(memberId);
		depositDM.setId(identifierUtil.getDepositSeqId());
		return mapper.mapDepositDM2Deposit(depositRepo.save(depositDM));
	}

	@Override
	public LoanProposal proposeLoan(String groupId, String memberId, LoanProposal loanProposal) {
		int roi = grpRepo.getById(groupId).getRoi();
		double partialEMI = interestService.calcPartialInterest(loanProposal.getLoanAmount(), roi);
		OffsetDateTime current = OffsetDateTime.now();
		List<EMI> emis = new ArrayList<>();
		//Partial month EMI calculation
		if(partialEMI > 0) {
			EMI e = new EMI();
			e.setOutstanding(loanProposal.getLoanAmount()).setInterest(partialEMI);
			e.setStartDate(current);
			e.setEndDate(current.with(TemporalAdjusters.lastDayOfMonth()));
			emis.add(e);
			
		}
		//Full month EMI calculation
		int noOfEMIs = loanProposal.getLoanAmount()/5000;
		for(int i=0; i<noOfEMIs; i++) {
			EMI e = new EMI();
			e.setOutstanding(loanProposal.getLoanAmount() - 5000*i);
			e.setInterest(interestService.calcInterest(e.getOutstanding(), roi));
			if(partialEMI > 0 || i!=0 ) {
				e.setStartDate(emis.get(i).getEndDate().with(TemporalAdjusters.firstDayOfNextMonth()));
				e.setEndDate(emis.get(i).getEndDate().with(TemporalAdjusters.firstDayOfNextMonth()).with(TemporalAdjusters.lastDayOfMonth()));
				emis.add(e);
			} else {
				e.setStartDate(current);
				e.setStartDate(current.with(TemporalAdjusters.lastDayOfMonth()));
			}
		}
		//If loanAmoun is not multiples of 5000, then calculating the last EMI for remaining
		if(noOfEMIs*5000 < loanProposal.getLoanAmount() && loanProposal.getLoanAmount() > 5000) {
			int remain = loanProposal.getLoanAmount() - noOfEMIs*5000;
			EMI e = new EMI();
			e.setOutstanding(remain);
			e.setInterest(interestService.calcInterest(remain, roi));
			noOfEMIs = partialEMI > 0 ? noOfEMIs : noOfEMIs -1; 
			e.setStartDate(emis.get(noOfEMIs).getEndDate().with(TemporalAdjusters.firstDayOfNextMonth()));
			e.setEndDate(emis.get(noOfEMIs).getEndDate().with(TemporalAdjusters.firstDayOfNextMonth()).with(TemporalAdjusters.lastDayOfMonth()));
			emis.add(e);
		}
		
		return loanProposal.setMonthlyInstallment(5000).setEmi(emis).setGroupid(groupId).setMemberid(memberId);
	}
}
