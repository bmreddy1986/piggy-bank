package com.piggy.bank.repository;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

public class IdentifierUtil {

	private static int groupSeqNumber = 1000;
	private static int loanSeqNumber = 20000;
	private static int depositSeqNumber = 300000;

	@Inject
	private GroupRepository groupRepository;
	@Inject
	private DepositRepository depositRepository;
	@Inject
	private LoanRepository loanRepository;

	@PostConstruct
	private void setupIdSeq() {
		String grpSeqId = groupRepository.getIdSeq();
		if (null != grpSeqId && groupSeqNumber < Integer.valueOf(grpSeqId))
			groupSeqNumber = Integer.valueOf(grpSeqId);

		String depositSeqId = depositRepository.getIdSeq();
		if (null != depositSeqId && depositSeqNumber < Integer.valueOf(depositSeqId))
			depositSeqNumber = Integer.valueOf(depositSeqId);

		String loanSeqId = loanRepository.getIdSeq();
		if (null != loanSeqId && loanSeqNumber < Integer.valueOf(loanSeqId))
			loanSeqNumber = Integer.valueOf(loanSeqId);
	}

	public String getGroupSeqId() {
		return String.valueOf(++groupSeqNumber);
	}

	public String getLoanSeqId() {
		return String.valueOf(++loanSeqNumber);
	}

	public String getDepositSeqId() {
		return String.valueOf(++depositSeqNumber);
	}

}
