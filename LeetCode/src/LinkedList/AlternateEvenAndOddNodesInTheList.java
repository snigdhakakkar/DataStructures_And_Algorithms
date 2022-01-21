package LinkedList;

public class AlternateEvenAndOddNodesInTheList {
	
	//driver method
		public static void main(String[] args) {
			Node a = new Node();
			Node head = null;
			
			head = Node.insert(head, 2);
			head = Node.insert(head, 33);
	    	head = Node.insert(head, 4);
	    	head = Node.insert(head, 3);
	    	head = Node.insert(head, 5);
	    	head = Node.insert(head, 44);
	    	head = Node.insert(head, 57);
	    	head = Node.insert(head, 22);
			head = Node.insert(head, 13);
	    	head = Node.insert(head, 5);
	    	head = Node.insert(head, 26);
			head = Node.insert(head, 43);
	    	head = Node.insert(head, 16);
	    
	    	a.printList(head);
			System.out.println();
	    	
	    	Node newList = alternateEvenAndOddNode(head);
	    	a.printList(newList);
			System.out.println();
	    	
		}
		
		public static Node alternateEvenAndOddNode(Node head) {
			if(head == null || head.next == null) {
				return head;
			}
			
			Node odd = new Node();
			Node oddHead= odd;
			
			Node even = new Node();
			Node evenHead = even;
			
			Node node = head;
			
			while(node != null) {
				if(node.i % 2 == 0) {
					even.next = node;
					even = even.next;
				} else {
					odd.next = node;
					odd = odd.next;
				}
				
				node = node.next;
			}
			
			odd.next = null;
			even.next = null;
			
			odd = oddHead.next;
			even = evenHead.next;
			
			Node tmp = new Node();
			Node finalList = tmp;
			
			while(odd != null && even != null) {
				if(odd != null) {
					tmp.next = odd;
					tmp = tmp.next;
					odd = odd.next;
				} 
				
				if(even != null) {
					tmp.next = even;
					tmp = tmp.next;
					even = even.next;
				}
			}
			
			tmp.next = (odd != null) ? odd : even;
			
			return finalList.next;
					
		}

}
