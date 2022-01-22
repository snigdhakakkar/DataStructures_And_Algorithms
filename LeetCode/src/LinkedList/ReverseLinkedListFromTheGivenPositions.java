package LinkedList;

public class ReverseLinkedListFromTheGivenPositions {
	
	//driver method
	public static void main(String[] args) {
		Node a = new Node();
		Node head = null;
		
		head = Node.insert(head, 2);
		head = Node.insert(head, 33);
    	head = Node.insert(head, 1);
    	head = Node.insert(head, 3);
    	head = Node.insert(head, 5);
    	head = Node.insert(head, 44);
    	head = Node.insert(head, 57);
    	head = Node.insert(head, 22);
		head = Node.insert(head, 13);
    	head = Node.insert(head, 5);
    	head = Node.insert(head, 23);
		head = Node.insert(head, 43);
    	head = Node.insert(head, 13);
    
    	a.printList(head);
    	System.out.println();
    	
    	Node newHead = reverseLinkedListFromGivenPositions(head, 1, 8);
    	
    	a.printList(newHead);
	}
	
	public static Node reverseLinkedListFromGivenPositions(Node head, int p, int q) {
		//reverses the Linked List iteratively from the given position to the given position
		
		if(head == null || head.next == null || p >=q || p < 1|| q < 1) {
			return head;
		}
		
		Node newHead = head;
		Node prev = null;
		
		for(int i = 1; head != null && i < p; i++) {
			prev = head;
			head = head.next;
		}
		
		if(head == null) {
			return newHead;
		}
		
		Node firstPartLastNode = prev;
		Node secondPartStartNode = head;
		Node next = null;
		
		for(int i = 0; head != null && i <= q - p; i++) {
			next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		
		if(p != 1) {
			firstPartLastNode.next = prev;
		}
		
		secondPartStartNode.next = head;
		
		return p == 1 ? prev : newHead;
	}

}
