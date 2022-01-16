package LinkedList;

public class RemoveMiddleNode {
	
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
    	
    	Node MiddleNodeRemoved = deleteMiddleNode(head);
    	a.printList(MiddleNodeRemoved);
    	System.out.println();
	}
	
	public static Node deleteMiddleNode(Node head) {
		if(head == null && head.next ==  null) {
			return null;
		}
		
		Node slow, fast, previous;
		
		slow = fast = previous = head;
		
		while (fast != null && fast.next != null) {
			previous = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		
		previous.next = slow.next;
		return head;
	}

}
