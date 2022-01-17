package LinkedList;

public class MoveLastNodeToFront {
	
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
    	
    	Node LastNodeMoved = moveLastNodeToFrontNode(head); 
    	
    	a.printList(LastNodeMoved);
    	System.out.println();
		 
	 }
	
	public static Node moveLastNodeToFrontNode(Node node) {
		if (node == null || node.next == null ) {
			return node;
		}
		
		Node head = node;
		
		while(node.next.next != null) {
			node = node.next;
		}
		
		node.next.next = head;
		head = node.next;
		
		node.next = null;
		return head;
	}

}
