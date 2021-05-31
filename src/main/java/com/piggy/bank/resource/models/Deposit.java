package com.piggy.bank.resource.models;

import java.sql.Date;

public class Deposit {

	private String id;
	private String memberid;
	private String groupid;
	private int amount;
	private Date date;
	private String depositMonth;
	private String banktxid;
	private String loanid;
	private int intamount;

	public String getId() {
		return id;
	}

	public Deposit setId(String id) {
		this.id = id;
		return this;
	}

	public String getMemberid() {
		return memberid;
	}

	public Deposit setMemberid(String memberid) {
		this.memberid = memberid;
		return this;
	}

	public String getGroupid() {
		return groupid;
	}

	public Deposit setGroupid(String groupid) {
		this.groupid = groupid;
		return this;
	}

	public int getAmount() {
		return amount;
	}

	public Deposit setAmount(int amount) {
		this.amount = amount;
		return this;
	}

	public Date getDate() {
		return date;
	}

	public Deposit setDate(Date date) {
		this.date = date;
		return this;
	}

	public String getDepositMonth() {
		return depositMonth;
	}

	public Deposit setDepositMonth(String depositMonth) {
		this.depositMonth = depositMonth;
		return this;
	}

	public String getBanktxid() {
		return banktxid;
	}

	public Deposit setBanktxid(String banktxid) {
		this.banktxid = banktxid;
		return this;
		
	}

	public String getLoanid() {
		return loanid;
	}

	public Deposit setLoanid(String loanid) {
		this.loanid = loanid;
		return this;
	}

	public int getIntamount() {
		return intamount;
	}

	public Deposit setIntamount(int intamount) {
		this.intamount = intamount;
		return this;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + ((banktxid == null) ? 0 : banktxid.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((depositMonth == null) ? 0 : depositMonth.hashCode());
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
		Deposit other = (Deposit) obj;
		if (amount != other.amount)
			return false;
		if (banktxid == null) {
			if (other.banktxid != null)
				return false;
		} else if (!banktxid.equals(other.banktxid))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (depositMonth == null) {
			if (other.depositMonth != null)
				return false;
		} else if (!depositMonth.equals(other.depositMonth))
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
		return "Deposit [id=" + id + ", memberid=" + memberid + ", groupid=" + groupid + ", amount=" + amount
				+ ", date=" + date + ", depositMonth=" + depositMonth + ", banktxid=" + banktxid + ", loanid=" + loanid
				+ ", intamount=" + intamount + "]";
	}

}
