package Stacks;

import java.util.Stack;

public class NextLargerValueOfEachArray {
	
	public static void main(String[] args) {
		
		NextLargerValueOfEachArray a = new NextLargerValueOfEachArray();
		
		int[] arr = {1, 4, 2, 6, 1, 8, 3};
		
		a.nextLargerValueOfEachArray(arr);
	}
	
	public void nextLargerValueOfEachArray(int[] arr) {
		if(arr.length == 0) {
			return;
		}
		
		Stack<Integer> s = new Stack<Integer>();
		
		s.push(arr[0]);
		
		for(int i = 1; i < arr.length; i++) {
			while(!s.isEmpty() && arr[i] > s.peek()) {
				s.pop();
				System.out.print(arr[i] + " ");
			}
			
			s.push(arr[i]);
		}
		while(!s.isEmpty()) {
			System.out.print(-1);
			s.pop();
		}
	}
}
