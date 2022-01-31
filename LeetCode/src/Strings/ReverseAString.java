package Strings;

import java.util.Stack;

public class ReverseAString {
	
	public static void main(String[] args) {
		
		String s1 = "Coding";
		
		//Method 1 - use inbuilt function of string builder
		StringBuilder sb = new StringBuilder(s1);
		
		sb.reverse();
		System.out.println(sb);
		
		//Method 2
		System.out.println(reverseString1(s1));
		
		//Method 3
		printReverseString(s1);
		
		//Method 4
		System.out.println(reverseString2(s1));
		
		//Method 5
		reverseStack(s1);
	}
	
	public static String reverseString1(String s) {
		String str = "";
		
		for(int i = 0; i < s.length(); i++) {
			str = s.charAt(i) + str;
		}
		
		return str;
	}
	
	public static void printReverseString(String s) {
		
		int start = 0;
		int end = s.length() - 1;
		
		char[] a = s.toCharArray();
		
		while(start < end) {
			char c = a[start];
			a[start] = a[end];
			a[end] = c;
			
			start++;
			end--;
		}
		
		for (int i = 0; i < s.length(); i++) {
			System.out.print(a[i] + "");
		}
		System.out.println();
	}
	
	public static String reverseString2(String s) {
		
		int start = 0;
		int end = s.length() - 1;
		
		char[] a = s.toCharArray();
		
		while(start < end) {
			char c = a[start];
			a[start] = a[end];
			a[end] = c;
			
			start++;
			end--;
		}
		
		return String.copyValueOf(a);
	}
	
	public static void reverseStack(String s) {
		Stack<Character> str = new Stack<>();
		
		for (int i = 0; i < s.length(); i++) {
			str.push(s.charAt(i));
		}
		
		while(!str.isEmpty()) {
			System.out.print(str.pop());
		}
		System.out.println();
		
	}
	
	

}
