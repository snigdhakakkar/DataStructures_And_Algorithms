package LinkedList;

public class IfCountOfNodesIsEvenOrOdd {
	
	public static void main(String[] args) {
		
		Node head  = null;
		
		head = Node.insert(head, 22);
		head = Node.insert(head, 7);
    	head = Node.insert(head, 13);
    	head = Node.insert(head, 23);
    	head = Node.insert(head, 8);
    	//head = Node.insert(head, 6);
    
    	
    	boolean ifEvenNodes = IfEvenNodes(head); 
    	System.out.println(ifEvenNodes);
	}
	
	public static boolean IfEvenNodes(Node node) {
		if(node == null) {
			return true;
		}
		
		Node temp = node;
		
		while(temp.next != null && temp.next.next != null) {
			temp = temp.next.next;
		}
		
		if(temp.next == null) {
			return false;
		} else {
			return true;
		}
	}

}
