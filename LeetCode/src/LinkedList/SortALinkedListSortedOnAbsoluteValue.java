package LinkedList;

public class SortALinkedListSortedOnAbsoluteValue {
	
	public static void main(String[] args) {
		Node a = new Node();
		
		Node head  = null;
		
		head = Node.insert(head, -22);
		head = Node.insert(head, -23);
    	head = Node.insert(head, 30);
    	head = Node.insert(head, -34);
    	head = Node.insert(head, -37);
    	head = Node.insert(head, 60);
    
    	a.printList(head);
    	System.out.println();
    	
    	Node headSortedList = sortListThatIsSortedByAbsoluteValues(head); 
    	
    	a.printList(headSortedList);
	}
	
	public static Node sortListThatIsSortedByAbsoluteValues(Node head) {
		
		
		if(head == null || head.next == null) {
			return head;
		}
		
		Node node, next, prev;
		
		node = next = head;
		prev = null;
		
		if(head.i < 0) {
			prev = node;
			node = node.next;
		}
		
		while(node != null) {
			if(node.i < 0) {
				prev.next = node.next;
				next = node.next;
				node.next = head;
				head = node;
				node = next;
			} else {
				prev = node;
				node = node.next;
			}
		}
		
		return head;
		
		
	}
	
}
