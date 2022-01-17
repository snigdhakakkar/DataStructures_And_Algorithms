package LinkedList;

public class SeparateEvenAndOddNodes {
	
	public static void main(String[] args) {
		Node head  = null;
		Node a = new Node();
		
		head = Node.insert(head, 12);
		head = Node.insert(head, 99);
    	head = Node.insert(head, 8);
    	head = Node.insert(head, 39);
    	head = Node.insert(head, 5);
    	head = Node.insert(head, 70);
    	head = Node.insert(head, 25);
    	
    	a.printList(head);
    	System.out.println();
    	
    	head = separateEvenAndOdd(head); 
    	
    	a.printList(head);
    	System.out.println();
		 
	 }
	
	public static Node separateEvenAndOdd(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		Node evenStartingNode, evenEndingNode, oddStartingNode, oddEndingNode;
		evenStartingNode = evenEndingNode = oddStartingNode = oddEndingNode = null;
		
		while (head != null) {
			if(head.i % 2 == 0) {
				if (evenStartingNode == null) {
					evenStartingNode = head;
					evenEndingNode = evenStartingNode;
				} else {
					evenEndingNode.next = head;
					evenEndingNode = evenEndingNode.next;
				}
			} else {
				if (oddStartingNode == null) {
					oddStartingNode = head;
					oddEndingNode = oddStartingNode;
				} else {
					oddEndingNode.next = head;
					oddEndingNode = oddEndingNode.next;
				}
			}
			
			head = head.next;
		}
		
		evenEndingNode.next = oddStartingNode;
		oddEndingNode.next = null;
		return evenStartingNode;
		
	}

}
