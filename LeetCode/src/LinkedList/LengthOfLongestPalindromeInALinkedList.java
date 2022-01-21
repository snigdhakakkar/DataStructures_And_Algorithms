package LinkedList;

public class LengthOfLongestPalindromeInALinkedList {
	
	public static void main(String[] args) {
		
		Node a = new Node();
		
		Node head = null;
		
		head = a.insert(head, 'e');
		head = a.insert(head, 'v');
		head = a.insert(head, 'a');
		head = a.insert(head, 'v');
		head = a.insert(head, 'e');
		head = a.insert(head, 'a');
		
		System.out.println(lengthOfLongestPalindrome(head));
	}
	
	public static int lengthOfLongestPalindrome(Node node) {
		if(node == null) {
			return 0;
		}
		
		if(node.next == null) {
			return 1;
		}
		
		Node next, prev;
		prev = next = null;
		int result = 1;
		
		while(node != null) {
			next = node.next;
			node.next = prev;
			
			result = Math.max(result, 2*getCommonElementCount(prev, next) + 1);
			result = Math.max(result, 2*getCommonElementCount(prev, next));
			
			prev = node;
			node = next;
		}
		
		return result;
	}
	
	public static int getCommonElementCount(Node a, Node b) {
		int count = 0;
		
		while(a != null && b != null) {
			if(a.i == b.i) {
				count++;
			} else {
				break;
			}
			
			a = a.next;
			b = b.next;
		}
		
		return count;
	}

}
