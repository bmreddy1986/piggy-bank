package com.piggy.bank.repository.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "table_deposit")
public class DepositDM {

	@Id
	private String id;
	private String memberid;
	private String groupid;
	private int amount;
	private String depositmonth;
	private String banktxid;
	private String loanid;
	private int intamount;

	public String getId() {
		return id;
	}

	public DepositDM setId(String id) {
		this.id = id;
		return this;
	}

	public String getMemberid() {
		return memberid;
	}

	public DepositDM setMemberid(String memberid) {
		this.memberid = memberid;
		return this;
	}

	public String getGroupid() {
		return groupid;
	}

	public DepositDM setGroupid(String groupid) {
		this.groupid = groupid;
		return this;
	}

	public int getAmount() {
		return amount;
	}

	public DepositDM setAmount(int amount) {
		this.amount = amount;
		return this;
	}

	public String getDepositmonth() {
		return depositmonth;
	}

	public DepositDM setDepositmonth(String depositmonth) {
		this.depositmonth = depositmonth;
		return this;
	}

	public String getBanktxid() {
		return banktxid;
	}

	public DepositDM setBanktxid(String banktxid) {
		this.banktxid = banktxid;
		return this;
	}

	public String getLoanid() {
		return loanid;
	}

	public DepositDM setLoanid(String loanid) {
		this.loanid = loanid;
		return this;
	}

	public int getIntamount() {
		return intamount;
	}

	public DepositDM setIntamount(int intamount) {
		this.intamount = intamount;
		return this;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + ((banktxid == null) ? 0 : banktxid.hashCode());
		result = prime * result + ((depositmonth == null) ? 0 : depositmonth.hashCode());
		result = prime * result + ((groupid == null) ? 0 : groupid.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + intamount;
		result = prime * result + ((loanid == null) ? 0 : loanid.hashCode());
		result = prime * result + ((memberid == null) ? 0 : memberid.hashCode());
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
		DepositDM other = (DepositDM) obj;
		if (amount != other.amount)
			return false;
		if (banktxid == null) {
			if (other.banktxid != null)
				return false;
		} else if (!banktxid.equals(other.banktxid))
			return false;
		if (depositmonth == null) {
			if (other.depositmonth != null)
				return false;
		} else if (!depositmonth.equals(other.depositmonth))
			return false;
		if (groupid == null) {
			if (other.groupid != null)
				return false;
		} else if (!groupid.equals(other.groupid))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (intamount != other.intamount)
			return false;
		if (loanid == null) {
			if (other.loanid != null)
				return false;
		} else if (!loanid.equals(other.loanid))
			return false;
		if (memberid == null) {
			if (other.memberid != null)
				return false;
		} else if (!memberid.equals(other.memberid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DepositDM [id=" + id + ", memberid=" + memberid + ", groupid=" + groupid + ", amount=" + amount
				+ ", depositmonth=" + depositmonth + ", banktxid=" + banktxid + ", loanid=" + loanid + ", intamount="
				+ intamount + "]";
	}

}
