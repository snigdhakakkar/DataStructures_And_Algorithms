package LinkedList;

public class MergeTwoSortedListReverseOrder {
	
	public static void main(String[] args) {
		Node a = new Node();
		
		Node head1 = null;
		
		head1 = Node.insert(head1, 1);
		head1 = Node.insert(head1, 5);
    	head1 = Node.insert(head1, 9);
    	head1 = Node.insert(head1, 10);
    	
    	Node head2 = null;
    	
    	head2 = Node.insert(head2, 7);
		head2 = Node.insert(head2, 8);
		head2 = Node.insert(head2, 11);
		
		a.printList(head1);
		System.out.println();
		a.printList(head2);
		System.out.println();
		
		Node mergeList = mergeTwoSortedListsReverseOrder(head1, head2);
		a.printList(mergeList);
		System.out.println();
		
	}
	
	public static Node mergeTwoSortedListsReverseOrder(Node node1, Node node2) {
		if(node1 == null && node2 == null) {
			return null;
		}
		
		Node mergedList, next;
		mergedList = null;
		
		while(node1 != null && node2 != null) {
			
			if(node1.i < node2.i) {
				next = node1.next;
				node1.next = mergedList;
				mergedList = node1;
				node1 = next;
			} else {
				
				next = node2.next;
				node2.next = mergedList;
				mergedList = node2;
				node2 = next;
			}
		}
		
		Node temp = node1 != null ? node1 : node2;
		while(temp != null) {
			next = temp.next;
			temp.next = mergedList;
			mergedList = temp;
			temp = next;
		}
		
		return mergedList;
	}

}
