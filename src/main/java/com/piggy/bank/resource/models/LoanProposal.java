package com.piggy.bank.resource.models;

import java.util.List;

public class LoanProposal {

	private String memberid;
	private String groupid;
	private int loanAmount;
	private int monthlyInstallment;
	private List<EMI> emi;
	
	public String getMemberid() {
		return memberid;
	}
	public LoanProposal setMemberid(String memberid) {
		this.memberid = memberid;
		return this;
	}
	public String getGroupid() {
		return groupid;
	}
	public LoanProposal setGroupid(String groupid) {
		this.groupid = groupid;
		return this;
	}
	public int getLoanAmount() {
		return loanAmount;
	}
	public LoanProposal setLoanAmount(int loanAmount) {
		this.loanAmount = loanAmount;
		return this;
	}
	public int getMonthlyInstallment() {
		return monthlyInstallment;
	}
	public LoanProposal setMonthlyInstallment(int monthlyInstallment) {
		this.monthlyInstallment = monthlyInstallment;
		return this;
	}
	public List<EMI> getEmi() {
		return emi;
	}
	public LoanProposal setEmi(List<EMI> emi) {
		this.emi = emi;
		return this;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emi == null) ? 0 : emi.hashCode());
		result = prime * result + ((groupid == null) ? 0 : groupid.hashCode());
		result = prime * result + loanAmount;
		result = prime * result + ((memberid == null) ? 0 : memberid.hashCode());
		result = prime * result + monthlyInstallment;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoanProposal other = (LoanProposal) obj;
		if (emi == null) {
			if (other.emi != null)
				return false;
		} else if (!emi.equals(other.emi))
			return false;
		if (groupid == null) {
			if (other.groupid != null)
				return false;
		} else if (!groupid.equals(other.groupid))
			return false;
		if (loanAmount != other.loanAmount)
			return false;
		if (memberid == null) {
			if (other.memberid != null)
				return false;
		} else if (!memberid.equals(other.memberid))
			return false;
		if (monthlyInstallment != other.monthlyInstallment)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "LoanProposal [memberid=" + memberid + ", groupid=" + groupid + ", loanAmount=" + loanAmount
				+ ", monthlyInstallment=" + monthlyInstallment + ", emi=" + emi + "]";
	}
	

}
