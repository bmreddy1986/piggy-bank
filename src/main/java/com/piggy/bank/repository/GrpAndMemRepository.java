package com.piggy.bank.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.piggy.bank.repository.models.GrpAndMemRelationDM;
import com.piggy.bank.repository.models.MemberIdentity;

public interface GrpAndMemRepository extends CrudRepository<GrpAndMemRelationDM, MemberIdentity> {
    
	/*
	 * @Query("SELECT m2m FROM table_m2m_grp_mem m2m WHERE m2m.groupid =:groupid")
	 * public MemberDM getByGroupId(@Param("groupid") String groupid);
	 */ 
	/*
	 * @Query("SELECT m2m FROM table_m2m_grp_mem m2m WHERE m2m.memberIdentity =:memberIdentity"
	 * ) public GrpAndMemRelationDM getByMemberIdentity(@Param("memberidentity")
	 * MemberIdentity memberIdentity);
	 */
	
	//@Query("SELECT m2m FROM table_m2m_grp_mem m2m WHERE m2m.memberIdentity =:memberIdentity")
	public List<GrpAndMemRelationDM> findByMemberIdentityGroupid(String groupid);
    
}
