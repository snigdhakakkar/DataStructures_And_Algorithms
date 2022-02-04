package Stacks;

import java.util.Stack;

public class GetMinElementUsingSingleStack {
	
	Stack<Integer> s1 = new Stack<>();
	int minUsingSingleStack = Integer.MAX_VALUE;
	
	public void pushUsingSingleStack(int val) {
		if(s1.isEmpty()) {
			s1.push(val);
			minUsingSingleStack = val;
			return;
		}
		
		if(val > minUsingSingleStack) {
			s1.push(val);
		} else {
			s1.push(2 * val - minUsingSingleStack);
			minUsingSingleStack = val;
		}
	}
	
	public int popUsingSingleStack() {
		if(s1.isEmpty()) {
			return -1;
		}
		
		int val = s1.pop();
		
		if(val < minUsingSingleStack) {
			minUsingSingleStack = 2 * minUsingSingleStack - val;
		}
		
		return val;
	}
	
	public int getMinUsingSingleStack() {
		return minUsingSingleStack;
	}
	

	public static void main(String[] args) {
		GetMinElementUsingSingleStack a = new GetMinElementUsingSingleStack();
		
		int[] arr = {7, 8, 3, 1, 5};
		
		for(int i = 0; i < arr.length; i++) {
			a.pushUsingSingleStack(arr[i]);
		}
		
		System.out.print(a.getMinUsingSingleStack() + " ");
		
		a.popUsingSingleStack();
		System.out.print(a.getMinUsingSingleStack() + " ");
		
		a.popUsingSingleStack();
		System.out.print(a.getMinUsingSingleStack() + " ");
		
		a.popUsingSingleStack();
		System.out.print(a.getMinUsingSingleStack() + " ");
		
		a.popUsingSingleStack();
		System.out.print(a.getMinUsingSingleStack() + " ");
		
		
	}

}
