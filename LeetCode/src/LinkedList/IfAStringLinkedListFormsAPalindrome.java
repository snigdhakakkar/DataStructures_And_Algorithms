package LinkedList;

public class IfAStringLinkedListFormsAPalindrome {
	
	public static void main(String[] args) {
		
		Node a = new Node();
		
		Node head = null;
		
		head = a.insert(head, 'e');
		head = a.insert(head, 'v');
		head = a.insert(head, 'a');
		head = a.insert(head, 'v');
		head = a.insert(head, 'e');
		
		System.out.println(checkIfListOfStringFormsAPalindrome(head));
	}
	
	public static boolean checkIfListOfStringFormsAPalindrome(Node head) {
		
		if(head == null) {
			return false;
		}
		
		if(head.next == null) {
			return true;
		}
		
		Node middle = MiddleNode.middleNode(head);
		middle.next = ReverseList.reverse(middle.next);
		
		Node secondHalf = middle.next;
		Node second = secondHalf;
		middle.next = null;
		
		boolean ifPalindrome = true;
		
		while(head != null && second != null) {
			if(head.i != second.i) {
				return false;
			}
			
			head = head.next;
			second = second.next;
		}
		
		middle.next = ReverseList.reverse(secondHalf);
		
		return ifPalindrome;
	}

}
