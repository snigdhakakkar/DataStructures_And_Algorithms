package LinkedList;

public class CountOccurenceOfAValue {
	
	public static void main(String[] args) {
		Node head  = null;
		Node a = new Node();
		
		head = Node.insert(head, 12);
		head = Node.insert(head, 99);
    	head = Node.insert(head, 5);
    	head = Node.insert(head, 37);
    	head = Node.insert(head, 5);
    	head = Node.insert(head, 2);
    	head = Node.insert(head, 5);
    	
    	System.out.println(getCountOfValue(head, 5));
		 
	 }
	
	public static int getCountOfValue(Node node, int key) {
		if (node == null) {
			return -1;
		}
		
		int count = 0;
		
		while (node != null) {
			if(node.i == key) {
				count++;
			}
			
			node = node.next;
		}
		
		return count;
	}

}
