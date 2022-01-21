package LinkedList;

//In-place means: L1  Ln  L2  Ln-2  L3  Ln-3 ....

public class RearrangeLinkedListInPlace {
	
	//driver method
	public static void main(String[] args) {
		Node a = new Node();
		Node head = null;
		
		head = Node.insert(head, 2);
		head = Node.insert(head, 3);
    	head = Node.insert(head, 1);
    	head = Node.insert(head, 6);
    	head = Node.insert(head, 5);
    	head = Node.insert(head, 4);
    	head = Node.insert(head, 7);
    
    	a.printList(head);
		System.out.println();
    	
    	Node newList = rearrangeInPlace(head);
    	a.printList(newList);
		System.out.println();
    	
	}
	
	public static Node rearrangeInPlace(Node head) {
		if(head == null || head.next == null) {
			return head;
		}
		
		Node middleNode = MiddleNode.middleNode(head);
		Node nextList = middleNode.next;
		middleNode.next = null;
		
		Node reversedList = ReverseList.reverse(nextList);
		Node firstList = head;
		
		Node finalList = new Node();
		Node node = finalList;
		
		while(firstList != null || reversedList != null) {
			if(firstList != null) {
				node.next = firstList;
				node = node.next;
				firstList = firstList.next;
			}
			
			if(reversedList != null) {
				node.next = reversedList;
				node = node.next;
				reversedList = reversedList.next;
			}
		}
		
		return finalList.next;
	}
	
	

}
