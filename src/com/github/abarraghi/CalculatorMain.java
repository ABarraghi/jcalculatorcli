package com.github.abarraghi;

import java.util.Scanner;
import java.util.Iterator;

public class CalculatorMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] testers = {
				"5 + 2",
				"5 - 2",
				"Nonesense",
				"5 * 2",
				"5 / 2",
				"X",
				"5+2",
				"5-2",
				"5*2",
				"5/2",
				"5$2",
				"5             +      2"
		};
		
		String input = "";
		int i = 0;
		Calculator calc = null;
		float result = 0;
		
		while(!(input = testers[i]).equals("X")) {
			
			i++;
			
			try {
				System.out.println("input: " + input);
				Thread.sleep(3000);
			} catch(Exception e) { }
			
			String formula = arrToString(input.split(" "));
			
			try {
				System.out.println("formula: " + formula);
				Thread.sleep(3000);
			} catch(Exception e) { }
			
			try {
				float operandOne = Float.parseFloat(Character.toString(formula.charAt(0)));
				float operandTwo = Float.parseFloat(Character.toString(formula.charAt(2)));
				char operator = formula.charAt(1);
				calc = new Calculator(operandOne,operandTwo,operator);
			} catch(Exception e) {
				System.err.println("Bad inputs!");
				continue;
			}
			
			result = calc.calculate();

			try {
				System.out.println("result: " + result);
				Thread.sleep(3000);
			} catch(Exception e) { }
			
		}
		
		try {
			System.out.print("Stopping Calculator, goodbye!");
			Thread.sleep(3000);
		} catch(Exception e) { }
		
	}
	
	public static String arrToString(String[] arr) {
		String str = "";
		for(String elem : arr) {
			str += elem;	
		}
		return str;
	}
	
	
}
