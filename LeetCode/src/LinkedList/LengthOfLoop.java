package LinkedList;

public class LengthOfLoop {
	
	//driver method
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
    	
    	System.out.println(lengthOfLoop(head));
	}
	
	public static int lengthOfLoop(Node head) {
		if(head == null) {
			return -1;
		}
		
		Node slow, fast;
		slow = fast = head;
		int length = 0;
		
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow.i == fast.i) {
				break;
			}
		}
		
		if(slow == fast) {
			while(slow.next != fast) {
				slow = slow.next;
				length++;
			}
			length++;
		}
		
		return length;
	}

}
