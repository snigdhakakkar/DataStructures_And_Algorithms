package LinkedLists;

import LinkedLists.LinkedListNode;

public class RemoveDups_withoutBuffer {
	
	/*If we do not use a buffer, then we need to iterate with two pointers: current that 
	 * iterates through the linkedList, and runner which checks all subsequent nodes
	 for duplicates.*/
	
	public static void deleteDups(LinkedListNode head) {
		LinkedListNode current = head;
		
		while (current != null) {
			//remove all future nodes that have same data value
			LinkedListNode runner = current;
			
			while (runner.next != null) {
				if (runner.next.data == current.data) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			
			current = current.next;
		}
	}
	
	public static void main(String[] args) {	
		LinkedListNode first = new LinkedListNode(0, null, null);
		LinkedListNode head = first;
		LinkedListNode second = first;
		for (int i = 1; i < 8; i++) {
			second = new LinkedListNode(i % 2, null, null);
			first.setNext(second);
			second.setPrevious(first);
			first = second;
		}
		System.out.println(head.printForward());
		deleteDups(head);
		System.out.println(head.printForward());
	}
	
	//This code runs in O(1) space, but O(N^2) time. 

}
