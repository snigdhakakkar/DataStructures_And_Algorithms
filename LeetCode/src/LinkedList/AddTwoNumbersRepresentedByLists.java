package LinkedList;

public class AddTwoNumbersRepresentedByLists {
	
	public static void main(String[] args) {
		Node head1  = null;
		Node a = new Node();
		
		head1 = Node.insert(head1, 1);
		head1 = Node.insert(head1, 7);
    	head1 = Node.insert(head1, 8);
    	head1 = Node.insert(head1, 2);
    	head1 = Node.insert(head1, 5);
    	
    	Node head2  = null;
    	
    	head2 = Node.insert(head2, 9);
		head2 = Node.insert(head2, 7);
    	head2 = Node.insert(head2, 5);
		head2 = Node.insert(head2, 6);
    	head2 = Node.insert(head2, 7);
    	
    	Node sum = sumTwoNumbers(head1, head2);
    	a.printList(sum);
		 
	 }
	
	public static Node sumTwoNumbers(Node node1, Node node2) {
		node1 = ReverseList.reverse(node1);
		node2 = ReverseList.reverse(node2);
		
		Node newListHead = null;
		Node prev = null;
		
		int sum, carry = 0;
		
		while (node1 != null && node2 != null) {
			sum = carry + (node1 != null ? node1.i : 0) + 
					(node2 != null ? node2.i : 0);
			
			carry = sum/10;
			
			Node node = Node.getNewNode(sum % 10);
			if(newListHead == null) {
				newListHead = node;
			} else {
				prev.next = node;
			}
			
			prev = node;
			
			if(node1 != null) {
				node1 = node1.next;
			}
			
			if(node2 != null) {
				node2 = node2.next;
			}
		}
		
		if(carry != 0) {
			prev.next = Node.getNewNode(carry);
		}
		
		newListHead = ReverseList.reverse(newListHead);
		
		return newListHead;
	}

}
