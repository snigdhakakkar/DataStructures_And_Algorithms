package LinkedList;

import java.util.Stack;

public class isPalindrome {
	
	//driver method
	public static void main(String[] args) {
		Node a = new Node();
		Node head = null;
		
		head = Node.insert(head, 8);
		head = Node.insert(head, 18);
    	head = Node.insert(head, 17);
    	head = Node.insert(head, 28);
    	head = Node.insert(head, 17);
    	head = Node.insert(head, 18);
    	head = Node.insert(head, 8);
    
    	System.out.print(ifPalindrome(head));
    	
	}
	
	public static boolean ifPalindrome(Node head) {
		if(head == null || head.next == null) {
			return true;
			}
		
		Node slow, fast;
		slow = fast = head;
		
		Stack<Node> s = new Stack<Node>();
		s.push(slow);
		
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			
			s.push(slow);
		}
		
		if(fast.next == null) {
			s.pop();
		}
		
		Node secondHalf = slow.next;
		
		while(secondHalf != null) {
			if(s.pop().i != secondHalf.i) {
				return false;
			}
			
			secondHalf = secondHalf.next;
		}
		
		return true;
	}

}
