package com.github.abarraghi;

import java.util.Scanner;
import java.util.Iterator;

public class CalculatorMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] testers = {
				"5 + 2",
				"4*((2+6)/3)",
				"Nonesense",
				"(1 + 2) * (3 - 4)",
				"10 + 11 * 12",
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
		PostfixConverter pf = null;
		float result = 0;
		String postfix = "";
		
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
//				float operandOne = Float.parseFloat(Character.toString(formula.charAt(0)));
//				float operandTwo = Float.parseFloat(Character.toString(formula.charAt(2)));
//				char operator = formula.charAt(1);
//				calc = new Calculator(operandOne,operandTwo,operator);
				pf = new PostfixConverter(formula);
				
			} catch(Exception e) {
				System.err.println("Bad inputs!");
				continue;
			}
			
//			result = calc.calculate();
			try {
			postfix = pf.infixToPostfix();
			System.out.println("postfix rep: " + postfix);
			Thread.sleep(3000);
			}
			catch(Exception e) {
				System.err.println("Bad inputs!");
			}
			
			
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
