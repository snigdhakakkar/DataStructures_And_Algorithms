package Queue;
/*
 * Stack operates on LIFO operation; Queue operates on FIFO operation
 * Basic operations in queue: Enqueue , dequeue, rear and front
 * To construct a queue using a LinkedList we would use two pointers - first and last 
 */
public class ImplementQueueUsingLinkedList {
	
	LinkedList.Node first;
	LinkedList.Node last;
	int size;
	
	public LinkedList.Node getNewNode(int val){
		LinkedList.Node a = new LinkedList.Node();
		a.i = val;
		a.next = null;
		return a;
	}
	
	//Complexity: O(1)
	public void enqueue(int val) {
		if(last == null) {
			first = last = getNewNode(val);
			size++;
			return;
		}
		size++;
		last.next = getNewNode(val);
		last = last.next;
	}
	
	//Complexity: O(1)
	public int getSize() {
		return size;
	}
	
	//Complexity: O(1)
	public boolean isEmpty() {
		if(last == null) {
			return true;
		}
		return false;
	}
	
	//Complexity: O(1)
	public int getFront() {
		if(isEmpty()) {
			System.out.println("Queue is empty. Nothing at front.");
			return Integer.MIN_VALUE;
		}
		return first.i;
	}
	
	//Complexity: O(1)
	public int getRear() {
		if(isEmpty()) {
			System.out.println("Queue is empty. Nothing at rear.");
			return Integer.MIN_VALUE;
		}
		return last.i;
	}
	
	//Complexity: O(1)
	public int dequeue() {
		if(isEmpty()) {
			System.out.println("Queue is empty. Nothing to remove.");
			return Integer.MIN_VALUE;
		}
		size--;
		int t = first.i;
		first = first.next;
		if(first == null) {
			last = null;
		}
		return t;
	}
	
	public static void main(String[] args) {
		ImplementQueueUsingLinkedList a = new ImplementQueueUsingLinkedList();
		
		a.enqueue(12);
		a.enqueue(2);
		a.enqueue(7);
		a.enqueue(27);
		a.enqueue(18);
		a.enqueue(80);
		
		System.out.println("Size: " + a.getSize());
		System.out.println("Front: " + a.getFront());
		System.out.println("Rear: " + a.getRear());
		
		System.out.println("Removed element: " + a.dequeue());
		
		System.out.println("Size: " + a.getSize());
		System.out.println("Front: " + a.getFront());
		System.out.println("Rear: " + a.getRear());
		a.enqueue(81);
		
		System.out.println("Size: " + a.getSize());
		System.out.println("Front: " + a.getFront());
		System.out.println("Rear: " + a.getRear());
		
		System.out.println("Removed element: " + a.dequeue());
		System.out.println("Removed element: " + a.dequeue());
		System.out.println("Removed element: " + a.dequeue());
		System.out.println("Removed element: " + a.dequeue());
		System.out.println("Removed element: " + a.dequeue());
		System.out.println("Removed element: " + a.dequeue());
		System.out.println("Removed element: " + a.dequeue());
	}
	
	
	
	
	

}
