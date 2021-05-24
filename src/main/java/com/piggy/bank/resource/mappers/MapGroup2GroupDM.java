package com.piggy.bank.resource.mappers;

import org.mapstruct.Mapper;

import com.piggy.bank.repository.models.GroupDM;
import com.piggy.bank.resource.models.Group;

@Mapper
public interface MapGroup2GroupDM {
	GroupDM mapGroup2GroupDM(Group source);
	Group mapGroupDM2Group(GroupDM destination);
	
	
}