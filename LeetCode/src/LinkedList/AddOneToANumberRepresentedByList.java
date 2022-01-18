package LinkedList;

public class AddOneToANumberRepresentedByList {
	
	public static void main(String[] args) {
		Node head  = null;
		Node a = new Node();
		
		head = Node.insert(head, 1);
		head = Node.insert(head, 9);
    	head = Node.insert(head, 9);
    	head = Node.insert(head, 9);
    	head = Node.insert(head, 9);
    	
    	
    	a.printList(head);
    	System.out.println();
    	
    	head = addOne(head); 
    	
    	a.printList(head);
    	System.out.println();
		 
	 }
	
	public static Node addOne(Node node) {
		int carry = addOneToList(node);
		
		if(carry == 1) {
			Node head = Node.getNewNode(1);
			head.next = node;
			return head;
		}
		
		return node;
	}
	
	public static int addOneToList(Node node) {
		if (node == null) {
			return 1;
		}
		
		int res = node.i + addOneToList(node.next);
		
		node.i = res % 10;
		return res/10;
	}

}
