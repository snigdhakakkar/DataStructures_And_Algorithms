package LinkedList;

public class ReverseAlternativelyInGroupOfK {
	
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
    	
    	head = reverseAlternativelyInGroupOfK(head, 2); 
    	
    	a.printList(head);
    	System.out.println();
		 
	 }
	
	public static Node reverseAlternativelyInGroupOfK(Node head, int k) {
		
		if (k <= 1 || head == null || head.next == null) {
			return head;
		}
		
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
		
		i = 0;
		if (next != null) {
			head.next = next;
			node = next;
			while (node != null && i < k-1) {
				node = node.next;
				i++;
			}
			
			if(node != null) {
				node.next = reverseAlternativelyInGroupOfK(node.next, k);
			}	
		}
		
		
		
		return prev;
	}

}
