package Stacks;

public class StackArray {
	int top = 0;
	int MAX = 5;
	int[] a = new int[MAX];
	
	private boolean isFull() {
		if(top == MAX) {
			return true;
		}
		
		return false;
	}
	
	public void insert(int val) {
		if(isFull()) {
			System.out.println("Stack is full.");
			return;
		}
		a[top++] = val;
	}
	
	private boolean isEmpty() {
		if(top == 0) {
			return true;
		}
		
		return false;
	}
	
	public int remove() {
		if(isEmpty()) {
			System.out.println("Stack is empty.");
			return Integer.MIN_VALUE;
		}
		
		return a[--top];
	}
	
	public int top() {
		if(isEmpty()) {
			System.out.println("Stack is empty.");
			return Integer.MIN_VALUE;
		}
		return a[top - 1];
	}

}
