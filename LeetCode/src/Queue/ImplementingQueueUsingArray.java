package Queue;

public class ImplementingQueueUsingArray {
	
	int MAX = 5;
	int front = 0;
	int rear = -1;
	int size = 0;
	int[] queue = new int[MAX];
	
	private boolean isFull() {
		if(size == MAX) {
			return true;
		}
		
		return false;
	}
	
	public void enqueue(int val) {
		if(isFull()) {
			System.out.println("Queue is full. Remove some elements.");
			return;
		}
		rear = (rear + 1) % MAX;
		size++;
		queue[rear] = val;
	}
	
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}
		
		return false;
	}
	
	public int dequeue() {
		if(isEmpty()) {
			System.out.println("Queue is empty. Nothing to remove");
			return Integer.MIN_VALUE;
		}
		
		front = front % MAX;
		size--;
		return queue[front++];
	}
	
	public int getSize() {
		return size;
	}
	
	public int getFront() {
		if(isEmpty()) {
			System.out.println("Queue is empty. Nothing at front.");
			return Integer.MIN_VALUE;
		}
		return queue[front];
	}
	
	public int getRear() {
		if(isEmpty()) {
			System.out.println("Queue is empty. Nothing at rear.");
			return Integer.MIN_VALUE;
		}
		return queue[rear];
	}
	
	public static void main(String[] args) {
		ImplementingQueueUsingArray a = new ImplementingQueueUsingArray();
		
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
