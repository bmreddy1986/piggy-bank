package com.piggy.bank.domain.interfaces;

import com.piggy.bank.repository.models.GroupDM;
import com.piggy.bank.repository.models.MemberDM;

public interface IGroupDomainService {
	
	public GroupDM getGroupById(String id);
	
	public GroupDM createGroup(GroupDM groupDM);
	
	public MemberDM addMember(String groupId, MemberDM memberDM);

}
