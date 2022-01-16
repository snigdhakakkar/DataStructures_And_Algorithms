package LinkedList;

public class FirstAndSecondHalvesMatchingCheck {
	
	//driver method
			public static void main(String[] args) {
				Node a = new Node();
				Node head = null;
				
				head = Node.insert(head, 8);
				head = Node.insert(head, 18);
		    	head = Node.insert(head, 17);
		    	head = Node.insert(head, 28);
		    	head = Node.insert(head, 8);
		    	head = Node.insert(head, 18);
		    	head = Node.insert(head, 17);
		    
		    	System.out.print(ifFirstAndSecondHalvesMatch(head));
		    	
			}
			
			public static boolean ifFirstAndSecondHalvesMatch(Node head) {
				if(head == null || head.next == null) {
					return true;
				}
				
				Node slow, fast;
				slow = fast = head;
				
				while(fast.next != null && fast.next.next != null) {
					slow = slow.next;
					fast = fast.next.next;
					
				}
				
				Node secondHalf = slow.next;
				
				while (secondHalf != null) {
					if (head.i != secondHalf.i) {
						return false;
					}
					
					head = head.next;
					secondHalf = secondHalf.next;
				}
				
				return true;
			}

}
