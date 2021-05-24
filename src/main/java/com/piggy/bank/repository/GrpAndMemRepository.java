package com.piggy.bank.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.piggy.bank.repository.models.GrpAndMemRelationDM;
import com.piggy.bank.repository.models.MemberDM;

public interface GrpAndMemRepository extends CrudRepository<GrpAndMemRelationDM, String> {
    
    //@Query("SELECT m2m FROM table_m2m_grp_mem m2m WHERE m2m.grpid =:grpid")
    //public MemberDM getById(@Param("grpid") String grpid);
    
}
