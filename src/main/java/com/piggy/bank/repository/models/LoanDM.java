package com.piggy.bank.repository.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "table_loan")
public class LoanDM {

	@Id
	private String id;
	private String memberid;
	private String groupid;
	private int amount;
	private int emicount;
	private String banktxid;
	private String status;
	private String parentloanid;
	private int parentloanbal;
	
	public String getId() {
		return id;
	}
	public LoanDM setId(String id) {
		this.id = id;
		return this;
	}
	public String getMemberid() {
		return memberid;
	}
	public LoanDM setMemberid(String memberid) {
		this.memberid = memberid;
		return this;
	}
	public String getGroupid() {
		return groupid;
	}
	public LoanDM setGroupid(String groupid) {
		this.groupid = groupid;
		return this;
	}
	public int getAmount() {
		return amount;
	}
	public LoanDM setAmount(int amount) {
		this.amount = amount;
		return this;
	}
	public int getEmicount() {
		return emicount;
	}
	public LoanDM setEmicount(int emicount) {
		this.emicount = emicount;
		return this;
	}
	public String getBanktxid() {
		return banktxid;
	}
	public LoanDM setBanktxid(String banktxid) {
		this.banktxid = banktxid;
		return this;
	}
	public String getStatus() {
		return status;
	}
	public LoanDM setStatus(String status) {
		this.status = status;
		return this;
	}
	public String getParentloanid() {
		return parentloanid;
	}
	public LoanDM setParentloanid(String parentloanid) {
		this.parentloanid = parentloanid;
		return this;
	}
	public int getParentloanbal() {
		return parentloanbal;
	}
	public LoanDM setParentloanbal(int parentloanbal) {
		this.parentloanbal = parentloanbal;
		return this;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + ((banktxid == null) ? 0 : banktxid.hashCode());
		result = prime * result + emicount;
		result = prime * result + ((groupid == null) ? 0 : groupid.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((memberid == null) ? 0 : memberid.hashCode());
		result = prime * result + parentloanbal;
		result = prime * result + ((parentloanid == null) ? 0 : parentloanid.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		LoanDM other = (LoanDM) obj;
		if (amount != other.amount)
			return false;
		if (banktxid == null) {
			if (other.banktxid != null)
				return false;
		} else if (!banktxid.equals(other.banktxid))
			return false;
		if (emicount != other.emicount)
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
		if (memberid == null) {
			if (other.memberid != null)
				return false;
		} else if (!memberid.equals(other.memberid))
			return false;
		if (parentloanbal != other.parentloanbal)
			return false;
		if (parentloanid == null) {
			if (other.parentloanid != null)
				return false;
		} else if (!parentloanid.equals(other.parentloanid))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "LoanDM [id=" + id + ", memberid=" + memberid + ", groupid=" + groupid + ", amount=" + amount
				+ ", emicount=" + emicount + ", banktxid=" + banktxid + ", status=" + status + ", parentloanid="
				+ parentloanid + ", parentloanbal=" + parentloanbal + "]";
	}

	
}
