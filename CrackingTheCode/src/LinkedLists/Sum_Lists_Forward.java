package LinkedLists;

public class Sum_Lists_Forward {
	private static LinkedListNode padList(LinkedListNode l, int padding) {
		LinkedListNode head = l;
		for (int i = 0; i < padding; i++) {
			head = insertBefore(head, 0);
		}
		return head;
	}
	
	public static LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2) {
		
		int len1 = LinkedListNode.length(l1);
		int len2 = LinkedListNode.length(l2);
		
		//pad the shorter list with zeros
		if (len1 < len2) {
			l1 = padList(l1, len2 - len1);
		} else {
			l2 = padList(l2, len1 - len2);
		}
		
		//Pad the list with zeros

		
		//helper function to insert node in the front of a LinkedList
		LinkedListNode insertBefore(LinkedListNode list, int data) {
			LinkedListNode node = new LinkedListNode(data);
			if (list != null) {
				node.next = list;
			}
			
			return node;
		}
	}

}
