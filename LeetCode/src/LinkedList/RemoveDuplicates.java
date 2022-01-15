package LinkedList;

public class RemoveDuplicates {
	
	public static void main(String[] args) {
		Node head  = null;
		Node a = new Node();
		
		head = Node.insert(head, 8);
		head = Node.insert(head, 8);
    	head = Node.insert(head, 8);
    	head = Node.insert(head, 13);
    	head = Node.insert(head, 34);
    	head = Node.insert(head, 37);
    	head = Node.insert(head, 37);
    	head = Node.insert(head, 45);
    	
    	a.printList(head);
    	System.out.println();
    	
    	head = removeDuplicateSortedList(head);
    	a.printList(head);
    	System.out.println();
	}
	
	public static Node removeDuplicateSortedList (Node head) {
		
		if (head == null || head.next == null) {
			return head;
		}
		
		if (head.i == head.next.i) {
			head.next = head.next.next;
			removeDuplicateSortedList(head);
		} else {
			removeDuplicateSortedList(head.next);
		}
		
		return head;
	}

}
