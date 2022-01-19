package LinkedList;

public class MakeMiddleNodeAsHeadOfTheList {
	
	public static void main(String[] args) {
		Node head  = null;
		Node a = new Node();
		
		head = Node.insert(head, 12);
		head = Node.insert(head, 7);
    	head = Node.insert(head, 13);
    	head = Node.insert(head, 22);
    	head = Node.insert(head, 8);
    	
    	a.printList(head);
    	System.out.println();
    	
    	Node newhead = MakeMiddleNodeHead(head); 
    	a.printList(newhead);;
	}
	
	public static Node MakeMiddleNodeHead(Node node) {
		if(node == null || node.next == null) {
            return null;
        }
		
		Node slow, fast, head, prev;
		slow = fast = head = prev = node;
		
		while (fast != null && fast.next != null) {
			prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
		
		prev.next = slow.next;
		slow.next = head;
		head = slow;
		
		return head;
	}

}
