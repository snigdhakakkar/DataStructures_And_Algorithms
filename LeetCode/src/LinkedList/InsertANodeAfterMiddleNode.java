package LinkedList;

public class InsertANodeAfterMiddleNode {
	
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
    	
    	Node newhead = InsertNodeInMiddle(head, 120); 
    	a.printList(newhead);;
	}
	
	public static Node InsertNodeInMiddle(Node node, int val) {
		if(node == null || node.next == null) {
            return null;
        }
		
		Node slow, fast, head;
		slow = fast = head = node;
		
		while (fast != null && fast.next != null) {
			
            slow = slow.next;
            fast = fast.next.next;
        }
		
		Node newNode = Node.getNewNode(val);
		newNode.next = slow.next;
		slow.next = newNode;
		
		return head;
	}

}
