package LinkedList;

public class RemoveDuplicatesUnsortedList {
	
	public static void main(String[] args) {
		Node head  = null;
		Node a = new Node();
		
		head = Node.insert(head, 18);
		head = Node.insert(head, 8);
    	head = Node.insert(head, 34);
    	head = Node.insert(head, 13);
    	head = Node.insert(head, 34);
    	head = Node.insert(head, 8);
    	head = Node.insert(head, 37);
    	head = Node.insert(head, 8);
    	
    	a.printList(head);
    	System.out.println();
    	
    	head = removeDuplicate(head);
    	a.printList(head);
    	System.out.println();
	}
	
	public static Node removeDuplicate(Node head) {
		
		if (head == null) {
			return head;
		}
		
		head = mergeSort(head);
		return removeDuplicatesSortedList(head);
	}
	
	public static Node removeDuplicatesSortedList(Node head) {
		
		if (head == null || head.next == null) {
			return head;
		}
		
		if (head.i == head.next.i) {
			head.next = head.next.next;
			removeDuplicatesSortedList(head);
		} else {
			removeDuplicatesSortedList(head.next);
		}
		
		return head;
	
	}
	
	public static Node mergeSort(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		Node middle = MiddleNode.middleNode(head);
		Node secondHalf = middle.next;
		middle.next = null;
		
		return merge(mergeSort(head), mergeSort(secondHalf));
	}
	
	public static Node merge(Node a, Node b) {
		Node temp = new Node();
		Node finalList = temp;
		
		while(a != null && b != null) {
			if (a.i < b.i) {
				temp.next = a;
				a = a.next;
			} else {
				temp.next = b;
				b = b.next;
			}
			temp = temp.next;
		}
		
		temp.next = (a == null) ? b : a;
		return finalList.next;
	}

	
	

}
