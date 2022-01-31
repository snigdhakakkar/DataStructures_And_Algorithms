package Strings;

import java.util.Stack;

public class ReverseIndividualWords {
	
	public static void main(String[] args) {
		String str = "I love coding in Java";
		
		//Method 1
		System.out.print(reverseIndividualWord1(str));
		System.out.println();
		
		//Method 2
		System.out.print(reverseIndividualWordStringBuilder(str));
		System.out.println();
		
		//Method 3
		reverseIndividualWordStack(str);
	}
	
	public static String reverseIndividualWord1(String str) {
		String finalStr = "";
		String tempStr = "";
		
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			if(c == ' ') {
				finalStr = finalStr + tempStr + " ";
				tempStr = "";
			} else {
				tempStr = c + tempStr;
			}
		}
		
		finalStr = finalStr + tempStr;
		
		return finalStr;
	}
	
	public static String reverseIndividualWordStringBuilder(String str) {
		StringBuilder finalStr = new StringBuilder();
		StringBuilder tempStr = new StringBuilder();
		
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			if(c == ' ') {
				finalStr = finalStr.append(tempStr).append(" ");
				tempStr.setLength(0);
			} else {
				tempStr.insert(0,c);
			}
		}
		finalStr = finalStr.append(tempStr);
		return finalStr.toString();
	}
	
	public static void reverseIndividualWordStack(String str) {
		Stack<Character> st = new Stack<>();
		
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			if(c == ' ') {
				while(!st.isEmpty()) {
					System.out.print(st.pop());
				}
				System.out.print(" ");
			} else {
				st.push(c);
			}
		}
		while(!st.isEmpty()) {
			System.out.print(st.pop());
		}
	}
}
