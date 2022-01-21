package LinkedList;

public class MaxOrMinElementInALinkedList {
	
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
	    	
	    	getMaxMin(head);
	    	System.out.println("Max element: " + max);
	    	System.out.println("Min element: " + min);
	    	
		}
		
		static int max = Integer.MIN_VALUE;
		static int min = Integer.MAX_VALUE;
		
		public static void getMaxMin(Node node) {
			if(node == null) {
				System.out.println("The list is blank");
				return;
			}
			
			while(node != null) {
				if(node.i > max) {
					max = node.i;
				}
				
				if(node.i < min) {
					min = node.i;
				}
				
				node = node.next;
			}
		}
}
