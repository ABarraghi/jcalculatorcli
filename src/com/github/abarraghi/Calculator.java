package com.github.abarraghi;

public class Calculator {
	
	//Each calculation is in the form:
	//operandOne operator operandTwo = result
	private float operandOne;
	private float operandTwo;
	private char operator;
	private float result = 0;
	
	//Constructors
	public Calculator() {}
	
	public Calculator(float operandOne, float operandTwo, char operator){
		this.operandOne = operandOne;
		this.operandTwo = operandTwo;
		this.operator = operator;
	}
	
	//Calculate result of formula, according to operator used
	public float calculate() {
		switch(operator) {
			case '+':
				result  = operandOne + operandTwo;
				break;
			case '-':
				result = operandOne - operandTwo;
				break;
			case '*':
				result = operandOne * operandTwo;
				break;
			case '/':
				result = operandOne / operandTwo;
				break;
			default:
				System.err.println("Invalid operator!");
		}
		return result;
	}
	
	
	
	
	
	

}
