package LinkedList;

public class DeleteNodesWithGreaterValuesOnRight {
	
	//driver method
			public static void main(String[] args) {
				Node a = new Node();
				Node head = null;
				
				head = Node.insert(head, 12);
				head = Node.insert(head, 89);
		    	head = Node.insert(head, 8);
		    	head = Node.insert(head, 39);
		    	head = Node.insert(head, 5);
		    	
		    	a.printList(head);
		    	System.out.println();

		    
		    	deleteNodesWithGreaterValuesOnRight(head);
		    	a.printList(head);
		    	
			}
			
			public static Node deleteNodesWithGreaterValuesOnRight (Node head) {
				if(head == null || head.next == null) {
					return head;
				}
				
				Node reverse = reverse(head);
				Node tmp = reverse;
				int max = tmp.i; //first value of the reversed list
				
				while (tmp.next != null) {
					if(tmp.next.i > max) {
						max = tmp.next.i;
						tmp = tmp.next;
					} else {
						tmp.next = tmp.next.next;
					}
				}
				
				head = reverse(reverse);
				
				return head;
				
				
			}
			
			public static Node reverse(Node node) {
				if (node == null || node.next == null ) {
					return node;
				}
				
				Node temp = reverse(node.next);
				node.next.next = node;
				node.next = null;
				
				return temp;
			}

}
