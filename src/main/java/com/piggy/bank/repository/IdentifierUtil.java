package com.piggy.bank.repository;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class IdentifierUtil {
	
	private static int count = 1000;
	
	public String getId(String name) {
		if("Group".equals(name)) {
			return String.valueOf(++count);
		}
		return null;
	}
	
	
	private static int groupSeqNumber = 1000;
	private static int loanSeqNumber = 2000;
	private static int depositSeqNumber = 3000;
	
	@Autowired GroupRepository repo;
	
	@PostConstruct
	private void setupIdSeq() {
		String grpSeqId = repo.getGroupIdSeq();
		if(null!=grpSeqId && groupSeqNumber < Integer.valueOf(grpSeqId))
			groupSeqNumber = Integer.valueOf(grpSeqId);
					
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
