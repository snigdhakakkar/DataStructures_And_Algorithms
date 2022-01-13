package LinkedList;

public class RotateClockwise {
	
	public static Node rotateRight(Node head, int k) {
        if (head == null || k < 0) {
            return head;
        }
        
        int sizeOfList = getSizeOfList(head);
        
        k = k % sizeOfList;
        if (k == 0) {
            return head;
        }
        
        Node tmp = head;
        int i = 1;
        
        while (i < sizeOfList - k) {
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
    
    public static int getSizeOfList(Node head) {
        if (head == null) {
            return 0;
        }
        return getSizeOfList(head.next) + 1;
    }
    
    public static void main(String[] args) {
    	Node head = null;
    	Node a = new Node();
    	
    	head = Node.insert(head, 12);
    	head = Node.insert(head, 99);
    	head = Node.insert(head, 37);
    	head = Node.insert(head, 8);
    	head = Node.insert(head, 18);
    	
    	a.printList(head);
    	System.out.println();
    	
    	head = rotateRight(head, 2); 
    	
    	a.printList(head);
    	System.out.println();
    	
    }
    
 }

