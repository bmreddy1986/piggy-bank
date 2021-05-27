package com.piggy.bank.domain.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import com.piggy.bank.domain.interfaces.IAppConstants;
import com.piggy.bank.domain.interfaces.IGroupAndMemberDomainService;
import com.piggy.bank.repository.GroupRepository;
import com.piggy.bank.repository.GrpAndMemRepository;
import com.piggy.bank.repository.IdentifierUtil;
import com.piggy.bank.repository.MemberRepository;
import com.piggy.bank.repository.models.GroupDM;
import com.piggy.bank.repository.models.GrpAndMemRelationDM;
import com.piggy.bank.repository.models.MemberIdentity;
import com.piggy.bank.resource.mappers.AppMapper;
import com.piggy.bank.resource.models.Group;
import com.piggy.bank.resource.models.Member;

public class GroupAndMemberDomainService implements IGroupAndMemberDomainService {

	@Autowired
	GroupRepository grpRepo;
	@Autowired
	MemberRepository memRepo;
	@Autowired
	GrpAndMemRepository m2mRepo;
	@Autowired
	IdentifierUtil identifierUtil;

	private AppMapper mapper = Mappers.getMapper(AppMapper.class);

	@Override
	public Group getGroupById(String id) {
		Group group = mapper.mapGroupDM2Group(grpRepo.getById(id));
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
}
