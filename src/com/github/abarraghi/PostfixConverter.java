package com.github.abarraghi;

import java.util.*;

public class PostfixConverter {
	
	private HashMap<Character, Integer> operPrecedence;
	private HashMap<Character, String> operAssociativity;
	private Stack<Character> operStack;
	private String input;
	private String output;
	
	PostfixConverter(){}
	
	PostfixConverter(String input){
		operPrecedence = new HashMap<Character, Integer>();
		operAssociativity = new HashMap<Character, String>();
		operStack = new Stack<Character>();
		this.input = input;
	}

}
