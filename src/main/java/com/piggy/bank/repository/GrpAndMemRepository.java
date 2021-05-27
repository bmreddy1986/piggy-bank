package com.piggy.bank.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.piggy.bank.repository.models.GrpAndMemRelationDM;
import com.piggy.bank.repository.models.MemberIdentity;

public interface GrpAndMemRepository extends CrudRepository<GrpAndMemRelationDM, MemberIdentity> {
    
	public List<GrpAndMemRelationDM> findByMemberIdentityGroupid(String groupid);
	
	public List<GrpAndMemRelationDM> findByMemberIdentityMemberid(String memberid);
    
}
