package com.piggy.bank.resource.models;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class EMI {

	private int outstanding;
	private double interest;
	@JsonFormat(pattern="dd-MMM-yyyy")
	private OffsetDateTime startDate;
	@JsonFormat(pattern="dd-MMM-yyyy")
	private OffsetDateTime endDate;
	
	public int getOutstanding() {
		return outstanding;
	}
	public EMI setOutstanding(int outstanding) {
		this.outstanding = outstanding;
		return this;
	}
	public double getInterest() {
		return interest;
	}
	public EMI setInterest(double interest) {
		this.interest = interest;
		return this;
	}
	public OffsetDateTime getStartDate() {
		return startDate;
	}
	public EMI setStartDate(OffsetDateTime startDate) {
		this.startDate = startDate;
		return this;
	}
	public OffsetDateTime getEndDate() {
		return endDate;
	}
	public EMI setEndDate(OffsetDateTime endDate) {
		this.endDate = endDate;
		return this;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + outstanding;
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
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
		EMI other = (EMI) obj;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (interest != other.interest)
			return false;
		if (outstanding != other.outstanding)
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "EMI [outstanding=" + outstanding + ", interest=" + interest + ", startDate=" + startDate + ", endDate="
				+ endDate + "]";
	}

}
