package com.piggy.bank.resource.models;

public class Loan {

	private String id;
	private int amount;
	private int emicount;
	private String banktxid;
	private String status;
	private String parentloanid;
	private int parentloanbal;

	public String getId() {
		return id;
	}

	public Loan setId(String id) {
		this.id = id;
		return this;
	}

	public int getAmount() {
		return amount;
	}

	public Loan setAmount(int amount) {
		this.amount = amount;
		return this;
	}

	public int getEmicount() {
		return emicount;
	}

	public Loan setEmicount(int emicount) {
		this.emicount = emicount;
		return this;
	}

	public String getBanktxid() {
		return banktxid;
	}

	public Loan setBanktxid(String banktxid) {
		this.banktxid = banktxid;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public Loan setStatus(String status) {
		this.status = status;
		return this;
	}

	public String getParentloanid() {
		return parentloanid;
	}

	public Loan setParentloanid(String parentloanid) {
		this.parentloanid = parentloanid;
		return this;
	}

	public int getParentloanbal() {
		return parentloanbal;
	}

	public Loan setParentloanbal(int parentloanbal) {
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Loan other = (Loan) obj;
		if (amount != other.amount)
			return false;
		if (banktxid == null) {
			if (other.banktxid != null)
				return false;
		} else if (!banktxid.equals(other.banktxid))
			return false;
		if (emicount != other.emicount)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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
		return "LoanDM [id=" + id + ", memberid=" + ", amount=" + amount + ", emicount=" + emicount + ", banktxid="
				+ banktxid + ", status=" + status + ", parentloanid=" + parentloanid + ", parentloanbal="
				+ parentloanbal + "]";
	}

}
