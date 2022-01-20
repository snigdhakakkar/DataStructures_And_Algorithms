package LinkedList;

public class RearrangeTheListElementsInZigZagManner {
	
	//ZigZagManner: A < B > C < D > E < F> G
	
	//driver method
		public static void main(String[] args) {
			Node a = new Node();
			Node head = null;
			
			head = Node.insert(head, 2);
			head = Node.insert(head, 3);
	    	head = Node.insert(head, 5);
	    	head = Node.insert(head, 6);
	    	head = Node.insert(head, 8);
	    	head = Node.insert(head, 11);
	    	head = Node.insert(head, 17);
	    
	    	a.printList(head);
			System.out.println();
	    	
	    	Node newList = rearrangeInZigZagManner(head);
	    	a.printList(newList);
			System.out.println();
	    	
		}
		
		public static Node rearrangeInZigZagManner(Node head) {
			if(head == null || head.next == null) {
				return head;
			}
			
			Node node = head;
			boolean flag = true;
			
			while(node.next != null) {
				if(flag) {
					if(node.i > node.next.i) {
						int tmp = node.i;
						node.i = node.next.i;
						node.next.i = tmp;
					}
					
					flag = !flag;
				} else {
					if(node.i < node.next.i) {
						int tmp = node.i;
						node.i = node.next.i;
						node.next.i = tmp;
					}
					flag = !flag;
				}
				
				node = node.next;
			}
			
			return head;
		}
}
