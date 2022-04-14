package Stacks_And_Queues;

public class ThreeStacksIn1Array {
	
	
	int[] topOfStack; //this array is going to point to top of a particular stack and we are going to initialize it to -1
	int[] stackData; //this is our data array and it is going to be of length = capacity
	int[] nextIndex; /*two purposes: first, it is going to tell us if we are at a given node, then what would be the next available index in a stack ; second, when the element is set, 
	it is going to point to the previous value in the stack*/
	
	int nextAvailable = 0; //when we want to add an item to our stack, this pointer is going to tell us which index in the data array to put the data at
	
	public ThreeStacksIn1Array(int numStacks, int capacity) {
		topOfStack = new int[numStacks]; //{-1,-1,-1}
		for(int i = 0; i < topOfStack.length; i++) {
			topOfStack[i] = -1;
		}
		stackData = new int[capacity]; //{0,0,0,0,0,0}
		nextIndex = new int[capacity];
		for(int i = 0; i < nextIndex.length - 1; i++) {
			nextIndex[i] = i+1; //initially, nextIndex has been initialized to one position next to the current one i.e. i + 1 {1,2,3,4,5,6}
		}
		nextIndex[nextIndex.length - 1] = -1;
	}
	
	/*stacks.push(0,5) --> get nextAvalable --> set the data as 5 in stackData: {5, 0, 0, 0, 0, 0}; set nextAvailable = 1 now, set topOfStack = {0, -1, -1}; 
	 * now, we set nextIndex[0] pointing to the previous value in stack 0: {-1, 2, 3, 4, 5, -1} as topIndex was -1 earlier for stacknum = 0
	 * Suppose now, we need to push (0,6) i.e. 6 in stacknum = 0 --> get nextAvailable --> set the data as 6 in stackData: {5, 6, 0, 0, 0, 0}; set nextAvailable = 2 now, set topOfStack = {1, -1, -1}
	 * now, we set nextIndex[1] pointing to the previous value in stack 0: {-1, 0, 3, 4, 5, -1} as topIndex was 0 earlier for stacknum = 0
	 * Now, add (1,7) --> get nextAvailable --> set the data as 7 in stackData: {5, 6, 7, 0, 0, 0}; set nextAvailable = 3 now, set topOfStack: {1, 2, -1} as topOfStack for stack 1 is at index 2;
	 * now, we set nextIndex pointing to the previous value in stack 1: {-1, 0, -1, 4, 5, -1} as topIndex was -1 earlier for stacknum = 1
	 * Now suppose we wish to pop an element: stacks.pop(0) --> see the topOfIndex for stacknum = 0, here topOfStack = 1 for stacknum = 0; thus we return the index 1 value from stackData which is 6
	 * we do not replace this value with 0 in stackData as we are not checking stackData values any time, we are just relying on indices.
	 * Now we are going to reset nextIndex as nextAvailable which is 3: {-1, 3, -1, 4, 5, -1} and we reset nextAvailable to 1. We are going to set topOfStack: {0, 2, -1}
	 * 
	 */
	
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
