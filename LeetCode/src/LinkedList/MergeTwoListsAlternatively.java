package LinkedList;

public class MergeTwoListsAlternatively {
	
	static Node first, second;
	
	public static void main(String[] args) {
		Node a = new Node();
		
		Node head1 = null;
		
		head1 = Node.insert(head1, 12);
		head1 = Node.insert(head1, 99);
    	head1 = Node.insert(head1, 8);
    	head1 = Node.insert(head1, 39);
    	
    	Node head2 = null;
    	
    	head2 = Node.insert(head2, 5);
		head2 = Node.insert(head2, 70);
		
		a.printList(head1);
		System.out.println();
		a.printList(head2);
		System.out.println();
		
		mergeListsAlternatively(head1, head2);
		a.printList(first);
		System.out.println();
		a.printList(second);
		System.out.println();
		
	}
	
	public static void mergeListsAlternatively(Node node1, Node node2) {
		Node node1next, node2next;
		first = node1;
		second = node2;
		
		while (node1 != null && node2 != null) {
			node1next = node1.next;
			node1.next = node2;
			node1 = node1next;
			
			node2next = node2.next;
			node2.next = node1next;
			node2 = node2next;
		}
		
		second = node2;
	}

}
