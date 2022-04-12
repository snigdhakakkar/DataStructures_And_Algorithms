package LinkedLists;

public class ReturnKthToLast {
	
	public static int printKthToLast(LinkedListNode head, int k) {
		if (head == null) {
			return 0;
		}
		
		int index = printKthToLast(head.next, k) + 1;
		
		if (index == k) {
			System.out.println(k + "th to last node is " + head.data);
		}
		
		return index;
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
		int[] array = {0, 1, 2, 3, 4, 5, 6};
		LinkedListNode head = createLinkedListFromArray(array);
		for (int i = 0; i <= array.length + 1; i++) {
			printKthToLast(head, i);
		}
	}    

}

/* Approach 1: We changed the return problem simply to printing the kth to the
 * last element problem. Then, we have passed back the value of the counter simply
 * through return values. This has been done because we cannot pass back a node and a 
 * counter using normal return statement.*/
