package com.piggy.bank.resource.models;

import java.util.List;

public class Group {

	private String id;
	private String name;
	private int deposit;
	private String organizerid;
	private int roi;
	private List<Member> member;

	public String getId() {
		return id;
	}

	public Group setId(String id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Group setName(String name) {
		this.name = name;
		return this;
	}
	
	public String getOrganizerid() {
		return organizerid;
	}

	public Group setOrganizerid(String organizerid) {
		this.organizerid = organizerid;
		return this;
	}

	public int getRoi() {
		return roi;
	}

	public Group setRoi(int roi) {
		this.roi = roi;
		return this;
	}

	public int getDeposit() {
		return deposit;
	}

	public Group setDeposit(int deposit) {
		this.deposit = deposit;
		return this;
	}
	
	public List<Member> getMember() {
		return member;
	}

	public Group setMember(List<Member> member) {
		this.member = member;
		return this;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + deposit;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((organizerid == null) ? 0 : organizerid.hashCode());
		result = prime * result + roi;
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
		Group other = (Group) obj;
		if (deposit != other.deposit)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (organizerid == null) {
			if (other.organizerid != null)
				return false;
		} else if (!organizerid.equals(other.organizerid))
			return false;
		return true;
	}

	public String toString() {
		return "id:" + id + " name:" + name + " organizerid:" + organizerid+ " roi:" + roi + " deposit:" + deposit;
	}
}
