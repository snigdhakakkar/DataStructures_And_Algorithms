package LinkedList;

public class MergeSortedLists {
	
	public static void main(String[] args) {
		Node a = new Node();
		
		Node head1 = null;
		
		head1 = Node.insert(head1, 3);
		head1 = Node.insert(head1, 8);
    	head1 = Node.insert(head1, 13);
    	
    	Node head2 = null;
    	
    	head2 = Node.insert(head2, 4);
		head2 = Node.insert(head2, 14);
		
		a.printList(head1);
		System.out.println();
		a.printList(head2);
		System.out.println();
		
		Node merge_List = mergeSortedList(head1, head2);
		a.printList(merge_List);
		System.out.println();
		
	}
	
	public static Node mergeSortedList(Node a, Node b) {
		Node temp = new Node();
		Node finalList = temp;
		
		while(a != null && b != null) {
			
			if (a.i < b.i) 
			{
				temp.next = a;
				a = a.next;
			} 
			else if (a.i > b.i) {
				temp.next = b;
				b = b.next;
			} 
			
			else {
				temp.next = a;
				a = a.next;
				b = b.next;
			}
			temp = temp.next;
		}
		
		temp.next = (a == null) ? b : a;
		return finalList.next;
	}
	
	

}
