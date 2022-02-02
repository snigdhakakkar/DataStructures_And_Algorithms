package Stacks;

public class StackLinked {
	LinkedList.Node front;
	
	public LinkedList.Node getNewNode(int val){
		LinkedList.Node a = new LinkedList.Node();
		a.i = val;
		a.next = null;
		return a;
	}
	
	public void push (int val) {
		if(front == null) {
			front = getNewNode(val);
			return;
		}
		
		LinkedList.Node t = getNewNode(val);
		t.next = front;
		front = t;
	}
	
	public int pop() {
		if(front == null) {
			System.out.println("Stack is empty.");
			return Integer.MIN_VALUE;
		}
		
		int t = front.i;
		front = front.next;
		return t;
	}
	
	public int top() {
		if(front == null) {
			System.out.println("Stack is empty.");
			return Integer.MIN_VALUE;
		}
		return front.i;
	}
	

}
