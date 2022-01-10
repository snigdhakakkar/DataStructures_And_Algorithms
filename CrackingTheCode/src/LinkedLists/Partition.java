package LinkedLists;

public class Partition {
	
	/*Passing in the head of the LinkedList and and the value to partition around*/
	
	//four pointer solution
	
	public static LinkedListNode partition(LinkedListNode node, int x) {
		LinkedListNode beforeStart = null;
		LinkedListNode beforeEnd = null;
		LinkedListNode afterStart = null;
		LinkedListNode afterEnd = null;
		
		/*partition list*/
		while (node != null) {
			LinkedListNode next = node.next;
			node.next = null;
			
			if (node.data < x ) {
				/*insert node into the before list*/
				
				if (beforeStart == null) {
					beforeStart = node;
					beforeEnd = beforeStart;
				} 
				
				else {
					beforeEnd.next = node;
					beforeEnd = node;
				}
			} else {
				/*insert node into end of after list*/
				
				if (afterStart == null) {
					afterStart = node;
					afterEnd = afterStart;
				} else {
					afterEnd.next = node;
					afterEnd = node;
				}
			}
			
			node = next;
		}
		
		if (beforeStart == null) {
			return afterStart;
		}
		
		//merge both the lists
		beforeEnd.next = afterStart;
		return beforeStart;
		
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
