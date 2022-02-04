package Stacks;

import java.util.Stack;

public class DelimiterMatching {
	
	public static void main(String[] args) {
		
		DelimiterMatching a = new DelimiterMatching();
		
		String st = "a[b+{c*(u-r)}]";
		System.out.println(a.checkCorrectBacket(st));
		
		String st1 = "a[b+{c*(u-r)}}]";
		System.out.println(a.checkCorrectBacket(st1));
		
		String st2 = "a+b+c*u-r)}]";
		System.out.println(a.checkCorrectBacket(st2));
		
		String st3 = "a[[b+{c*(u-r)}]";
		System.out.println(a.checkCorrectBacket(st3));
	}
	
	public boolean checkCorrectBacket(String s) {
		Stack<Character> st = new Stack<Character>();
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			switch(c) {
				case '[':
				case '{':
				case '(':
					st.push(c);
					break;
				case '}':
				case ']':
				case ')':
					if(!st.isEmpty()) {
						char ch = st.pop();
						if(ch == '{' && c != '}' ||
								ch == '[' && c != ']' ||
								ch == '(' && c != ')' ) {
							System.out.println("Not valid bracket: " + c);
							return false;
						}
					}
						else {
							System.out.println("Not valid brackets");
							return false;
						}
						break;
					}
		}
		if(!st.isEmpty()) {
			System.out.println("Not valid bracket");
			return false;
		}
		return true;
	}

}
