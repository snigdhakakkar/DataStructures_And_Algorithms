package LinkedList;

public class DeleteAlternateNodes {
	
	public static void main(String[] args) {
		Node head  = null;
		Node a = new Node();
		
		head = Node.insert(head, 12);
		head = Node.insert(head, 99);
    	head = Node.insert(head, 37);
    	head = Node.insert(head, 8);
    	head = Node.insert(head, 18);
    	
    	a.printList(head);
    	System.out.println();
    	
    	Node deletedAltList = deleteAlternateNodes(head); 
    	
    	a.printList(deletedAltList);
    	System.out.println();
		 
	 }
	
	public static Node deleteAlternateNodes (Node head) {
		if (head == null || head.next == null ) {
			return head; 
		}
		
		Node headList = head;
		
		while(head != null && head.next != null) {
			head.next = head.next.next;
			head = head.next;
		}
		
		return headList;
	}

}
