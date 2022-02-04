package Stacks;

import java.util.Stack;

public class PostfixEvaluation {
	
	public static void main(String[] args) {
		
		PostfixEvaluation a = new PostfixEvaluation();
		
		String postfix1 = "23+1-";
		System.out.println(a.postfixEvaluation(postfix1));
		
		String postfix2 = "234*+";
		System.out.println(a.postfixEvaluation(postfix2));
		
		String postfix3 = "345+*612+/-";
		System.out.println(a.postfixEvaluation(postfix3));
	}
	
	public int postfixEvaluation(String postfix) {
		Stack<Integer> st = new Stack<Integer>();
		
		int x = 0, y = 0;
		char ch[] = postfix.toCharArray();
		for(char c : ch) {
			if(c >= '0' && c <= '9') {
				st.push((int)(c - '0'));
			} else {
				y = st.pop();
				x = st.pop();
				switch(c) {
				case '+':
					st.push(x+y);
					break;
				case '-':
					st.push(x-y);
					break;
				case '*':
					st.push(x*y);
					break;
				case '/':
					st.push(x/y);
					break;
				}
					
			}
		}
		return st.pop();
	}

}
