package com.github.abarraghi;

import java.util.*;

public class PostfixConverter {
	
	private HashMap<Character, Integer> operPrecedence;
	private HashMap<Character, String> operAssociativity;
	private Stack<Character> operStack;
	private String input = "";
	private String output = "";
	
	PostfixConverter(){}
	
	PostfixConverter(String input){
		//Instantiate Data Structures
		operPrecedence = new HashMap<Character, Integer>();
		operAssociativity = new HashMap<Character, String>();
		operStack = new Stack<Character>();
		this.input = input;
	
		//Assign each operator its precedence
		operPrecedence.put('/',3);
		operPrecedence.put('*',3);
		operPrecedence.put('+',2);
		operPrecedence.put('-',2);
		operPrecedence.put('(',0);
		
		//Assign each operator its associativity
		operAssociativity.put('/', "LR");
		operAssociativity.put('*', "LR");
		operAssociativity.put('+', "LR");
		operAssociativity.put('-', "LR");
		operAssociativity.put('(', "na");
	}
	
	public String infixToPostfix() {
		
		char currChar = ' ', topChar = ' ';
		int currPrec = 0, topPrec = 0;
		String topAssoc = "";
		
		for(int i = 0; i < input.length(); i++) {
			
			currChar = input.charAt(i);
			
			if ( Character.isDigit(currChar) ) output += currChar + " ";
			
			else {
				
				if( currChar != ')') {
					
					currPrec = operPrecedence.get(currChar);
					
					if(!operStack.isEmpty()) {
						topChar = operStack.peek();
						topPrec = operPrecedence.get(topChar);
						topAssoc = operAssociativity.get(topChar);
					}
					
					if( (currPrec < topPrec) || ((currPrec == topPrec) && topAssoc.equals("LR")) ) {
						while( (currPrec < topPrec) && !operStack.isEmpty()) {
							if(topChar != '(') output += topChar + " ";
							operStack.pop();
							topChar = operStack.peek();
						}
					}
					
					operStack.push(currChar);
				}
				
				else {
					while(topChar != '(' ) {
						output += operStack.pop() + " ";
					}
					
				}
			}
		}
		output += operStack.pop();
		return output;
	}
	
	

}
