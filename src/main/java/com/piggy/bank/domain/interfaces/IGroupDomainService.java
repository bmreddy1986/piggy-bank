package com.piggy.bank.domain.interfaces;

import com.piggy.bank.resource.models.Group;
import com.piggy.bank.resource.models.Member;

public interface IGroupDomainService {
	
	public Group getGroupById(String id);
	
	public Group createGroup(Group group);
	
	public Member addMember(String groupId, Member member);

}
