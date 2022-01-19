package LinkedList;

public class SumOfAllTheNodesInTheLinkedList {
	
	public static void main(String[] args) {
		Node head  = null;
		Node a = new Node();
		
		head = Node.insert(head, 22);
		head = Node.insert(head, 3);
    	head = Node.insert(head, 10);
    	head = Node.insert(head, 3);
    	head = Node.insert(head, 13);
    	
    	int ListSum = getSumOfLinkedList(head); 
    	
    	System.out.println(ListSum);
	}
	
	public static int getSumOfLinkedList(Node node) {
		if(node == null) {
			return 0;
		}
		
		int sum = 0;
		while (node != null) {
			sum = sum + node.i;
			node = node.next;
		}
		
		return sum;
	}

}
