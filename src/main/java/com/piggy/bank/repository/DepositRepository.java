package com.piggy.bank.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

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
    
}
