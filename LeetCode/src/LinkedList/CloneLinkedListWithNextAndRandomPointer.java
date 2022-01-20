package LinkedList;

public class CloneLinkedListWithNextAndRandomPointer {
	
	public static void main(String[] args) {
		LinkedNode a = new LinkedNode();
		
		LinkedNode head = LinkedNode.getNewNode(1);
		head.next = LinkedNode.getNewNode(2);
		head.next.next = LinkedNode.getNewNode(3);
		head.next.next.next = LinkedNode.getNewNode(4);
		head.next.next.next.next = LinkedNode.getNewNode(5);
		
		
		head.random = head.next.next;
		head.next.random = head;
		head.next.next.random = head.next.next.next.next;
		head.next.next.next.random = head.next.next.next.next;
		head.next.next.next.next.random = head.next;
		
		LinkedNode clone = clone(head);
		a.printList(clone);
	}
	
	public static LinkedNode clone(LinkedNode node) {
		if(node == null) {
			return node;
		}
		
		LinkedNode first = node;
		LinkedNode next = null;
		
		while(node != null) {
			LinkedNode newNode = LinkedNode.getNewNode(node.i);
			next = node.next;
			node.next = newNode;
			newNode.next = next;
			
			node = next;
		}
		
		node = first;
		
		while(node != null) {
			node.next.random = node.random.next;
			node = node.next != null ? node.next.next : node.next;
		}
		
		node = first;
		LinkedNode copy = node.next;
		LinkedNode tempCopy = copy;
		
		while(node != null && copy != null) {
			node.next = node.next != null ? node.next.next : node.next;
			copy.next = copy.next != null ? copy.next.next : copy.next;
			
			node = node.next;
			copy = copy.next;
		}
		
		return tempCopy;
	}

}
