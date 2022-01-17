package LinkedList;

public class SwapNodesWithoutSwappingData {
	
	public static void main(String[] args) {
		Node head  = null;
		Node a = new Node();
		
		head = Node.insert(head, 12);
		head = Node.insert(head, 99);
    	head = Node.insert(head, 39);
    	head = Node.insert(head, 8);
    	head = Node.insert(head, 18);
    	
    	a.printList(head);
    	System.out.println();
    	
    	Node swappedListNew = swapNodes(head, 99, 39); 
    	
    	a.printList(swappedListNew);
    	System.out.println();
		 
	 }
	
	public static Node swapNodes(Node node, int a, int b) {
		if (node == null || node.next == null) {
			return node;
		}
		
		Node t1, t2, prev1, prev2;
		prev1 = prev2 = t1 = t2 = null;
		
		Node head = node;
		
		while (node != null) {
			if (node.i == a) {
				t1 = node;
				break;
			}
			
			prev1 = node;
			node = node.next;
		}
		
		node = head;
		
		while (node != null) {
			if (node.i == b) {
				t2 = node;
				break;
			}
			
			prev2 = node;
			node = node.next;
		}
		
		if (t1 == null || t2 == null) {
			return head;
		}
		
		if(prev1 != null) {
			prev1.next = t2;
		} else {
			head = t2;
		}
		
		if(prev2 != null) {
			prev2.next = t1;
		} else {
			head = t1;
		}
		
		Node tmp = t1.next;
		t1.next = t2.next;
		t2.next = tmp;
		
		return head;
	}

}
