package LinkedList;

public class SplitAlternatively {
	
	static Node firstHead, secondHead;
	
	public static void main(String[] args) {
		Node head  = null;
		Node a = new Node();
		
		head = Node.insert(head, 12);
		head = Node.insert(head, 99);
    	head = Node.insert(head, 8);
    	head = Node.insert(head, 39);
    	head = Node.insert(head, 5);
    	head = Node.insert(head, 70);
    	head = Node.insert(head, 25);
    	
    	a.printList(head);
    	System.out.println();
    	
    	splitAlternatively(head); 
    	
    	a.printList(firstHead);
    	System.out.println();
    	a.printList(secondHead);
		 
	 }
	
	
	public static void splitAlternatively(Node node) {
		if (node == null || node.next == null) {
			return;
		}
		
		Node firstTemp;
		Node secondTemp;
		
		firstHead = firstTemp = node;
		secondHead = secondTemp = node.next;
		node = node.next.next;
		
		while (node != null && node.next != null) {
			firstTemp.next = node;
			secondTemp.next = node.next;
			
			firstTemp = firstTemp.next;
			secondTemp = secondTemp.next;
			
			node = node.next.next;
		}
		
		if (node != null) {
			firstTemp.next = node;
			firstTemp = firstTemp.next;
		}
		
		firstTemp.next = null;
		secondTemp.next = null;
		
		return;
		
		
	}

}
