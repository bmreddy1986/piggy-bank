package com.piggy.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.piggy.bank.repository.models.DepositDM;

public interface DepositRepository extends CrudRepository<DepositDM, String> {
    
	/*
	 * @Query("SELECT g FROM table_group g WHERE g.id =:id") public GroupDM
	 * getById(@Param("id") String id);
	 * 
	 * @Query("SELECT MAX(id) FROM table_group") public String getGroupIdSeq();
	 */
	
	@Query("SELECT MAX(id) FROM table_deposit")
    public String getIdSeq();
	
    public List<DepositDM> findByGroupidAndMemberid(String groupid, String memberid);
    
    @Query("SELECT d FROM table_deposit d WHERE d.memberid =:id order by d.groupid")
    public List<DepositDM> getDepsitByMemberid(@Param("id") String memid);
    
}
