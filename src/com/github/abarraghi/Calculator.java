package com.github.abarraghi;

import java.util.*;

public class Calculator {
	
	//Each calculation is in the form:
	//operandOne operator operandTwo = result
	private float operandOne;
	private float operandTwo;
	private char operator;
	private float result = 0;
	private String input = "";
	private Stack<Float> calcStack;
	
	//Constructors
	public Calculator() {}
	
	public Calculator(String input){
		this.input = input;
		calcStack = new Stack<Float>();
	}
	
	
	/**
	 * Calculates the result of a given Postfix expression.
	 * Supported operators: +,-,*,/. Supported operands: any 1 digit.
	 * @return Postfix formula result
	 */
	public float calculate() {
		
		for(int i = 0; i < input.length(); i++ ) {
			
			char currChar = input.charAt(i);
			
			if (Character.isDigit(currChar)) calcStack.push(charToFloat(currChar));
			
			else {
				
				try {
					
					operator = currChar;
					operandTwo = calcStack.pop();
					operandOne = calcStack.pop();
					
					calcStack.push(performOperation());
					
				} catch(Exception e) { e.printStackTrace(); }
				
			}
			
		}
		
		return calcStack.pop();
		
	}
	
	//Calculate result of formula, according to operator used
	public float performOperation() {
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
	
	//Converts a 'digit' char to float
	public float charToFloat(char ch) {
		return Float.parseFloat(String.valueOf(ch));
	}

}
