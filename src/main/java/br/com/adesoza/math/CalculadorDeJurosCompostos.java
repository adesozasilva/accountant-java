package br.com.adesoza.math;

import java.math.BigDecimal;

public class CalculadorDeJurosCompostos {

	private BigDecimal capitalInicial;
	private Double taxaDeJuros;
	private int quantidadeDeMeses;
	private BigDecimal aporteMensal;

	public CalculadorDeJurosCompostos(Double capitalInicial, Double taxaDeJuros, int quantidadeDeMeses, Double aporteMensal) {
		if(capitalInicial == null || taxaDeJuros == null || quantidadeDeMeses < 1 || aporteMensal == null) {
			throw new IllegalArgumentException("Valores inválidos");
		}
		this.capitalInicial = BigDecimal.valueOf(capitalInicial);
		this.taxaDeJuros = taxaDeJuros;
		this.quantidadeDeMeses = quantidadeDeMeses;
		this.aporteMensal = BigDecimal.valueOf(aporteMensal);
	}


	@Deprecated
	public BigDecimal calculaJurosCompostos()  { 
		return this.capitalInicial.multiply(BigDecimal.valueOf(potenciacao((1+taxaDeJuros), quantidadeDeMeses))).setScale(2, BigDecimal.ROUND_HALF_EVEN);
	}
	
	private double potenciacao(double base, double expoente) {
		if(expoente == 0) return 1;
		else {
			return base * potenciacao(base, expoente-1);
		}
	}
	

	public BigDecimal calculaJurosCompostosComAportesMensais()  { 
		BigDecimal rendimento = capitalInicial.multiply(BigDecimal.valueOf(this.taxaDeJuros));
		capitalInicial = capitalInicial.add(rendimento);
		
		for (int i = 1; i < quantidadeDeMeses; i++) {
			capitalInicial = capitalInicial.add(aporteMensal);
			rendimento = capitalInicial.multiply(BigDecimal.valueOf(this.taxaDeJuros));
			capitalInicial = capitalInicial.add(rendimento);
			
		}
		return capitalInicial.setScale(2, BigDecimal.ROUND_HALF_EVEN);
	}


}
