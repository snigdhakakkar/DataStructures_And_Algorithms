package LinkedList;

import java.util.HashMap;

public class CloneListWihRandomAndNextPointerUsingHashMap {
	
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
		
		LinkedNode clone = cloneUsingHashMap(head);
		a.printList(clone);
	}
	
	public static LinkedNode cloneUsingHashMap(LinkedNode originalHead) {
		if(originalHead == null) {
			return null;
		}
		
		HashMap<LinkedNode, LinkedNode> m = new HashMap<>();
		LinkedNode secondHead = null;
		LinkedNode secondNode = null;
		
		LinkedNode firstNode = originalHead;
		
		while(firstNode != null) {
			LinkedNode newNode = LinkedNode.getNewNode(firstNode.i);
			if(secondHead == null) {
				secondHead = newNode;
				secondNode = secondHead;
			} else {
				secondNode.next = newNode;
				secondNode = newNode;
			}
			
			m.put(firstNode, secondNode);
			firstNode = firstNode.next;
		}
		
		firstNode = originalHead;
		secondNode = secondHead;
		
		while(firstNode != null) {
			if(firstNode.random != null) {
				secondNode.random = m.get(firstNode.random);
			}
			
			firstNode = firstNode.next;
			secondNode = secondNode.next;
		}
		
		return secondHead;
		
	}

}
