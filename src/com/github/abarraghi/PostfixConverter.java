package com.github.abarraghi;

import java.util.*;

public class PostfixConverter {
	
	private HashMap<Character, Integer> operPrecedence;
//	private HashMap<Character, String> operAssociativity;
	private Stack<Character> operStack;
	private String input = "";
	private String output = "";
	
	PostfixConverter(){}
	
	PostfixConverter(String input){
		//Instantiate Data Structures
		operPrecedence = new HashMap<Character, Integer>();
//		operAssociativity = new HashMap<Character, String>();
		operStack = new Stack<Character>();
		this.input = input;
	
		//Assign each operator its precedence
		operPrecedence.put('/',3);
		operPrecedence.put('*',3);
		operPrecedence.put('+',2);
		operPrecedence.put('-',2);
		operPrecedence.put('(',0);
		
	}
	
	public String infixToPostfix() {
		
		char currChar = ' ', topChar = ' ';
		int currPrec = 0, topPrec = 0;
		
		for(int i = 0; i < input.length(); i++) {
			
			currChar = input.charAt(i);
				
			if( Character.isDigit(currChar) ) output += currChar;
			
			else if(currChar == '(') operStack.push(currChar);
			
			else if( currChar == ')') {
				
				topChar = operStack.peek();
				
				while(topChar != '(' && !operStack.isEmpty()) {
					output += topChar;
					operStack.pop();
					topChar = operStack.peek();
				}
				
				operStack.pop();
				
			}
			
			else { 
				
				if( !operStack.isEmpty() ) {
					
					currPrec = operPrecedence.get(currChar);
					topChar = operStack.peek();
					topPrec = operPrecedence.get(topChar);
					
					while( (currPrec <= topPrec ) && !operStack.isEmpty()) {
						output += topChar;
						operStack.pop();
						topChar = operStack.peek();
						topPrec = operPrecedence.get(topChar);
					}
					
				}
				
				operStack.push(currChar);
				
			}
			
		}
		
		while( !operStack.isEmpty() ) {
			output += operStack.pop();
		}
		
		return output;
	}
	
	

}
