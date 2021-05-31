package com.piggy.bank.domain.interfaces;

import com.piggy.bank.resource.models.Deposit;
import com.piggy.bank.resource.models.Group;
import com.piggy.bank.resource.models.Loan;
import com.piggy.bank.resource.models.LoanProposal;
import com.piggy.bank.resource.models.Member;

public interface IGroupDomainService {
	
	public Group getGroupById(String id);
	
	public Group createGroup(Group group);
	
	public Member addMember(String groupId, Member member);
	
	public Member getMemberById(String id);

	public Deposit addDeposit(String groupId, String memberId, Deposit deposit);

	public LoanProposal proposeLoan(String groupId, String memberId, LoanProposal loanProposal);

	public Loan createLoan(String groupId, String memberId, Loan loan);

}
