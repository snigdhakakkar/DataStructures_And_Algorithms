package LinkedLists;

public class Palindrome {
	
	//reverse and compare method - comparison of first half of the LinkedList
	
	public static boolean isPalindrome(LinkedListNode head) {
		LinkedListNode reversed = reverseAndClone(head);
		return isEqual(head, reversed);
	}
	
	public static LinkedListNode reverseAndClone(LinkedListNode head) {
		LinkedListNode current = head;
		LinkedListNode previous = null;
		LinkedListNode temp = null;
		while (current != null) {
			temp = current.next;
			current.next = previous;
			previous = current;
			current = temp;
		}
		head = previous;
		return head;
	}
	
	public static boolean isEqual(LinkedListNode one, LinkedListNode two) {
		while (one != null && two != null) {
			if (one.data != two.data) {
				return false;
			}
			one = one.next;
			two = two.next;
		}
		return true;
		
	}
	
	public static void main(String[] args) {
		int length = 9;
		LinkedListNode[] nodes = new LinkedListNode[length];
		for (int i = 0; i < length; i++) {
			nodes[i] = new LinkedListNode(i >= length / 2 ? length - i - 1 : i, null, null);
		}
		
		for (int i = 0; i < length; i++) {
			if (i < length - 1) {
				nodes[i].setNext(nodes[i + 1]);
			}
			if (i > 0) {
				nodes[i].setPrevious(nodes[i - 1]);
			}
		}
		// nodes[length - 2].data = 9; // Uncomment to ruin palindrome
		
		//LinkedListNode one = new LinkedListNode(0);
		//LinkedListNode two = new LinkedListNode(1);
		//LinkedListNode three = new LinkedListNode(0);
		//one.next = two;
		//two.prev = one;
		//two.next = three;
		//three.prev = two;   
				
		
		LinkedListNode head = nodes[0];
		System.out.println(head.printForward());
		System.out.println(isPalindrome(head));
	}
	
	

}
