package LinkedList;

public class IsIdenticalList {
	
	public static void main(String[] args) {
		Node head1  = null;
		Node head2  = null;
		Node a = new Node();
		
		head1 = Node.insert(head1, 12);
		head1 = Node.insert(head1, 99);
    	head1 = Node.insert(head1, 31);
    	head1 = Node.insert(head1, 8);
    	head1 = Node.insert(head1, 18);
    	
    	head2 = Node.insert(head2, 12);
    	head2 = Node.insert(head2, 99);
    	head2 = Node.insert(head2, 37);
    	head2 = Node.insert(head2, 8);
    	head2 = Node.insert(head2, 18);
    	
    	a.printList(head1);
    	System.out.println();
    	a.printList(head2);
    	System.out.println();
    	
    	System.out.println(ifIdenticalLists(head1, head2));
		 
	 }
	
	public static boolean ifIdenticalLists(Node head1, Node head2) {
		
		while (head1 != null && head2 != null) {
			
			if(head1.i != head2.i) {
				return false;
			}
			
			head1 = head1.next;
			head2 = head2.next;
			
		}
		
		return (head1 == null && head2 == null);
	}

}
