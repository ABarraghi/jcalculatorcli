package com.github.abarraghi;

import java.util.Scanner;

public class CalculatorMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] testers = {
				"5 + 2",
				"5 - 2",
				"5 * 2",
				"5 / 2",
				"5+2",
				"5-2",
				"5*2",
				"5/2",
				"5$2"
		};
		
		for(String element : testers) {
			
			String formula = arrToString(element.split(" "));
			System.out.println(formula);
			
			float operandOne = Float.parseFloat(Character.toString(formula.charAt(0)));
			float operandTwo = Float.parseFloat(Character.toString(formula.charAt(2)));
			char operator = formula.charAt(1);
			System.out.println(operandOne + "," + operandTwo + "," + operator);
			
			Calculator calc = new Calculator(operandOne,operandTwo,operator);
			
			float result = calc.calculate();
			
			System.out.println(result);
		}
		

	}
	
	public static String arrToString(String[] arr) {
		String str = "";
		for(String elem : arr) {
			str += elem;	
		}
		return str;
	}
	
	
}
