package Stacks_And_Queues;

import java.util.Stack;

public class StackWithMin extends Stack<NodeWithMin> {
	
	public void push(int value) {
        int newMin = Math.min(value, min());
        super.push(new NodeWithMin(value, newMin));
    }
    
    public int min() {
    	if (this.isEmpty()) {
    		return Integer.MAX_VALUE;
    	} else {
    		return peek().min;
    	}
    }
}

//one issue with this is that if we have a quite large stack, a lot of space gets wasted by keeping track of min value
