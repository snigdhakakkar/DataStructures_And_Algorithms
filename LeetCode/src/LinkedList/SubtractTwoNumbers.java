package LinkedList;

public class SubtractTwoNumbers {
	
	public static void main(String[] args) {
		Node head1  = null;
		Node a = new Node();
		
		head1 = Node.insert(head1, 7);
    	head1 = Node.insert(head1, 6);
    	head1 = Node.insert(head1, 3);
    	head1 = Node.insert(head1, 4);
    	
    	Node head2  = null;
    	
    	head2 = Node.insert(head2, 7);
    	head2 = Node.insert(head2, 6);
		head2 = Node.insert(head2, 2);
    	head2 = Node.insert(head2, 5);
    	
    	Node subtraction = substractTwoNumbers(head1, head2);
    	a.printList(subtraction);
		 
	 }
	
	public static Node substractTwoNumbers(Node node1, Node node2) {
		Node head1 = node1;
		Node head2 = node2;
		
		int count1 = 0, count2 = 0;
		
		while (node1 != null) {
			count1++;
			node1 = node1.next;
		}
		
		while (node2 != null) {
			count2++;
			node2 = node2.next;
		}
		
		node1 = head1;
		node2 = head2;
		
		if ((count1 < count2) || (count1 == count2 && 
				node2 == getBiggerList(node1, node2))) {
			Node tmp = node1;
			node1 = node2;
			node2 = tmp;
		}
		
		node1 = ReverseList.reverse(node1);
		node2 = ReverseList.reverse(node2);
		
		Node newListHead = null;
		Node prev = null;
		int diff;
		boolean borrow = false;
		
		while(node1 != null || node2 != null) {
			if (borrow) {
				node1.i = node1.i - 1;
				borrow = false;
			}
			
			if (node1 != null && node2 != null && node1.i < node2.i) {
				node1.i = node1.i + 10;
				borrow = true;
			}
			
			diff = (node1 != null ? node1.i : 0) - (node2 != null ? node2.i : 0);
			
			Node node = Node.getNewNode(diff);
			if(newListHead == null) {
				newListHead = node;
			} else {
				prev.next = node;
			}
			
			prev= node;
			
			if(node1 != null) {
				node1 = node1.next;
			}
			
			if(node2 != null) {
				node2 = node2.next;
			}
		}
		
		newListHead = ReverseList.reverse(newListHead);
		
		return newListHead;
	}
	
	public static Node getBiggerList(Node node1, Node node2) {
		Node head1 = node1;
		Node head2 = node2;
		
		while(node1 != null) {
			if(node1.i > node2.i) {
				return head1;
			} else if (node1.i < node2.i) {
				return head2;
			}
			
			node1 = node1.next;
			node2 = node2.next;
		}
		
		return head1;
	}

}
