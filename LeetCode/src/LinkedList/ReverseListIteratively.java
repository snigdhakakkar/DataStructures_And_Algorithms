package LinkedList;

public class ReverseListIteratively {
	
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
    	
    	head = reverseIteratively(head); 
    	
    	a.printList(head);
    	System.out.println();
		 
	 }
	
	public static Node reverseIteratively(Node node) {
			if (node == null || node.next == null ) {
				return node;
			}
			
			Node prev, next;
			
			prev = next = null;
			
			while (node != null) {
				next = node.next;
				node.next = prev;
				prev = node;
				node = next;
			}
			
			return prev;
		}
	
	

}
