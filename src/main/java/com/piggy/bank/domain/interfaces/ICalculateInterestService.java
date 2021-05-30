package com.piggy.bank.domain.interfaces;

public interface ICalculateInterestService {
	
	public double calcInterest(double principal, double roi);

	public double calcPartialInterest(double p, double r);

}
