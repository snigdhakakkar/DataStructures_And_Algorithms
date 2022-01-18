package LinkedList;

public class SwapNodesPairwise {
	
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
    	
    	head = pairwiseSwapNodeLinks(head); 
    	
    	a.printList(head);
    	System.out.println();
		 
	 }
	
	public static Node pairwiseSwapNodeLinks(Node node) {
		if (node == null || node.next == null) {
			return node;
		}
		
		Node head = node.next;
		
		Node prev = node;
		node = node.next;
		Node next;
		
		while (node != null) {
			next = node.next;
			node.next = prev;
			
			if (next == null || next.next == null) {
				prev.next = next;
				break;
			}
			
			prev.next = next.next;
			
			prev = next;
			node = prev.next;
		}
		
		return head;
	}
	
	
}
