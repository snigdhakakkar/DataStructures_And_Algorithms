package LinkedList;

public class IfTripletExists {
	
	public static void main(String[] args) {
		Node head1  = null;
		Node a = new Node();
		
		head1 = Node.insert(head1, 5);
		head1 = Node.insert(head1, 2);
    	head1 = Node.insert(head1, 3);
    	
    	Node head2  = null;
    	
    	head2 = Node.insert(head2, 2);
		head2 = Node.insert(head2, 3);
    	head2 = Node.insert(head2, 7);
    	
    	Node head3  = null;
    	
    	head3 = Node.insert(head3, 7);
		head3 = Node.insert(head3, 3);
    	head3 = Node.insert(head3, 2);
    	
    	
    	System.out.println(isTripletsExistForSum(head1, head2, head3, 13));
		 
	 }
	
	public static boolean isTripletsExistForSum(Node node1, Node node2, Node node3, int val) {
		Node head2, head3;
		
		head2 = node2;
		head3 = node3;
		
		while(node1 != null) {
			while(node2 != null && node3 != null) {
				int sum = node1.i + node2.i + node3.i;
				
				if (sum == val) {
					return true;
				} else if (sum > val) {
					node3 = node3.next;
				} else {
					node2 = node2.next;
				}
			}
			
			node1 = node1.next;
			node2 = head2;
			node3 = head3;
		}
		
		return false;
	}

}
