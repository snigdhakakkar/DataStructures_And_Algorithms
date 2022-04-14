package Stacks_And_Queues;

import java.util.Stack;

public class GetStackMinInBigOOf1 {
		
		Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();
		int min = Integer.MAX_VALUE;
		
		public void pushElementInStack(int val) {
			s1.push(val);
			
			if(s2.isEmpty()) {
				s2.push(val);
			} else {
				if(val < s2.peek()) {
					s2.push(val);
				}
			}
		}
		
		public int popElementFromStack() {
			int val = s1.pop();
			
			if(val == s2.peek()) {
				s2.pop();
			}
			return val;
		}
		
		public int minElement() {
			if(s2.isEmpty()) {
				return -1;
			} 
			
			return s2.peek();
		}
		
		public static void main(String[] args) {
			GetStackMinInBigOOf1 a = new GetStackMinInBigOOf1();
			
			int[] arr = {7, 8, 3, 1, 5};
			
			for(int i = 0; i < arr.length; i++) {
				a.pushElementInStack(arr[i]);
			}
			
			System.out.print(a.minElement() + " ");
			
			a.popElementFromStack();
			System.out.print(a.minElement() + " ");
			
			a.popElementFromStack();
			System.out.print(a.minElement() + " ");
			
			a.popElementFromStack();
			System.out.print(a.minElement() + " ");
			
			a.popElementFromStack();
			System.out.print(a.minElement() + " ");
			
		}

}
