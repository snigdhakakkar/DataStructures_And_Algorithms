package Stacks;

public class ImplementStackUsingArray {
	
	public static void main(String[] args) {
		StackArray a = new StackArray();
		
		a.insert(12);
		a.insert(5);
		a.insert(34);
		a.insert(42);
		a.insert(91);
		a.insert(9);
		
		System.out.println(a.remove());
		a.insert(9);
		
		System.out.println("Top: " + a.top());
		
		System.out.println(a.remove());
		System.out.println(a.remove());
		System.out.println(a.remove());
		System.out.println(a.remove());
		System.out.println(a.remove());
		System.out.println(a.remove());
	}

}
