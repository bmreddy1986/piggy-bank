package com.piggy.bank.repository.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "table_m2s_grp_mem")
public class GrpAndMemRelationDM {

	@Id
	private String grpid;
	private String grpstatus;
	private String memid;
	private String memstatus;

	public String getGrpid() {
		return grpid;
	}

	public void setGrpid(String grpid) {
		this.grpid = grpid;
	}

	public String getGrpstatus() {
		return grpstatus;
	}

	public void setGrpstatus(String grpstatus) {
		this.grpstatus = grpstatus;
	}

	public String getMemid() {
		return memid;
	}

	public void setMemid(String memid) {
		this.memid = memid;
	}

	public String getMemstatus() {
		return memstatus;
	}

	public void setMemstatus(String memstatus) {
		this.memstatus = memstatus;
	}

	public String toString() {
		return "grpid:" + grpid + " grpstatu:" + grpstatus + " memid:" + memid + " memstatus:" + memstatus;
	}
}
