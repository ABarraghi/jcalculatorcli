package com.github.abarraghi;

import java.util.Scanner;
import java.util.Iterator;

public class CalculatorMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner reader = new Scanner(System.in);
		
		String input = "";
		int i = 0;
		Calculator calc = null;
		PostfixConverter pf = null;
		float result = 0;
		String postfix = "";
		
		System.out.println("Welcome to the jCalculator - Command Line Edition!");
		System.out.println("The calculator accepts the following operators:");
		System.out.println("1. Multiplication (*) | 6. Factorial (!) ");
		System.out.println("2. Division (/)       | 7. Negation (~) ");
		System.out.println("3. Addition (+)       | 8. Modulus (%) ");
		System.out.println("4. Subtraction (-)    | 9. Parentheses ( () )");
		System.out.println("5. Exponentiation (^) |  ");
		
		System.out.println("\nInput a formula: ");
		
		while(!(input = reader.nextLine()).equals("X")) {
			
			i++;
			
			try {
				System.out.println("input: " + input);
				Thread.sleep(3000);
			} catch(Exception e) { }
			
			String tokenizedForm = tokenizeInput(input);
			
			String[] formula = tokenizedForm.split(",");
			
			try {
				pf = new PostfixConverter(formula);
				
			} catch(Exception e) {
				System.err.println("Bad inputs!" + e.getMessage());
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
			
			System.out.println("\nInput a formula: ");
			
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
