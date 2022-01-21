package LinkedList;

public class DeleteLargestElement {
	
	//driver method
			public static void main(String[] args) {
				Node a = new Node();
				Node head = null;
				
				head = Node.insert(head, 2);
				head = Node.insert(head, 33);
		    	head = Node.insert(head, 1);
		    	head = Node.insert(head, 3);
		    	head = Node.insert(head, 5);
		    	head = Node.insert(head, 44);
		    	head = Node.insert(head, 57);
		    	head = Node.insert(head, 22);
				head = Node.insert(head, 13);
		    	head = Node.insert(head, 5);
		    	head = Node.insert(head, 23);
				head = Node.insert(head, 43);
		    	head = Node.insert(head, 13);
		    
		    	a.printList(head);
		    	System.out.println();
		    	
		    	Node newHead = deleteLargestElement(head);
		    	
		    	a.printList(newHead);
			}
			
			public static Node deleteLargestElement(Node node) {
				if(node == null || node.next == null) {
					return node;
				}
				
				Node prevLargest, largest, prev, head;
				head = largest = node;
				prevLargest = null;
				prev = node;
				node = node.next;
				
				while(node != null) {
					if(node.i > largest.i) {
						prevLargest = prev;
						largest = node;
					}
					
					prev = node;
					node = node.next;
				}
				
				if(head == largest) {
					head = head.next;
				} else {
					prevLargest.next = largest.next;
				}
				
				return head;
			}

}
