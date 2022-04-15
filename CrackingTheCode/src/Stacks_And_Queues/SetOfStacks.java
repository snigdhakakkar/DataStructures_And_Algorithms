package Stacks_And_Queues;

import java.util.ArrayList;
import java.util.EmptyStackException;
import Stacks_And_Queues.Stack;

public class SetOfStacks {
	
	ArrayList<Stack> stacks = new ArrayList<Stack>();
	public int capacity;
	
	public SetOfStacks(int capacity) {
		this.capacity = capacity;
	}      
	
	public Stack getLastStack() {
		if (stacks.size() == 0) {
			return null;
		}
		
		return stacks.get(stacks.size() - 1);
		
	}
	
	public void push(int val) {
		Stack last = getLastStack();
		
		if (last != null && !last.isFull()) { //add to the last existing stack
			last.push(val);
		} else { //create a new stack
			Stack stack = new Stack(capacity);
			stack.push(val);
			stacks.add(stack);
		}
	}
	
	public int pop() {
		Stack last = getLastStack();
		
		if (last == null) {
			throw new EmptyStackException();
		}
		
		int val = last.pop();
		if (last.size == 0) {
			stacks.remove(stacks.size() - 1);
		}
		return val;
		
	}
	
	public boolean isEmpty() {
		Stack last = getLastStack();
		return last == null || last.isEmpty();
	}
	
	public int popAt(int index) {
		return leftShift(index, true);
	}
	
	public int leftShift(int index, boolean removeTop) {
		Stack stack = stacks.get(index);
		int removed_item;
		if (removeTop) {
			removed_item = stack.pop();
		} else {
			removed_item = stack.removeBottom();
		}
		
		if (stack.isEmpty()) {
			stacks.remove(index);
		} else if (stacks.size() > index + 1) {
			int v = leftShift(index + 1, false);
			stack.push(v);
		}
		return removed_item;
	}
	
	public static void main(String[] args) {
		int capacity_per_substack = 5;
		SetOfStacks set = new SetOfStacks(capacity_per_substack);
		for (int i = 0; i < 34; i++) {
			set.push(i);
		}
		for (int i = 0; i < 34; i++) {
			System.out.println("Popped " + set.pop());
		}
	}
}
