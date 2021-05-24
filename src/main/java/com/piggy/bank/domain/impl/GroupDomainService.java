package com.piggy.bank.domain.impl;

import java.util.Arrays;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import com.piggy.bank.domain.interfaces.IAppConstants;
import com.piggy.bank.domain.interfaces.IGroupDomainService;
import com.piggy.bank.repository.GroupRepository;
import com.piggy.bank.repository.GrpAndMemRepository;
import com.piggy.bank.repository.IdentifierUtil;
import com.piggy.bank.repository.MemberRepository;
import com.piggy.bank.repository.models.GroupDM;
import com.piggy.bank.repository.models.GrpAndMemRelationDM;
import com.piggy.bank.resource.mappers.AppMapper;
import com.piggy.bank.resource.models.Group;
import com.piggy.bank.resource.models.Member;

public class GroupDomainService implements IGroupDomainService {

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
		return mapper.mapGroupDM2Group(grpRepo.getById(id));
	}

	@Override
	public Group createGroup(Group group) {
		GroupDM groupDM = mapper.mapGroup2GroupDM(group);
		groupDM.setId(identifierUtil.getGroupSeqId());
		return mapper.mapGroupDM2Group(grpRepo.save(groupDM));
	}

	@Override
	public Member addMember(String groupId, Member member) {
		/*
		 * if (null == memRepo.getById(member.getId())) { memRepo.save(member); }
		 */
		GrpAndMemRelationDM relDM = new GrpAndMemRelationDM();
		relDM.setGrpid(groupId);
		relDM.setGrpstatus(IAppConstants.ACTIVE);
		relDM.setMemid(member.getId());
		relDM.setMemstatus(IAppConstants.ACTIVE);
		m2mRepo.save(relDM);
		
		member.setGroup(Arrays.asList(groupId));

		return member;
	}

}
