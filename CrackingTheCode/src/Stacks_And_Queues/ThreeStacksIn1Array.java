package Stacks_And_Queues;

public class ThreeStacksIn1Array {
	
	
	int[] topOfStack;
	int[] stackData;
	int[] nextIndex;
	
	int nextAvailable = 0;
	
	public ThreeStacksIn1Array(int numStacks, int capacity) {
		topOfStack = new int[numStacks];
		for(int i = 0; i < topOfStack.length; i++) {
			topOfStack[i] = -1;
		}
		stackData = new int[capacity];
		nextIndex = new int[capacity];
		for(int i = 0; i < nextIndex.length - 1; i++) {
			nextIndex[i] = i+1;
		}
		nextIndex[nextIndex.length - 1] = -1;
	}
	
	public void push(int stack, int value) {
		//ask the interviewer at this stage on how to handle the error
		if(stack < 0 || stack >= topOfStack.length) {
			throw new IndexOutOfBoundsException();
		}
		
		if(nextAvailable < 0) {
		//ask the interviewer what is their desired solution to this
			return;
		}
		
		int currentIndex = nextAvailable;
		nextAvailable = nextIndex[currentIndex];
		stackData[currentIndex] = value;
		nextIndex[currentIndex] = topOfStack[stack];
		topOfStack[stack] = currentIndex;
	}
	
	public int pop(int stack) {
		if(stack < 0 || stack >= topOfStack.length) {
			throw new IndexOutOfBoundsException();
		}
		
		if(topOfStack[stack] < 0) {
			throw new IndexOutOfBoundsException();//checking if the stack is empty and has nothing to pop
		}
		int currentIndex = topOfStack[stack];
		int value = stackData[currentIndex];
		topOfStack[stack] = nextIndex[currentIndex];
		nextIndex[currentIndex] = nextAvailable;
		nextAvailable = currentIndex;
		
		return value;
	}
	
	
	public static void main(String [] args)  {
		// Let us create 3 stacks in an array of size 10
		ThreeStacksIn1Array stacks = new ThreeStacksIn1Array(3, 10);
		stacks.push(0, 10);
		stacks.push(1, 20);
		stacks.push(2, 30);
		
		stacks.push(1, 21);
		stacks.push(0, 11);
		stacks.push(0, 12);
		
		System.out.println("Popped element from stack 2 is " + stacks.pop(2));
		System.out.println("Popped element from stack 1 is " + stacks.pop(1));
		System.out.println("Popped element from stack 0 is " + stacks.pop(0));
		
		stacks.push(2, 31);
		stacks.push(0, 13);
		stacks.push(1, 22);
		
		stacks.push(2, 31);
		stacks.push(2, 32);
		
		System.out.println("Popped element from stack 2 is " + stacks.pop(2));
		System.out.println("Popped element from stack 1 is " + stacks.pop(1));
		System.out.println("Popped element from stack 0 is " + stacks.pop(0));
	}

}
