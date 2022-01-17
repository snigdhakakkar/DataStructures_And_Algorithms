package LinkedList;

public class PairwiseSwapElements {
	
	public static void main(String[] args) {
		Node head  = null;
		Node a = new Node();
		
		head = Node.insert(head, 12);
		head = Node.insert(head, 99);
    	head = Node.insert(head, 37);
    	head = Node.insert(head, 8);
    	head = Node.insert(head, 18);
    	
    	a.printList(head);
    	System.out.println();
    	
    	Node swappedList = pairwiseSwapList(head); 
    	
    	a.printList(swappedList);
    	System.out.println();
		 
	 }
	
	public static Node pairwiseSwapList(Node head) {
		if (head == null || head.next == null ) {
			return head;
		}
		
		Node headList = head;
		
		while(head != null && head.next != null) {
			int tmp = head.i;
			head.i = head.next.i;
			head.next.i = tmp;
			
			head = head.next.next;
		}
		
		return headList;
	}

}
