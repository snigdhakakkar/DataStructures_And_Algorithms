package LinkedList;

public class ReverseInGroupOfK {
	
	public static void main(String[] args) {
		Node head  = null;
		Node a = new Node();
		
		head = Node.insert(head, 12);
		head = Node.insert(head, 99);
    	head = Node.insert(head, 8);
    	head = Node.insert(head, 39);
    	head = Node.insert(head, 5);
    	
    	a.printList(head);
    	System.out.println();
    	
    	head = reverseInGroupOfK(head, 3); 
    	
    	a.printList(head);
    	System.out.println();
		 
	 }
	
	public static Node reverseInGroupOfK(Node head, int k) {
		Node prev, next;
		prev = next = null;
		
		Node node = head;
		
		int i = 0;
		
		while (node != null && i < k) {
			next = node.next;
			node.next = prev;
			prev = node;
			node = next;
			i++;
		}
		
		if(next != null) {
			head.next = reverseInGroupOfK(next, k);
		}
		
		return prev;
	}

}
