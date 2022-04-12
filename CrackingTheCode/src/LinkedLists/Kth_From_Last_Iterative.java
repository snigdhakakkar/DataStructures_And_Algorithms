package LinkedLists;

public class Kth_From_Last_Iterative {
	
	public static LinkedListNode kthToLast(LinkedListNode head, int k) {
		LinkedListNode current = head;
		LinkedListNode follower = head;
		
		/* Move current pointer k nodes into the list.*/
		for (int i = 0; i < k; i++) {
			if (current == null) {
				return null; // Out of bounds
			}
			current = current.next;
		}
		
		/* Move them at the same pace. When current pointer hits the end, 
		 * follower will be at the right element. */
		while (current != null) {
			current = current.next;
			follower = follower.next;
	  	}
		return follower;
	}
	
	public static LinkedListNode createLinkedListFromArray(int[] vals) {
		LinkedListNode head = new LinkedListNode(vals[0], null, null);
		LinkedListNode current = head;
		for (int i = 1; i < vals.length; i++) {
			current = new LinkedListNode(vals[i], null, current);
		}
		return head;
	}
	   
	public static void main(String[] args) {
		int[] array = {0, 1, 2, 3};
		LinkedListNode head = createLinkedListFromArray(array);
		for (int i = 0; i <= array.length + 1; i++) {
			LinkedListNode node = kthToLast(head, i);
			String nodeValue = node == null ? "null" : "" + node.data;
			System.out.println(i + ": " + nodeValue);
		}
	}

}
