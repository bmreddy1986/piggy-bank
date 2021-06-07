package com.piggy.bank.resource.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.piggy.bank.repository.models.DepositDM;
import com.piggy.bank.repository.models.GroupDM;
import com.piggy.bank.repository.models.LoanDM;
import com.piggy.bank.repository.models.MemberDM;
import com.piggy.bank.resource.models.Deposit;
import com.piggy.bank.resource.models.Group;
import com.piggy.bank.resource.models.Loan;
import com.piggy.bank.resource.models.Member;

@Mapper
public interface AppMapper {
	GroupDM mapGroup2GroupDM(Group group);
	Group mapGroupDM2Group(GroupDM groupDM);
	
	List<GroupDM> mapGroup2GroupDM(List<Group> group);
	List<Group> mapGroupDM2Group(List<GroupDM> groupDM);
	
	MemberDM mapMember2MemberDM(Member member);
	Member mapMemberDM2Member(MemberDM memberDM);
	
	List<MemberDM> mapMember2MemberDM(List<Member> member);
	List<Member> mapMemberDM2Member(List<MemberDM> memberDM);
	
	DepositDM mapDeposit2DepositDM(Deposit deposit);
	Deposit mapDepositDM2Deposit(DepositDM depositDM);
	
	List<DepositDM> mapDeposit2DepositDM(List<Deposit> deposit);
	List<Deposit> mapDepositDM2Deposit(List<DepositDM> depositDM);
	
	LoanDM mapLoan2LoanDM(Loan loan);
	Loan mapLoanDM2Loan(LoanDM loanDM);
}