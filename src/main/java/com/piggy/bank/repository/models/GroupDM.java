package com.piggy.bank.repository.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "table_group")
public class GroupDM {

	@Id
	private String id;
	private String name;
	private String organizerid;
	private int deposit;
	private int roi;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrganizerid() {
		return organizerid;
	}

	public void setOrganizerid(String organizerid) {
		this.organizerid = organizerid;
	}

	public int getDeposit() {
		return deposit;
	}

	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	public int getRoi() {
		return roi;
	}

	public void setRoi(int roi) {
		this.roi = roi;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + deposit;
		result = prime * result + roi;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((organizerid == null) ? 0 : organizerid.hashCode());
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
		GroupDM other = (GroupDM) obj;
		if (deposit != other.deposit)
			return false;
		if (roi != other.roi)
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
		return "id:" + id + " name:" + name + " deposit:" + deposit + " roi:" + roi + " organizerid:" + organizerid;
	}
}
