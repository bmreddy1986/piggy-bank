package com.piggy.bank.resource.mappers;

import com.piggy.bank.repository.models.DepositDM;
import com.piggy.bank.repository.models.GroupDM;
import com.piggy.bank.repository.models.MemberDM;
import com.piggy.bank.resource.models.Deposit;
import com.piggy.bank.resource.models.Group;
import com.piggy.bank.resource.models.Member;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-05-30T13:46:17+0530",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8 (Oracle Corporation)"
)
public class AppMapperImpl implements AppMapper {

    @Override
    public GroupDM mapGroup2GroupDM(Group group) {
        if ( group == null ) {
            return null;
        }

        GroupDM groupDM = new GroupDM();

        groupDM.setId( group.getId() );
        groupDM.setName( group.getName() );
        groupDM.setOrganizerid( group.getOrganizerid() );
        groupDM.setDeposit( group.getDeposit() );
        groupDM.setRoi( group.getRoi() );

        return groupDM;
    }

    @Override
    public Group mapGroupDM2Group(GroupDM groupDM) {
        if ( groupDM == null ) {
            return null;
        }

        Group group = new Group();

        group.setId( groupDM.getId() );
        group.setName( groupDM.getName() );
        group.setOrganizerid( groupDM.getOrganizerid() );
        group.setRoi( groupDM.getRoi() );
        group.setDeposit( groupDM.getDeposit() );

        return group;
    }

    @Override
    public MemberDM mapMember2MemberDM(Member member) {
        if ( member == null ) {
            return null;
        }

        MemberDM memberDM = new MemberDM();

        memberDM.setId( member.getId() );
        memberDM.setName( member.getName() );
        memberDM.setAddress( member.getAddress() );
        memberDM.setEmail( member.getEmail() );
        memberDM.setPassword( member.getPassword() );

        return memberDM;
    }

    @Override
    public Member mapMemberDM2Member(MemberDM memberDM) {
        if ( memberDM == null ) {
            return null;
        }

        Member member = new Member();

        member.setId( memberDM.getId() );
        member.setName( memberDM.getName() );
        member.setAddress( memberDM.getAddress() );
        member.setEmail( memberDM.getEmail() );
        member.setPassword( memberDM.getPassword() );

        return member;
    }

    @Override
    public DepositDM mapDeposit2DepositDM(Deposit deposit) {
        if ( deposit == null ) {
            return null;
        }

        DepositDM depositDM = new DepositDM();

        depositDM.setId( deposit.getId() );
        depositDM.setMemberid( deposit.getMemberid() );
        depositDM.setGroupid( deposit.getGroupid() );
        depositDM.setAmount( deposit.getAmount() );
        depositDM.setDepositmonth( deposit.getDepositmonth() );
        depositDM.setBanktxid( deposit.getBanktxid() );
        depositDM.setLoanid( deposit.getLoanid() );
        depositDM.setIntamount( deposit.getIntamount() );

        return depositDM;
    }

    @Override
    public Deposit mapDepositDM2Deposit(DepositDM depositDM) {
        if ( depositDM == null ) {
            return null;
        }

        Deposit deposit = new Deposit();

        deposit.setId( depositDM.getId() );
        deposit.setMemberid( depositDM.getMemberid() );
        deposit.setGroupid( depositDM.getGroupid() );
        deposit.setAmount( depositDM.getAmount() );
        deposit.setDepositmonth( depositDM.getDepositmonth() );
        deposit.setBanktxid( depositDM.getBanktxid() );
        deposit.setLoanid( depositDM.getLoanid() );
        deposit.setIntamount( depositDM.getIntamount() );

        return deposit;
    }
}
