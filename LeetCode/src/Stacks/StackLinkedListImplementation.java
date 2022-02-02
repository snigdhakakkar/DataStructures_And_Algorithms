package Stacks;

public class StackLinkedListImplementation {
	
	public static void main(String[] args) {
		StackLinked a = new StackLinked();
		
		a.push(12);
		a.push(5);
		a.push(34);
		a.push(42);
		a.push(91);
		a.push(9);
		
		System.out.println(a.pop());
		a.push(39);
		
		System.out.println("Top: " + a.top());
		
		System.out.println(a.pop());
		System.out.println(a.pop());
		System.out.println(a.pop());
		System.out.println(a.pop());
		System.out.println(a.pop());
		System.out.println(a.pop());
	}
}
