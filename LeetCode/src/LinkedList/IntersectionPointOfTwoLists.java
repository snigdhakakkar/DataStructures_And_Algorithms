package LinkedList;

public class IntersectionPointOfTwoLists {
	
	public static void main(String[] args) {
		Node a = new Node();
		
		Node head1 = null;
		
		head1 = Node.insert(head1, 1);
		head1 = Node.insert(head1, 24);
    	head1 = Node.insert(head1, 34);
    	head1 = Node.insert(head1, 9);
    	head1 = Node.insert(head1, 8);
    	head1 = Node.insert(head1, 37);
    	head1 = Node.insert(head1, 5);
    	
    	
    	Node head2 = null;
    	
    	head2 = Node.insert(head2, 12);
		head2 = Node.insert(head2, 99);
		head2 = Node.insert(head2, 8);
		head2 = Node.insert(head2, 37);
		head2 = Node.insert(head2, 5);
		
		a.printList(head1);
		System.out.println();
		a.printList(head2);
		System.out.println();
		
		System.out.println(getIntersectionPointOfTwoLists(head1, head2));
		
	}
	
	public static int getIntersectionPointOfTwoLists(Node node1, Node node2) {
		
		if (node1 == null || node2 == null) {
			return -1;
		}
		
		Node newHead1 = node1, newHead2 = node2;
		
		int count1 = 0, count2 = 0;
		
		while (node1 != null) {
			count1++;
			node1 = node1.next;
		}
		
		while (node2 != null) {
			count2++;
			node2 = node2.next;
		}
		
		int v = count1 - count2;
		
		while (v > 0) {
			newHead1 = newHead1.next;
			v--;
		}
		
		while (v < 0) {
			newHead2 = newHead2.next;
			v++;
		}
		
		while (newHead1 != null && newHead2 != null) {
			if (newHead1.i == newHead2.i) {
				return newHead1.i;
			}
			
			newHead1 = newHead1.next;
			newHead2 = newHead2.next;
		}
		
		return -1;

	}

}
