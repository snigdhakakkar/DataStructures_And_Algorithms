package Stacks_And_Queues;

import java.util.Stack;

public class MergeSortStack {
	
	public static void main(String [] args) {
		Stack<Integer> s = new Stack<Integer>();
		
		for (int i = 0; i < 4; i++) {
			int r = randomIntInRange(0,  1000);
			s.push(r);
		}
		
		Stack<Integer> r = mergesort(s);
		
		while(!r.isEmpty()) {
			System.out.println(r.pop());
		}
	}     
	
	public static int randomIntInRange(int min, int max) {
		return randomInt(max + 1 - min) + min;
	}
	
	public static int randomInt(int n) {
		return (int) (Math.random() * n);
	}
	
	public static Stack<Integer> mergesort(Stack<Integer> inStack){
		if (inStack.size() <= 1) {
			return inStack;
		}
		
		Stack<Integer> left = new Stack<Integer>();
		Stack<Integer> right = new Stack<Integer>();
		int count = 0;
		
		while (inStack.size() != 0) {
			count++;
			if (count % 2 == 0) {
				left.push(inStack.pop());
			} else {
				right.push(inStack.pop());
			}
		}
		
		left = mergesort(left);
		right = mergesort(right);
		
		while (left.size() > 0 || right.size() > 0) {
			if (left.size() == 0) {
				inStack.push(right.pop());
			} else if (right.size() == 0) {
				inStack.push(left.pop());
			} else if (right.peek().compareTo(left.peek()) <= 0) {
				inStack.push(left.pop());
			} else {
				inStack.push(right.pop());
			}
		}
		
		Stack<Integer> reverseStack = new Stack<Integer>();
		while (inStack.size() > 0) {
			reverseStack.push(inStack.pop());
		}
		return reverseStack;
	}
}
