package Stacks_And_Queues;

import java.util.EmptyStackException;

public class FixedMultiStack {
	
	private static int number_of_stacks = 3;
	private static int stackCapacity;
	private static int[] values;
	private static int[] sizes;
	
	public FixedMultiStack(int stackSize) {
		stackCapacity = stackSize;
		values = new int[stackSize * number_of_stacks];
		sizes = new int[number_of_stacks];
		}
		
		//push values onto the stack
		public static void push(int stackNum, int value) throws Exception
		{
			//check whether we have space for the next element}
			if(isFull(stackNum)) {
				throw new Exception();
			}
			
			//increment stack pointer and then update the top value
			sizes[stackNum]++;
			values[indexOfTop(stackNum)] = value;
		}
		
		//Pop item from the stack
		public static int pop(int stackNum) {
			if(isEmpty(stackNum)) {
				throw new EmptyStackException();
			}
			int topIndex = indexOfTop(stackNum);
			int value = values[topIndex];
			values[topIndex] = 0;
			sizes[stackNum]--;
			return value;
		}
		
		//Return top element
		public static int peek(int stackNum) {
			if (isEmpty(stackNum)) {
				throw new EmptyStackException();
			}		
			return values[indexOfTop(stackNum)];
		}
		
		//Return if stack is empty
		public static boolean isEmpty(int stackNum) {
			return sizes[stackNum] == 0;
		}
		
		//Return if stack is Full
		public static boolean isFull(int stackNum) {
			return sizes[stackNum] == stackCapacity;
		}
		
		//Returns index of the top of the stack
		public static int indexOfTop(int stackNum) {
			int offset = stackNum * stackCapacity;
			int size = sizes[stackNum];
			return offset + size - 1;
		}
		
		//Returns values
		public static int[] getValues() {
			return values;
		}
		
		//Returns stack values
		public static int[] getStackValues(int stackNum) {
			int[] items = new int[sizes[stackNum]];
			for (int i = 0; i < items.length; i++) {
				items[i] = values[stackNum * stackCapacity + i];
			}
			return items;
		}
		
		public static String stackToString(int stackNum) {
			int[] items = getStackValues(stackNum);
			return stackNum + ": " + arrayToString(items);
		}
		
		public static String arrayToString(int[] array) {
			if (array == null) return "";
			return arrayToString(array, 0, array.length - 1);
		}
		
		public static String arrayToString(int[] array, int start, int end) {
			StringBuilder sb = new StringBuilder();
			for (int i = start; i <= end; i++) {
				int v = array[i];
				sb.append(v + ", ");
			}
			return sb.toString();
		}
		
		public static void printStacks(FixedMultiStack stacks) {
			System.out.println(arrayToString(stacks.getValues()));
		}
		
		public static void main(String [] args) throws Exception  {
			FixedMultiStack stacks = new FixedMultiStack(4);
			printStacks(stacks);
			stacks.push(0, 10);
			printStacks(stacks);
			stacks.push(1, 20);
			printStacks(stacks);
			stacks.push(2, 30);
			printStacks(stacks);
			
			stacks.push(1, 21);
			printStacks(stacks);
			stacks.push(0, 11);
			printStacks(stacks);
			stacks.push(0, 12);
			printStacks(stacks);
			
			stacks.pop(0);
			printStacks(stacks);
			
			stacks.push(2, 31);
			printStacks(stacks);
			
			stacks.push(0, 13);
			printStacks(stacks);
			stacks.push(1, 22);
			printStacks(stacks);
			
			stacks.push(2, 31);
			printStacks(stacks);
			stacks.push(2, 32);
			printStacks(stacks);
		}

}
