package br.com.adesoza.math;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;


/**
 * Unit test for simple App.
 */
public class CalculadorDeJurosCompostosTest {

	@Test
	public void deveCalcularJurosCompostos() {
		CalculadorDeJurosCompostos calc1 = new CalculadorDeJurosCompostos(80000.00, 0.01, 12, 0.0);
		CalculadorDeJurosCompostos calc2 = new CalculadorDeJurosCompostos(13000.00, 0.01, 12, 0.0);
		CalculadorDeJurosCompostos calc3 = new CalculadorDeJurosCompostos(100.00, 0.006, 12, 100.00);
		
		BigDecimal calculaJurosCompostos = calc1.calculaJurosCompostosComAportesMensais();
		BigDecimal valueOf = BigDecimal.valueOf(90146);
		
		BigDecimal calculaJurosCompostos2 = calc2.calculaJurosCompostosComAportesMensais();
		BigDecimal valueOf2 = BigDecimal.valueOf(14648.73);
		
		BigDecimal calculaJurosCompostosComAportesMensais = calc3.calculaJurosCompostosComAportesMensais();
		BigDecimal valueOf3 = BigDecimal.valueOf(1247.85);
		
		assertTrue(calculaJurosCompostos.compareTo(valueOf) == 0); 
		assertTrue(calculaJurosCompostos2.compareTo(valueOf2) == 0); 
		
		assertEquals(calculaJurosCompostosComAportesMensais, valueOf3); 
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void deveLancarExcpetionComValoresInvalidos() {
		CalculadorDeJurosCompostos calc1 = new CalculadorDeJurosCompostos(null, 0.01, 0, 0.0);
		calc1.calculaJurosCompostosComAportesMensais();
		
	}
	
	
	
	

}
