package com.piggy.bank.repository;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

public class IdentifierUtil {
	
	private static int count = 1000;
	
	public String getId(String name) {
		if("Group".equals(name)) {
			return String.valueOf(++count);
		}
		return null;
	}
	
	
	private static int groupSeqNumber = 10000;
	private static int loanSeqNumber = 20000;
	private static int depositSeqNumber = 300000;
	
	@Autowired GroupRepository groupRepo;
	@Autowired DepositRepository depositRepo;
	
	@PostConstruct
	private void setupIdSeq() {
		String grpSeqId = groupRepo.getIdSeq();
		if(null!=grpSeqId && groupSeqNumber < Integer.valueOf(grpSeqId))
			groupSeqNumber = Integer.valueOf(grpSeqId);

		String depositSeqId = depositRepo.getIdSeq();
		if(null!=depositSeqId && depositSeqNumber < Integer.valueOf(depositSeqId))
			depositSeqNumber = Integer.valueOf(depositSeqId);			
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
