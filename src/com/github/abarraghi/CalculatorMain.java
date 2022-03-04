package com.github.abarraghi;

import java.util.Scanner;
import java.util.Iterator;

public class CalculatorMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] testers = {
				
				"40.5*((20.5+60.5)/30.5)",
				"Nonesense",
				"~(~((1 + 2) * (3 - 4)))",
				"1 + 1 * 2",
				"(3+5)%6",
				"5.2!",
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
			
			String tokenizedForm = tokenizeInput(input);
			
			String[] formula = tokenizedForm.split(",");
			
			try {
				System.out.println(tokenizedForm);
				System.out.println("formula: " + formula);
				Thread.sleep(3000);
			} catch(Exception e) { }
			
			try {
				pf = new PostfixConverter(formula);
				
			} catch(Exception e) {
				System.err.println("Bad inputs!");
				continue;
			}
			
			try {
			postfix = pf.infixToPostfix();
			System.out.println("postfix rep: " + postfix);
			Thread.sleep(3000);
			calc = new Calculator(postfix.split(","));
			result = calc.calculate();
			System.out.println("Result: " + result);
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
	
	/**
	 * Represent a given formula in tokens, separating those tokens by a comma
	 * @param input the formula to be separated by commas
	 * @return tokenized representation of the formula
	 */
	public static String tokenizeInput(String input) {
		char currChar = ' ';
		String tokenized = "";
		boolean digitPrec = false;
		for(int i = 0;i<input.length();i++) {
			currChar = input.charAt(i);
			if(Character.isDigit(currChar)||currChar=='.') {
				tokenized += currChar;
				digitPrec = true;
				continue;
			}
			else if (currChar == ' ') continue;
			else {
				if(digitPrec) { 
					digitPrec = false;
					if(i==(input.length()-1)) tokenized += "," + currChar;
					else
					tokenized += "," + currChar + ",";
				}
				else
					if(i==(input.length()-1)) tokenized += currChar;
					else
					tokenized += currChar + ",";		
			}
			
		}
		
		return tokenized;
	}
	
	
	
	
}
