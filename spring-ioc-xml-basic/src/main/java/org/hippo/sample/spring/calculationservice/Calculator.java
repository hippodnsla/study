package org.hippo.sample.spring.calculationservice;

public class Calculator {
	
	public Calculation createCalculation() {
		return calculation;
	}
	
	public Calculation getCalculation() {
		return calculation;
	}

	public void setCalculation(Calculation calculation) {
		this.calculation = calculation;
	}
	
	private Calculation calculation;

	
}
