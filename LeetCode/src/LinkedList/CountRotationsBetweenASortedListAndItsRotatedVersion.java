package LinkedList;

public class CountRotationsBetweenASortedListAndItsRotatedVersion {
	
	public static void main(String[] args) {
		Node head  = null;
		Node a = new Node();
		
		head = Node.insert(head, 22);
		head = Node.insert(head, 38);
    	head = Node.insert(head, 1);
    	head = Node.insert(head, 7);
    	head = Node.insert(head, 18);
    	
    	a.printList(head);
    	System.out.println();
    	
    	System.out.println(countRotationsInSortedRotatedList(head));
	}
	
	public static int countRotationsInSortedRotatedList(Node node) {
		if(node == null || node.next == null) {
            return 0;
        }
		
		int count = 0;
		while(node.next != null) {
			if (node.i < node.next.i) {
				count++;
			} else {
				break;
			}
			
			node = node.next;
		}
		
		if(node.next == null) {
			return 0;
		} else {
			return (count + 1);
		}
	}

}
