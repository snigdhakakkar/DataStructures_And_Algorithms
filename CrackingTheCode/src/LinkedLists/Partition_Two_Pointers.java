package LinkedLists;

public class Partition_Two_Pointers {
	
	public static LinkedListNode partition (LinkedListNode node, int x) {
	
	LinkedListNode head = node;
	LinkedListNode tail = node;
	
	while (node != null) {
		LinkedListNode next = node.next;
		if (node.data < x) {
			//insert node at head
			node.next = head;
			head = node;
		} else {
			//insert node at tail
			tail.next = node;
			tail = node;
		}
		node = next;
	}
	tail.next = null;
	
	//head has changed so we need to return it to the user
	return head;
	}
	
	public static void main(String[] args) {
		/* Create linked list */
		int[] vals = {33,9,2,3,10,10389,838,874578,5};
		LinkedListNode head = new LinkedListNode(vals[0], null, null);
		LinkedListNode current = head;
		for (int i = 1; i < vals.length; i++) {
			current = new LinkedListNode(vals[i], null, current);
		}
		System.out.println(head.printForward());
		
		/* Partition */
		LinkedListNode h = partition(head, 3);
		
		/* Print Result */
		System.out.println(h.printForward());
	}

}
