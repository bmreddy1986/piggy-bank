package com.piggy.bank.repository.models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name = "table_m2m_grp_mem")
public class GrpAndMemRelationDM {

	@EmbeddedId
	private MemberIdentity memberIdentity;
	private String groupstatus;
	private String memberstatus;

	public String getGroupstatus() {
		return groupstatus;
	}

	public GrpAndMemRelationDM setGroupstatus(String groupstatus) {
		this.groupstatus = groupstatus;
		return this;
	}

	public MemberIdentity getMemberIdentity() {
		return memberIdentity;
	}

	public GrpAndMemRelationDM setMemberIdentity(MemberIdentity memberIdentity) {
		this.memberIdentity = memberIdentity;
		return this;
	}

	public String getMemberstatus() {
		return memberstatus;
	}

	public GrpAndMemRelationDM setMemberstatus(String memstatus) {
		this.memberstatus = memstatus;
		return this;
	}

	public String toString() {
		return "memberIdentity:" + memberIdentity + " grpstatu:" + groupstatus + " memstatus:" + memberstatus;
	}
}
