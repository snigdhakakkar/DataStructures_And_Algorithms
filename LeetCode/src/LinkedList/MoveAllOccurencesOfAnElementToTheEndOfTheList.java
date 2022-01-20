package LinkedList;

public class MoveAllOccurencesOfAnElementToTheEndOfTheList {
	
	//driver method
	public static void main(String[] args) {
		Node a = new Node();
		Node head = null;
		
		head = Node.insert(head, 18);
		head = Node.insert(head, 18);
    	head = Node.insert(head, 17);
    	head = Node.insert(head, 28);
    	head = Node.insert(head, 8);
    	head = Node.insert(head, 18);
    	head = Node.insert(head, 17);
    
    	a.printList(head);
		System.out.println();
    	
    	Node newList = moveAllOccurencesOfAnItemToTheEnd(head, 18);
    	a.printList(newList);
		System.out.println();
    	
	}
	
	public static Node moveAllOccurencesOfAnItemToTheEnd(Node head, int value) {
		if(head == null || head.next == null) {
			return head;
		}
		
		Node node, tail, prev, next, temp;
		node = head;
		prev = null;
		
		while(node.next != null) {
			node = node.next;
		}
		
		tail = node;
		temp = tail;
		node = head;
		
		while(node != tail) {
			
			if(node.i == value && prev == null) {
				
				next = node.next;
				temp.next = node;
				temp = temp.next;
				node.next = null;
				node = head = next;
				
			} else if (node.i == value && prev != null) {
				
				next = node.next;
				prev.next = node.next;
				temp.next = node;
				temp = temp.next;
				node.next = null;
				node = next;
				
			} else {
				prev = node;
				node = node.next;
			}
		}
		
		return head;
	}
	
	

}
