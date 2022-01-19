package LinkedList;

public class SumOfLastNNodes {
	
	public static void main(String[] args) {
		Node head  = null;
		
		Node a = new Node();
		
		head = Node.insert(head, 22);
		head = Node.insert(head, 3);
    	head = Node.insert(head, 10);
    	head = Node.insert(head, 13);
    	head = Node.insert(head, 23);
    	head = Node.insert(head, 6);
    	
    	int SumOfLastNNodes = getSumOfLastNNodes(head, 2); 
    	
    	System.out.println(SumOfLastNNodes);
	}
	
	public static int getSumOfLastNNodes(Node node, int val) {
		if(node == null || val <= 0) {
			return 0;
		}
		
		int sum = 0;
		Node head = node;
		
		while (node != null && val > 0) {
			sum = sum + node.i;
			node = node.next;
			val--;
		}
		
		if(node == null) {
			if(val > 0) {
				System.out.println("Val is greater than the number of nodes.");
				return 0;
			} else {
				return sum;
			}
		}
		
		while(node.next != null) {
			node = node.next;
			head= head.next;
		}
		
		head = head.next;
		sum = 0;
		
		while(head != null) {
			sum = sum + head.i;
			head = head.next;
		}
		
		return sum;
		
	}
	

}
