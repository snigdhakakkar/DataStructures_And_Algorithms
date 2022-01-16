package LinkedList;

import java.util.HashMap;

public class DeleteDuplicatesUnsortedListUsingHashMap {
	
	public static Node removeDuplicatesUsingHashMap (Node node) {
		if (node == null) {
			return null;
		}
		
		HashMap<Integer, Integer> s = new HashMap<>();
		
		Node head = node;
		Node prev = null;
		
		while (node != null) {
			if (!s.containsKey(node.i)) {
				s.put(node.i, 1);
				prev = node;
				node = node.next;
			} else {
				prev.next = node.next;
				node = node.next;
			}
		}
		
		return head;
	}
	
	
	public static void main(String[] args) {
		Node a = new Node();
		
		Node head = null;
		
		head = Node.insert(head, 12);
		head = Node.insert(head, 99);
    	head = Node.insert(head, 37);
    	head = Node.insert(head, 12);
    	head = Node.insert(head, 37);
    	head = Node.insert(head, 8);
    	head = Node.insert(head, 8);
    	
		a.printList(head);
		System.out.println();
		
		Node withoutDuplicates = removeDuplicatesUsingHashMap(head);
		
		a.printList(withoutDuplicates);
		System.out.println();
		
	}

}
