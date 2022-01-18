package LinkedList;

public class AddTwoNumbersRecursively {
	
	static int carry = 0;
	static Node result = null;
	static Node tempNode = null;
	
	public static void main(String[] args) {
		Node head1  = null;
		Node a = new Node();
		
		head1 = Node.insert(head1, 1);
		head1 = Node.insert(head1, 7);
    	head1 = Node.insert(head1, 8);
    	head1 = Node.insert(head1, 2);
    	head1 = Node.insert(head1, 5);
    	
    	Node head2  = null;
    	
    	head2 = Node.insert(head2, 9);
		head2 = Node.insert(head2, 7);
    	head2 = Node.insert(head2, 5);
		head2 = Node.insert(head2, 6);
    	head2 = Node.insert(head2, 7);
    	
    	sumTwoNumbersRecursively(head1, head2);
    	a.printList(result);
		 
	 }
	
	public static void sumTwoNumbersRecursively(Node node1, Node node2) {
		int count1 = 0, count2 = 0;
		Node head1 = node1, head2 = node2;
		
		while (node1 != null) {
			count1++;
			node1 = node1.next;
		}
		
		while (node2 != null) {
			count2++;
			node2 = node2.next;
		}
		
		if(count1 == count2) {
			calculateSum(head1, head2);
		} else {
			if(count1 < count2) {
				Node tmp = node1;
				node1 = node2;
				node2 = tmp;
			}
			
			int diff = Math.abs(count2 - count1);
			
			node1 = head1;
			node2 = head2;
			
			while (diff > 0) {
				node1 = node1.next;
				tempNode = node1;
				diff--;
			}
			
			calculateSum(node1, node2);
			addRestSum(head1);
		}
		
		if(carry > 0) {
			Node c = Node.getNewNode(carry);
			c.next = result;
			result = c; 
			
		}
		
		
	}
	
	public static void calculateSum(Node node1, Node node2) {
		if(node1 == null) {
			return;
		}
		
		calculateSum(node1.next, node2.next);
		
		int sum = node1.i + node2.i + carry;
		
		carry = sum / 10;
		
		if(result==null) {
			result = Node.getNewNode(sum % 10);
		} else {
			Node a = Node.getNewNode(sum % 10);
			a.next = result;
			result = a;
		}
	}
	
	public static void addRestSum(Node node) {
		if(node == null) {
			return;
		}
		
		if(node != tempNode) {
			addRestSum(node.next);
			int sum = node.i + carry;
			carry = sum / 10;
			Node a = Node.getNewNode(sum % 10);
			a.next = result;
			result = a;
		}
	}

}
