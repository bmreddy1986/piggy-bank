package com.piggy.bank.resource.mappers;

import org.mapstruct.Mapper;

import com.piggy.bank.repository.models.GroupDM;
import com.piggy.bank.repository.models.MemberDM;
import com.piggy.bank.resource.models.Group;
import com.piggy.bank.resource.models.Member;

@Mapper
public interface AppMapper {
	GroupDM mapGroup2GroupDM(Group group);
	Group mapGroupDM2Group(GroupDM groupDM);
	
	MemberDM mapMember2MemberDM(Member member);
	Member mapMemberDM2Member(MemberDM memberDM);
}