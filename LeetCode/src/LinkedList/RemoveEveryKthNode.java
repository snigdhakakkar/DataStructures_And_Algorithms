package LinkedList;

public class RemoveEveryKthNode {
	
	public static void main(String[] args) {
		Node a = new Node();
		
		Node head  = null;
		
		head = Node.insert(head, 22);
		head = Node.insert(head, 7);
    	head = Node.insert(head, 13);
    	head = Node.insert(head, 23);
    	head = Node.insert(head, 8);
    	head = Node.insert(head, 6);
    
    	
    	Node KthNodesRemoved = RemoveEachKthNode(head, 3); 
    	a.printList(KthNodesRemoved);
	}
	
	public static Node RemoveEachKthNode(Node node, int k) {
		if(node == null || k <= 1) {
			return null;
		}
		
		if(node.next == null && k > 1) {
			System.out.println("Not a valid case.");
			return null;
		}
		
		Node head = node;
		int i = 1;
		
		while (node != null && node.next != null) {
			if(i % (k-1) == 0) {
				node.next = node.next.next;
			}
			node = node.next;
			i++;
		}
		return head;
	}
	

}
