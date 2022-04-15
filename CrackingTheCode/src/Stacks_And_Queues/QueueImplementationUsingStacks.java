package Stacks_And_Queues;

import java.util.Stack;

public class QueueImplementationUsingStacks {

		Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();
		
		//Time Complexity: O(1)
		public void enqueue(int val) {
			s1.push(val);
		}
		
		//Time Complexity: O(N)
		public int dequeue() {       
			if(!s2.empty()) {
				return s2.pop();
			}
			
			if(s1.isEmpty()) {
				return -1;
			}
			
			while(!s1.empty()) {
				s2.push(s1.pop());
			}
			
			return s2.pop();
		}
		
		public static void main(String[] args) {
			QueueImplementationUsingStacks a = new QueueImplementationUsingStacks();
			
			a.enqueue(12);
			a.enqueue(2);
			a.enqueue(7);
			a.enqueue(27);
			a.enqueue(18);
			a.enqueue(80);
			
			System.out.println("Removed element: " + a.dequeue());
			
			a.enqueue(81);
			
			System.out.println("Removed element: " + a.dequeue());
			System.out.println("Removed element: " + a.dequeue());
			System.out.println("Removed element: " + a.dequeue());
			System.out.println("Removed element: " + a.dequeue());
			System.out.println("Removed element: " + a.dequeue());
			System.out.println("Removed element: " + a.dequeue());
			System.out.println("Removed element: " + a.dequeue());
		}

}
