package Stacks_And_Queues;

import java.util.Stack;

public class SortStack {
	
	public static void sort(Stack<Integer> s) {
		Stack<Integer> r = new Stack<Integer>();
		
		while(!s.isEmpty()) {
			//Insert each element in s in sorted order into r. 
			int tmp = s.pop();
			while(!r.isEmpty() && r.peek() > tmp) {
				s.push(r.pop());
			}
			r.push(tmp);
		}
		
		/* Copy the elements back. */
		while (!r.isEmpty()) {
			s.push(r.pop());
		}
	}
	
	public static void main(String [] args) {
		Stack<Integer> s = new Stack<Integer>();
		
		for (int i = 0; i < 10; i++) {
			int r = randomIntInRange(0,  1000);
			s.push(r);
		}
		
		sort(s);
		
		while(!s.isEmpty()) {
			System.out.println(s.pop());
		}
	}
	
	public static int randomIntInRange(int min, int max) {
		return randomInt(max + 1 - min) + min;
	}
	
	public static int randomInt(int n) {
		return (int) (Math.random() * n);
	}

}
