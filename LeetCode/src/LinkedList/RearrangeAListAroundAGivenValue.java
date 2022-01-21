package LinkedList;

//Rearranging the linked list around a given value while keeping the order of the items intact

public class RearrangeAListAroundAGivenValue {
	
	//driver method
	public static void main(String[] args) {
		Node a = new Node();
		Node head = null;
		
		head = Node.insert(head, 2);
		head = Node.insert(head, 33);
    	head = Node.insert(head, 1);
    	head = Node.insert(head, 3);
    	head = Node.insert(head, 5);
    	head = Node.insert(head, 44);
    	head = Node.insert(head, 57);
    	head = Node.insert(head, 22);
		head = Node.insert(head, 13);
    	head = Node.insert(head, 5);
    	head = Node.insert(head, 23);
		head = Node.insert(head, 43);
    	head = Node.insert(head, 13);
    
    	a.printList(head);
		System.out.println();
    	
    	Node newList = rearrangeAroundAGivenValueKeepingTheOrderIntact(head, 5);
    	a.printList(newList);
		System.out.println();
    	
	}
	
	public static Node rearrangeAroundAGivenValueKeepingTheOrderIntact(Node head, int val) {
		if(head == null || head.next == null) {
			return head;
		}
		
		Node lesserStart, lesserEnd, EqualStart, EqualEnd, GreaterStart, GreaterEnd;
		
		lesserStart = lesserEnd = EqualStart = EqualEnd = GreaterStart = GreaterEnd = null;
		
		Node node = head;
		
		while(node != null) {
			
			if(node.i < val) {
				
				if(lesserStart == null) {
					lesserStart = lesserEnd = node;
				} else {
					lesserEnd.next = node;
					lesserEnd = node;
				}
			} else if (node.i == val) {
				if(EqualStart == null) {
					EqualStart = EqualEnd = node;
				} else {
					EqualEnd.next = node;
					EqualEnd = node;
				}
			} else {
				if(GreaterStart == null) {
					GreaterStart = GreaterEnd = node;
				} else {
					GreaterEnd.next = node;
					GreaterEnd = node;
				}
			}
			
			node = node.next;
		}
		
		lesserEnd.next = EqualStart;
		EqualEnd.next = GreaterStart;
		GreaterEnd .next = null;
		
		return lesserStart;
		
	}
	

}
