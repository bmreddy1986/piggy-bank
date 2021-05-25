package com.piggy.bank.repository.models;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class MemberIdentity implements Serializable {

	@NotNull
	private String memberid;
	@NotNull
	private String groupid;

	public String getMemberid() {
		return memberid;
	}

	public MemberIdentity setMemberid(String memberid) {
		this.memberid = memberid;
		return this;
	}

	public String getGroupid() {
		return groupid;
	}

	public MemberIdentity setGroupid(String groupid) {
		this.groupid = groupid;
		return this;
	}

}
