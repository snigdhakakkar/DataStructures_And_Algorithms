package LinkedList;

public class DeleteMNodesAfterNnodes {
	
	public static void main(String[] args) {
		
		Node head  = null;
		Node a = new Node();
		
		head = Node.insert(head, 12);
		head = Node.insert(head, 8);
		head = Node.insert(head, 34);
		head = Node.insert(head, 13);
		head = Node.insert(head, 37);
		
		a.printList(head);
		System.out.println();
		
		head = deleteNNodesPostMNodes(1, 2, head);
		
		a.printList(head);
		System.out.println();
		
	}
	
	/* when list is null
	 * when n and m are greater than zero
	 * when m is zero (delete after no traversing)
	 * when n is 0 (delete 0 element)
	 * when n is greater than number of elements after traversing m nodes
	 */
	
	public static Node deleteNNodesPostMNodes(int n, int m, Node head) {
		if (head == null) {
			return head;
		}
		
		Node tmp1 = head;
		Node tmp2 = head;
		int i = 0, j = 0;
		
		while (i++ < m - 1) {
			tmp1 = tmp1.next;
		}
		
		tmp2 = (m == 0) ? tmp1 : tmp1.next;
		
		while (j++ < n) {
			if (tmp2 == null) {
				System.out.println("Not enough elements to delete.");
				return head;
			}
			
			tmp2 = tmp2.next;
		}
		
		if (m == 0) {
			return tmp2;
		}
		
		else {
			tmp1.next = tmp2;
		}
		
		return head;
	}
	
	
	
	

}
