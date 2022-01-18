package LinkedList;

public class SortListOfZeroesOnesAndTwos {
	
	public static void main(String[] args) {
		Node head  = null;
		Node a = new Node();
		
		head = Node.insert(head, 2);
		head = Node.insert(head, 1);
    	head = Node.insert(head, 0);
    	head = Node.insert(head, 1);
    	head = Node.insert(head, 2);
    	head = Node.insert(head, 1);
    	head = Node.insert(head, 0);
    	
    	a.printList(head);
    	System.out.println();
    	
    	head = sortListOfZeroesOnesAndTwos(head); 
    	
    	a.printList(head);
    	System.out.println();
		 
	 }
	
	public static Node sortListOfZeroesOnesAndTwos(Node node) {
		if (node == null || node.next == null) {
			return node;
		} 
		
		Node head = node;
		
		int count_0, count_1, count_2;
		
		count_0 = count_1 = count_2 = 0;
		
		while(node != null) {
			if(node.i == 0) {
				count_0++;
			} else if (node.i == 1) {
				count_1++;
			} else {
				count_2++;
			}
			
			node = node.next;
		}
		
		node = head;
		
		while(count_0 > 0) {
			node.i = 0;
			node = node.next;
			count_0--;
		}
		
		while(count_1 > 0) {
			node.i = 1;
			node = node.next;
			count_1--;
		}
		
		while(count_2 > 0) {
			node.i = 2;
			node = node.next;
			count_2--;
		}
		return head;
		
	}

}
