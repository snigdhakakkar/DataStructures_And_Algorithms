package LinkedList;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoLinkedListsUsingHashing {
	
	
	public static void main(String[] args) {
		Node head  = null;
		Node a = new Node();
	
		head = Node.insert(head, 22);
		head = Node.insert(head, 3);
		head = Node.insert(head, 10);
		head = Node.insert(head, 3);
		head = Node.insert(head, 13);
	
		Node head1 = null;
	
		head1 = Node.insert(head1, 2);
		head1 = Node.insert(head1, 13);
		head1 = Node.insert(head1, 10);
		head1 = Node.insert(head1, 27);
		head1 = Node.insert(head1, 36);
	
		Node intersection = getIntersectionOfTheTwoLinkedLists(head, head1); 
	
		a.printList(intersection);
	}
	
	public static Node getIntersectionOfTheTwoLinkedLists(Node node1, Node node2) {
		
		if(node1 == null || node2 == null) {
            return null;
        }
		
		Set<Integer> s = new HashSet<>();
		
		Node temp = new Node();
		Node result = temp;
		
		while(node1 != null) {
			s.add(node1.i);
			node1 = node1.next;
		}
		
		while(node2 != null) {
			if(s.contains(node2.i)) {
				temp.next = node2;
				temp = temp.next;
				s.add(node2.i);
			}
			
			node2 = node2.next;
		}
		
		temp.next = null;
		
		return result.next;
		
	}

}
