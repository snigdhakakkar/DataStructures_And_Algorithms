package LinkedList;

public class MergeList {
	
	public static void main(String[] args) {
		Node a = new Node();
		
		Node head1 = null;
		
		head1 = Node.insert(head1, 12);
		head1 = Node.insert(head1, 9);
    	head1 = Node.insert(head1, 37);
    	
    	Node head2 = null;
    	
    	head2 = Node.insert(head2, 45);
		head2 = Node.insert(head2, 8);
		
		a.printList(head1);
		System.out.println();
		a.printList(head2);
		System.out.println();
		
		Node mergeList = mergeList(head1, head2);
		a.printList(mergeList);
		System.out.println();
		
	}
	
	public static Node mergeList(Node a, Node b) {
		return merge(mergeSort(a), mergeSort(b));
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
