package com.piggy.bank.resource.mappers;

import com.piggy.bank.repository.models.DepositDM;
import com.piggy.bank.repository.models.GroupDM;
import com.piggy.bank.repository.models.LoanDM;
import com.piggy.bank.repository.models.MemberDM;
import com.piggy.bank.resource.models.Deposit;
import com.piggy.bank.resource.models.Group;
import com.piggy.bank.resource.models.Loan;
import com.piggy.bank.resource.models.Member;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-05T17:41:20+0530",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.22.0.v20200530-2032, environment: Java 11.0.8 (Oracle Corporation)"
)
public class AppMapperImpl implements AppMapper {

    @Override
    public GroupDM mapGroup2GroupDM(Group group) {
        if ( group == null ) {
            return null;
        }

        GroupDM groupDM = new GroupDM();

        groupDM.setDeposit( group.getDeposit() );
        groupDM.setId( group.getId() );
        groupDM.setName( group.getName() );
        groupDM.setOrganizerid( group.getOrganizerid() );
        groupDM.setRoi( group.getRoi() );

        return groupDM;
    }

    @Override
    public Group mapGroupDM2Group(GroupDM groupDM) {
        if ( groupDM == null ) {
            return null;
        }

        Group group = new Group();

        group.setDeposit( groupDM.getDeposit() );
        group.setId( groupDM.getId() );
        group.setName( groupDM.getName() );
        group.setOrganizerid( groupDM.getOrganizerid() );
        group.setRoi( groupDM.getRoi() );

        return group;
    }

    @Override
    public List<GroupDM> mapGroup2GroupDM(List<Group> group) {
        if ( group == null ) {
            return null;
        }

        List<GroupDM> list = new ArrayList<GroupDM>( group.size() );
        for ( Group group1 : group ) {
            list.add( mapGroup2GroupDM( group1 ) );
        }

        return list;
    }

    @Override
    public List<Group> mapGroupDM2Group(List<GroupDM> groupDM) {
        if ( groupDM == null ) {
            return null;
        }

        List<Group> list = new ArrayList<Group>( groupDM.size() );
        for ( GroupDM groupDM1 : groupDM ) {
            list.add( mapGroupDM2Group( groupDM1 ) );
        }

        return list;
    }

    @Override
    public MemberDM mapMember2MemberDM(Member member) {
        if ( member == null ) {
            return null;
        }

        MemberDM memberDM = new MemberDM();

        memberDM.setAddress( member.getAddress() );
        memberDM.setEmail( member.getEmail() );
        memberDM.setId( member.getId() );
        memberDM.setName( member.getName() );
        memberDM.setPassword( member.getPassword() );

        return memberDM;
    }

    @Override
    public Member mapMemberDM2Member(MemberDM memberDM) {
        if ( memberDM == null ) {
            return null;
        }

        Member member = new Member();

        member.setAddress( memberDM.getAddress() );
        member.setEmail( memberDM.getEmail() );
        member.setId( memberDM.getId() );
        member.setName( memberDM.getName() );
        member.setPassword( memberDM.getPassword() );

        return member;
    }

    @Override
    public List<MemberDM> mapMember2MemberDM(List<Member> member) {
        if ( member == null ) {
            return null;
        }

        List<MemberDM> list = new ArrayList<MemberDM>( member.size() );
        for ( Member member1 : member ) {
            list.add( mapMember2MemberDM( member1 ) );
        }

        return list;
    }

    @Override
    public List<Member> mapMemberDM2Member(List<MemberDM> memberDM) {
        if ( memberDM == null ) {
            return null;
        }

        List<Member> list = new ArrayList<Member>( memberDM.size() );
        for ( MemberDM memberDM1 : memberDM ) {
            list.add( mapMemberDM2Member( memberDM1 ) );
        }

        return list;
    }

    @Override
    public DepositDM mapDeposit2DepositDM(Deposit deposit) {
        if ( deposit == null ) {
            return null;
        }

        DepositDM depositDM = new DepositDM();

        depositDM.setAmount( deposit.getAmount() );
        depositDM.setBanktxid( deposit.getBanktxid() );
        depositDM.setDepositMonth( deposit.getDepositMonth() );
        depositDM.setGroupid( deposit.getGroupid() );
        depositDM.setId( deposit.getId() );
        depositDM.setIntamount( deposit.getIntamount() );
        depositDM.setLoanid( deposit.getLoanid() );
        depositDM.setMemberid( deposit.getMemberid() );

        return depositDM;
    }

    @Override
    public Deposit mapDepositDM2Deposit(DepositDM depositDM) {
        if ( depositDM == null ) {
            return null;
        }

        Deposit deposit = new Deposit();

        deposit.setAmount( depositDM.getAmount() );
        deposit.setBanktxid( depositDM.getBanktxid() );
        deposit.setDepositMonth( depositDM.getDepositMonth() );
        deposit.setGroupid( depositDM.getGroupid() );
        deposit.setId( depositDM.getId() );
        deposit.setIntamount( depositDM.getIntamount() );
        deposit.setLoanid( depositDM.getLoanid() );
        deposit.setMemberid( depositDM.getMemberid() );

        return deposit;
    }

    @Override
    public List<DepositDM> mapDeposit2DepositDM(List<Deposit> deposit) {
        if ( deposit == null ) {
            return null;
        }

        List<DepositDM> list = new ArrayList<DepositDM>( deposit.size() );
        for ( Deposit deposit1 : deposit ) {
            list.add( mapDeposit2DepositDM( deposit1 ) );
        }

        return list;
    }

    @Override
    public List<Deposit> mapDepositDM2Deposit(List<DepositDM> depositDM) {
        if ( depositDM == null ) {
            return null;
        }

        List<Deposit> list = new ArrayList<Deposit>( depositDM.size() );
        for ( DepositDM depositDM1 : depositDM ) {
            list.add( mapDepositDM2Deposit( depositDM1 ) );
        }

        return list;
    }

    @Override
    public LoanDM mapLoan2LoanDM(Loan loan) {
        if ( loan == null ) {
            return null;
        }

        LoanDM loanDM = new LoanDM();

        loanDM.setAmount( loan.getAmount() );
        loanDM.setBanktxid( loan.getBanktxid() );
        loanDM.setEmicount( loan.getEmicount() );
        loanDM.setId( loan.getId() );
        loanDM.setParentloanbal( loan.getParentloanbal() );
        loanDM.setParentloanid( loan.getParentloanid() );
        loanDM.setStatus( loan.getStatus() );

        return loanDM;
    }

    @Override
    public Loan mapLoanDM2Loan(LoanDM loanDM) {
        if ( loanDM == null ) {
            return null;
        }

        Loan loan = new Loan();

        loan.setAmount( loanDM.getAmount() );
        loan.setBanktxid( loanDM.getBanktxid() );
        loan.setEmicount( loanDM.getEmicount() );
        loan.setId( loanDM.getId() );
        loan.setParentloanbal( loanDM.getParentloanbal() );
        loan.setParentloanid( loanDM.getParentloanid() );
        loan.setStatus( loanDM.getStatus() );

        return loan;
    }
}
