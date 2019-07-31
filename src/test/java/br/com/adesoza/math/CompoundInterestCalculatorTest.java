package br.com.adesoza.math;


import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;


/**
 * Unit test for CompoundInterestCalculatorTest.
 */
public class CompoundInterestCalculatorTest {
	
	@Test
	public void shouldCalculateCompoundInterest1() {
	  BigDecimal value1 = CompoundInterestCalculator.build()
				.setCurrentPrincipal(80000.00)
				.setInterestRate(0.01)
				.setMonthsQuantities(12)
				.setMonthlyContribution(0.0).
				calculate();
	  
	  BigDecimal value2 = CompoundInterestCalculator.build()
				.setCurrentPrincipal(13000.00)
				.setInterestRate(0.01)
				.setMonthsQuantities(12)
				.setMonthlyContribution(0.0).
				calculate();
	  
	  BigDecimal value3 = CompoundInterestCalculator.build()
				.setCurrentPrincipal(100.00)
				.setInterestRate(0.006)
				.setMonthsQuantities(12)
				.setMonthlyContribution(100.00).
				calculate();
		
		BigDecimal valueOf1 = BigDecimal.valueOf(90146);
		BigDecimal valueOf2 = BigDecimal.valueOf(14648.73);
		BigDecimal valueOf3 = BigDecimal.valueOf(1247.85);
		
		assertTrue(value1.compareTo(valueOf1) == 0); 
		assertTrue(value2.compareTo(valueOf2) == 0); 
		assertTrue(value3.compareTo(valueOf3) == 0); 
	}


	
	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowExcpetionToInvalidValues() {
		 CompoundInterestCalculator.build()
					.setInterestRate(0.01)
					.setMonthsQuantities(12)
					.setMonthlyContribution(0.0).
					calculate();
		 
	}
	

}
