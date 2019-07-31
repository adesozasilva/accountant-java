package br.com.adesoza.math;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;


/**
 * Unit test for CompoundInterestCalculatorTest.
 */
public class CompoundInterestCalculatorTest {

	@Test
	public void shouldCalculateCompoundInterest() {
		CompoundInterestCalculator calc1 = new CompoundInterestCalculator(80000.00, 0.01, 12, 0.0);
		CompoundInterestCalculator calc2 = new CompoundInterestCalculator(13000.00, 0.01, 12, 0.0);
		CompoundInterestCalculator calc3 = new CompoundInterestCalculator(100.00, 0.006, 12, 100.00);
		
		BigDecimal calculaJurosCompostos = calc1.calculateWithMonthlyContribution();
		BigDecimal valueOf = BigDecimal.valueOf(90146);
		
		BigDecimal calculaJurosCompostos2 = calc2.calculateWithMonthlyContribution();
		BigDecimal valueOf2 = BigDecimal.valueOf(14648.73);
		
		BigDecimal calculaJurosCompostosComAportesMensais = calc3.calculateWithMonthlyContribution();
		BigDecimal valueOf3 = BigDecimal.valueOf(1247.85);
		
		assertTrue(calculaJurosCompostos.compareTo(valueOf) == 0); 
		assertTrue(calculaJurosCompostos2.compareTo(valueOf2) == 0); 
		
		assertEquals(calculaJurosCompostosComAportesMensais, valueOf3); 
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldThrowExcpetionToInvalidValues() {
		CompoundInterestCalculator calc = new CompoundInterestCalculator(null, 0.01, 0, 0.0);
		calc.calculateWithMonthlyContribution();
		
		
	}
	

}
