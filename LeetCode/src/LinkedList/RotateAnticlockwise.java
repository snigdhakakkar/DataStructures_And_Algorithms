package LinkedList;

public class RotateAnticlockwise {
	
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
    	
    	head = rotateAntiClockwise(head, 2); 
    	
    	a.printList(head);
    	System.out.println();
		 
	 }
	 
	 public static Node rotateAntiClockwise(Node head, int k) {
		 if (head == null || k < 0) {
	            return head;
	        }
		 
		 int sizeOfList = Node.getSizeOfList(head);
	        
	        k = k % sizeOfList;
	        if (k == 0) {
	            return head;
	        }
	        
	        Node tmp = head;
	        int i = 1;
	        
	        while (i < k) {
	            tmp = tmp.next;
	            i++;
	        }
	        
	        Node temp = tmp.next; 
	        Node newHead = temp;
	        tmp.next = null;
	        
	        i = 1;
	        while (temp.next != null) {
	            temp = temp.next;
	        }
	        
	        temp.next = head;
	        return newHead;
	 }

}
