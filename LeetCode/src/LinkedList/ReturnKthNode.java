package LinkedList;

public class ReturnKthNode {
	
	public static void main(String[] args) {
		Node a = new Node();
		
		Node head = null;
		
		head = Node.insert(head, 8);
		head = Node.insert(head, 18);
    	head = Node.insert(head, 17);
    	head = Node.insert(head, 28);
    	head = Node.insert(head, 6);
    	head = Node.insert(head, 8);
    	head = Node.insert(head, 8);
    	
    	System.out.println(returnKthNodeInList(head, 4));
	}
	
	public static int returnKthNodeInList(Node head, int k) {
		if (head == null) {
			System.out.println("The Linked List is empty.");
			return -1;
		}
		
		for (int i = 1; i < k; i++) {
			head = head.next;
			if(head == null) {
				System.out.println("k is greater than the total nodes present in the list.");
				return -1;
			}
		}
		
		return head.i;
	}

}
