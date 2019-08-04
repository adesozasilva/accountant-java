# Accountant-Java

***Accounting Operations For Java***

### Feature

 * [x] Calculates compound interest with monthly contributions
 
 
### Example

```java

 BigDecimal amount = CompoundInterestCalculator.build()
				.setCurrentPrincipal(80000.00)
				.setInterestRate(0.01)
				.setMonthsQuantities(12)
				.setMonthlyContribution(100.0)
				.calculate();

```

