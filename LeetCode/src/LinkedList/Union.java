package LinkedList;

public class Union {
	
	public static void main(String[] args) {
		Node a = new Node();
		
		Node head1 = null;
		
		head1 = Node.insert(head1, 37);
		head1 = Node.insert(head1, 8);
    	head1 = Node.insert(head1, 13);
    	head1 = Node.insert(head1, 18);
    	
    	
    	Node head2 = null;
    	
    	head2 = Node.insert(head2, 18);
		head2 = Node.insert(head2, 14);
		head2 = Node.insert(head2, 8);
		
		a.printList(head1);
		System.out.println();
		a.printList(head2);
		System.out.println();
		
		Node union = getUnion(head1, head2);
		a.printList(union);
		System.out.println();
		
	}
	
	public static Node getUnion(Node a, Node b) {
		a = mergeSort(a);
		b = mergeSort(b);
		return mergeWithUnion(a, b);
	}
	
	public static Node mergeSort(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		Node middle = MiddleNode.middleNode(head);
		Node secondHalf = middle.next;
		middle.next = null;
		
		return mergeWithUnion(mergeSort(head), mergeSort(secondHalf));
	}
	
	public static Node mergeWithUnion(Node a, Node b) {
		Node temp = new Node();
		Node finalList = temp;
		
		while(a != null && b != null) {
			
			if (a.i < b.i) 
			{
				temp.next = a;
				a = a.next;
			} 
			else if (a.i > b.i) {
				temp.next = b;
				b = b.next;
			} 
			
			else {
				temp.next = a;
				a = a.next;
				b = b.next;
			}
			temp = temp.next;
		}
		temp.next = (a == null) ? b : a;
		return finalList.next;
		
	}

}
