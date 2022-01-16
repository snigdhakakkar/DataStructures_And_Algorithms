package LinkedList;

public class CheckLoopInList {
	
	public static boolean ifLoopPresent(Node head) {
		if (head == null) {
			return false;
		}
		
		Node slow, fast;
		slow = fast = head;
		
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow.i == fast.i) {
				return true;
			}
		}
		
		return false;
		
	}
	
public static void main(String[] args) {
		
		Node head = null;
		
		head = Node.insert(head, 8);
		head = Node.insert(head, 18);
    	head = Node.insert(head, 17);
    	head = Node.insert(head, 28);
    	head = Node.insert(head, 6);
    	head = Node.insert(head, 8);
    	head = Node.insert(head, 8);
    	
    	head.next.next.next.next.next.next = head.next;
    	
    	System.out.println(ifLoopPresent(head));
	}

}
