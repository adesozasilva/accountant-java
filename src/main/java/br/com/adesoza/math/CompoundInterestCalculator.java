package br.com.adesoza.math;

import java.math.BigDecimal;

public class CompoundInterestCalculator {

	private BigDecimal currentPrincipal;
	private Double interestRate;
	private int monthsQuantities;
	private BigDecimal monthlyContribution;

	public CompoundInterestCalculator(Double currentPrincipal, Double interestRate, int monthsQuantities, Double monthlyContribution) {
		if(currentPrincipal == null || interestRate == null || monthsQuantities < 1 || monthlyContribution == null) {
			throw new IllegalArgumentException("Invalid values");
		}
		this.currentPrincipal = BigDecimal.valueOf(currentPrincipal);
		this.interestRate = interestRate;
		this.monthsQuantities = monthsQuantities;
		this.monthlyContribution = BigDecimal.valueOf(monthlyContribution);
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
	

	public BigDecimal calculateWithMonthlyContribution()  { 
		BigDecimal rendimento = currentPrincipal.multiply(BigDecimal.valueOf(this.interestRate));
		currentPrincipal = currentPrincipal.add(rendimento);
		
		for (int i = 1; i < monthsQuantities; i++) {
			currentPrincipal = currentPrincipal.add(monthlyContribution);
			rendimento = currentPrincipal.multiply(BigDecimal.valueOf(this.interestRate));
			currentPrincipal = currentPrincipal.add(rendimento);
			
		}
		return currentPrincipal.setScale(2, BigDecimal.ROUND_HALF_EVEN);
	}


}
