package Stacks_And_Queues;

import java.util.EmptyStackException;

import Stacks_And_Queues.Node;

@SuppressWarnings("unused")
public class Stack {
	
	private int capacity;
	public Node top;
	public Node bottom;
	public int size = 0;
	
	public Stack(int capacity) {
		this.capacity = capacity;
	}
	
	public boolean isFull() { 
		return capacity == size; 
	}
	
	public void join(Node above, Node below) {
		if (below != null) below.above = above;
		if (above != null) above.below = below;
	}
	
	public boolean push(int val) {
		if (size >= capacity) return false;
		size++;
		Node n = new Node(val);
		if (size == 1) bottom = n;
		join(n, top);
		top = n;
		return true;
	}
	
	public int pop() {
		if (top == null) throw new EmptyStackException();
		Node t = top;
		top = top.below;
		size--;
		return t.value;
	}
	
	public boolean isEmpty() { 
		return size == 0; 
	}
	
	public int removeBottom() {
		Node b = bottom;
		bottom = bottom.above;
		if (bottom != null) bottom.below = null;
		size--;
		return b.value;
		
	}

}
