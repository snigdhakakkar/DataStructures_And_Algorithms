package LinkedList;

public class LowestCommonPoint {
	
	public static void main(String[] args) {
		Node a = new Node();
		
		Node head1 = null;
		
		head1 = Node.insert(head1, 37);
		head1 = Node.insert(head1, 8);
    	head1 = Node.insert(head1, 13);
    	head1 = Node.insert(head1, 18);
    	
    	
    	Node head2 = null;
    	
    	head2 = Node.insert(head2, 18);
		head2 = Node.insert(head2, 14);
		head2 = Node.insert(head2, 8);
		
		a.printList(head1);
		System.out.println();
		a.printList(head2);
		System.out.println();
		
		Node intersectionNode = getIntersectionNode(head1, head2);
		a.printList(intersectionNode);
		
	}
	
	public static Node getIntersectionNode(Node a, Node b) {
		a = mergeSort(a);
		b = mergeSort(b);
		Node temp;
		
		while(a != null && b != null) {
			
			if (a.i < b.i) {
				a = a.next;
			} 
			
			else if (a.i > b.i){
				b = b.next;
			}
			
			else {
				temp = a;
				temp.next = null;
				return temp;
			}
		}
		
		return null;
	}
	
	public static Node mergeSort(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		Node middle = MiddleNode.middleNode(head);
		Node secondHalf = middle.next;
		middle.next = null;
		
		return merge(mergeSort(head), mergeSort(secondHalf));
	}
	
	public static Node merge(Node a, Node b) {
		Node temp = new Node();
		Node finalList = temp;
		
		while(a != null && b != null) {
			if (a.i < b.i) {
				temp.next = a;
				a = a.next;
			} else {
				temp.next = b;
				b = b.next;
			}
			temp = temp.next;
		}
		
		temp.next = (a == null) ? b : a;
		return finalList.next;
	}

}
