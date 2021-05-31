package com.piggy.bank.resource.mappers;

import com.piggy.bank.repository.models.DepositDM;
import com.piggy.bank.repository.models.GroupDM;
import com.piggy.bank.repository.models.LoanDM;
import com.piggy.bank.repository.models.MemberDM;
import com.piggy.bank.resource.models.Deposit;
import com.piggy.bank.resource.models.Group;
import com.piggy.bank.resource.models.Loan;
import com.piggy.bank.resource.models.Member;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-05-31T22:45:43+0530",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.22.0.v20200530-2032, environment: Java 11.0.8 (Oracle Corporation)"
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

    @Override
    public LoanDM mapLoan2LoanDM(Loan loan) {
        if ( loan == null ) {
            return null;
        }

        LoanDM loanDM = new LoanDM();

        loanDM.setId( loan.getId() );
        loanDM.setAmount( loan.getAmount() );
        loanDM.setEmicount( loan.getEmicount() );
        loanDM.setBanktxid( loan.getBanktxid() );
        loanDM.setStatus( loan.getStatus() );
        loanDM.setParentloanid( loan.getParentloanid() );
        loanDM.setParentloanbal( loan.getParentloanbal() );

        return loanDM;
    }

    @Override
    public Loan mapLoanDM2Loan(LoanDM loanDM) {
        if ( loanDM == null ) {
            return null;
        }

        Loan loan = new Loan();

        loan.setId( loanDM.getId() );
        loan.setAmount( loanDM.getAmount() );
        loan.setEmicount( loanDM.getEmicount() );
        loan.setBanktxid( loanDM.getBanktxid() );
        loan.setStatus( loanDM.getStatus() );
        loan.setParentloanid( loanDM.getParentloanid() );
        loan.setParentloanbal( loanDM.getParentloanbal() );

        return loan;
    }
}
