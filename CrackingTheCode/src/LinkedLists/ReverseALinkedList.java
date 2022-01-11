package LinkedLists;

public class ReverseALinkedList {
	
	public static LinkedListNode reverse(LinkedListNode head) {
		
		LinkedListNode current = head;
		LinkedListNode previous = null;
		
		while (current != null) {
			LinkedListNode temp = current.next;
			current.next = previous;
			previous = current;
			current = temp;
		}
		return previous;
	}
	
	public static int randomInt(int n) {
		return (int) (Math.random() * n);
	}

	public static int randomIntInRange(int min, int max) {
		return randomInt(max + 1 - min) + min;
	}
	
	public static LinkedListNode randomLinkedList(int N, int min, int max) {
		LinkedListNode root = new LinkedListNode(randomIntInRange(min, max),
				null, null);
		LinkedListNode prev = root;
		for (int i = 1; i < N; i++) {
			int data = randomIntInRange(min, max);
			LinkedListNode next = new LinkedListNode(data, null, null);
			prev.setNext(next);
			prev = next;
		}
		return root;
	}
	
	public static void main(String[] args) {
		LinkedListNode head = randomLinkedList(10, 0, 10);
		System.out.println(head.printForward());
		LinkedListNode newHead = reverse(head); 
		System.out.println(newHead.printForward());
	}

}
