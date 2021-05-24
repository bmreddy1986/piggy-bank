package com.piggy.bank.domain.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.piggy.bank.domain.interfaces.IAppConstants;
import com.piggy.bank.domain.interfaces.IGroupDomainService;
import com.piggy.bank.repository.IdentifierUtil;
import com.piggy.bank.repository.MemberRepository;
import com.piggy.bank.repository.GroupRepository;
import com.piggy.bank.repository.models.GroupDM;
import com.piggy.bank.repository.models.GrpAndMemRelationDM;
import com.piggy.bank.repository.models.MemberDM;

public class GroupDomainService implements IGroupDomainService {

	@Autowired
	GroupRepository grpRepo;
	@Autowired
	MemberRepository memRepo;
	@Autowired
	IdentifierUtil identifierUtil;

	@Override
	public GroupDM getGroupById(String id) {
		return grpRepo.getById(id);
	}

	@Override
	public GroupDM createGroup(GroupDM groupDM) {
		groupDM.setId(identifierUtil.getGroupSeqId());
		return grpRepo.save(groupDM);
	}

	@Override
	public MemberDM addMember(String groupId, MemberDM memberDM) {
		if (null == memRepo.getById(memberDM.getId())) {
			memRepo.save(memberDM);
		}
		GrpAndMemRelationDM relDM = new GrpAndMemRelationDM();
		relDM.setGrpid(groupId);
		relDM.setGrpstatus(IAppConstants.ACTIVE);
		relDM.setMemid(memberDM.getId());
		relDM.setMemstatus(IAppConstants.ACTIVE);
		// repo.save(relDM);

		// memberDM.setGroup(new ArrayList<>());

		return null;
	}

}
