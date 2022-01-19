package LinkedList;

public class DeleteTheOnlyGivenNode {
	
	public static void main(String[] args) {
		Node a = new Node();
		
		Node head  = null;
		
		head = Node.insert(head, 22);
		head = Node.insert(head, 7);
    	head = Node.insert(head, 13);
    	head = Node.insert(head, 23);
    	head = Node.insert(head, 8);
    	head = Node.insert(head, 6);
    
    	a.printList(head);
    	System.out.println();
    	
    	deleteOnlyGivenNode(head.next.next.next); 
    	
    	a.printList(head);
	}
	
	public static void deleteOnlyGivenNode(Node node) {
		if(node == null || node.next == null) {
			return;
		}
		
		node.i = node.next.i;
		node.next = node.next.next;
	}

}
