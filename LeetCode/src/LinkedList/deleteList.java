package LinkedList;

public class deleteList {
	
	//driver method
		public static void main(String[] args) {
			Node a = new Node();
			Node head = null;
			
			head = Node.insert(head, 8);
			head = Node.insert(head, 18);
	    	head = Node.insert(head, 17);
	    	head = Node.insert(head, 28);
	    	head = Node.insert(head, 17);
	    	head = Node.insert(head, 18);
	    	head = Node.insert(head, 8);
	    
	    	deleteLinkedList(head);
	    	
		}
		
		public static Node deleteLinkedList(Node head) {
			return null;
		}

}
