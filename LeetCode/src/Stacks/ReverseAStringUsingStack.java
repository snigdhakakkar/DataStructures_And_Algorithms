package Stacks;

import java.util.Stack;

public class ReverseAStringUsingStack {
	
	public static void main(String[] args) {
		
		ReverseAStringUsingStack a = new ReverseAStringUsingStack();
		String s = "I love coding in java";
		System.out.println(a.reverseString(s));
	}
	
	public String reverseString(String s) {
		Stack<Character> st = new Stack<Character>();
		String reverseString = "";
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			st.push(c);
		};
		
		while(!st.isEmpty()) {
			 reverseString =  reverseString + st.pop();
		}
		
		return  reverseString;
	}

}
