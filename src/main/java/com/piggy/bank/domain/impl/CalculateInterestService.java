package com.piggy.bank.domain.impl;

import java.time.OffsetDateTime;

import com.piggy.bank.domain.interfaces.ICalculateInterestService;

public class CalculateInterestService implements ICalculateInterestService {
	
	/*
	 * Month interest = p*(x/12)*(y/30)*(r/100)
	 * "p" is principal/outstanding amount
	 * "x" is no. of months
	 * "y" is no. of days (in case of partial month
	 * "r" is rate of interest
	 */
	@Override
	public double calcPartialInterest(double p, double r) {
		int y = -1;
		OffsetDateTime current = OffsetDateTime.now();
		if(current.getDayOfMonth() < current.getMonth().length(false) )
			y = current.getMonth().length(false) - current.getDayOfMonth();
		
		return Math.round(p * (1/12.0) * (y/30.0) * (r/100.0));
	}
		
	/*
	 * interest = p*(x/12)*(r/100)
	 * "p" is principal/outstanding amount
	 * "x" is no. of months
	 * "r" is rate of interest
	 */
	@Override 
	public double calcInterest(double p, double r) {
		return Math.round(p * (1/12.0) * (r/100.0));
	}
	
}
