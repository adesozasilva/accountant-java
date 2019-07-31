package br.com.adesoza.math;

import java.math.BigDecimal;

public class CompoundInterestCalculator {

	private BigDecimal currentPrincipal;
	private Double interestRate;
	private int monthsQuantities;
	private BigDecimal monthlyContribution;
	
	private CompoundInterestCalculator() {}
	
	public static CompoundInterestCalculator build() {
		return new CompoundInterestCalculator();
	}

	@Deprecated
	public BigDecimal calculateWithoutMonthlyContribution()  { 
		return this.currentPrincipal.multiply(BigDecimal.valueOf(potentiation((1+interestRate), monthsQuantities))).setScale(2, BigDecimal.ROUND_HALF_EVEN);
	}
	
	private double potentiation(double base, double expoente) {
		if(expoente == 0) return 1;
		else {
			return base * potentiation(base, expoente-1);
		}
	}
	

	private  BigDecimal calculateWithMonthlyContribution()  { 
		BigDecimal rendimento = currentPrincipal.multiply(BigDecimal.valueOf(this.interestRate));
		currentPrincipal = currentPrincipal.add(rendimento);
		
		for (int i = 1; i < monthsQuantities; i++) {
			currentPrincipal = currentPrincipal.add(monthlyContribution);
			rendimento = currentPrincipal.multiply(BigDecimal.valueOf(this.interestRate));
			currentPrincipal = currentPrincipal.add(rendimento);
			
		}
		return currentPrincipal.setScale(2, BigDecimal.ROUND_HALF_EVEN);
	}


	public CompoundInterestCalculator setCurrentPrincipal(Double currentPrincipal) {
		this.currentPrincipal =  BigDecimal.valueOf(currentPrincipal);
		return this;
		
	}

	public CompoundInterestCalculator setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
		return this;
	}

	public CompoundInterestCalculator setMonthsQuantities(int monthsQuantities) {
		this.monthsQuantities = monthsQuantities;
		return this;
	}


	public CompoundInterestCalculator setMonthlyContribution(Double monthlyContribution) {
		this.monthlyContribution = BigDecimal.valueOf(monthlyContribution);
		return this;
	}


	public BigDecimal calculate() {
		if(currentPrincipal == null || interestRate == null || monthsQuantities < 1 || monthlyContribution == null) {
			throw new IllegalArgumentException("Invalid values");
		}
		return calculateWithMonthlyContribution();
	}


}
