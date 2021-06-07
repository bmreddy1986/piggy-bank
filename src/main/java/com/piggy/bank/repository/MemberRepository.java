package com.piggy.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.piggy.bank.repository.models.GroupDM;
import com.piggy.bank.repository.models.MemberDM;

public interface MemberRepository extends CrudRepository<MemberDM, String> {
    
    //Member related operations
    @Query("SELECT m FROM table_member m WHERE m.id =:id")
    public MemberDM getById(@Param("id") String id);
    
}
