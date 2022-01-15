package LinkedList;

public class MiddleNode {
	
	public static Node middleNode(Node head) {
        if(head == null) {
            return null;
        } 
        
        Node a = head;
        Node b = head.next;
        
        while (b != null && b.next != null) {
            a = a.next;
            b = b.next.next;
        }
        
        int sizeOfList = Node.getSizeOfList(head);
        
        if(sizeOfList % 2 == 0) { 
            return a.next;
        }
        
        return a;
        
    }
	
	public static void main(String[] args) {
		Node head  = null;
		Node a = new Node();
		
		head = Node.insert(head, 12);
		head = Node.insert(head, 99);
    	head = Node.insert(head, 37);
    	head = Node.insert(head, 8);
    	head = Node.insert(head, 18);
    	
    	a.printList(head);
    	System.out.println();
    	
    	Node middle = middleNode(head); 
    	System.out.println(middle.i);
	}
		  

}
