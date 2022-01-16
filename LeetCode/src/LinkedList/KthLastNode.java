package LinkedList;

public class KthLastNode {
	
	public static void main(String[] args) {
		
		Node head = null;
		
		head = Node.insert(head, 8);
		head = Node.insert(head, 18);
    	head = Node.insert(head, 17);
    	head = Node.insert(head, 28);
    	head = Node.insert(head, 6);
    	head = Node.insert(head, 8);
    	head = Node.insert(head, 8);
    	
    	System.out.println(getKthLastNode(head, 4));
	}
	
	public static int getKthLastNode(Node head, int k) {
		if (head == null) {
			System.out.println("The Linked List is empty.");
			return -1;
		}
		
		Node follower = head;
		Node current = head;
		
		for (int i = 1; i < k; i++) {
			current = current.next;
			if(current == null) {
				System.out.println("k is greater than the total number of nodes.");
			}
		}
		
		while(current.next != null) {
			follower = follower.next;
			current = current.next;
		}
		return follower.i;
	}

}
