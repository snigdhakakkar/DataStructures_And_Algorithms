package LinkedList;

public class RotateClockwise {
	
	public static Linked rotateRight(Linked head, int k) {
        if (head == null || k < 0) {
            return head;
        }
        
        int sizeOfList = getSizeOfList(head);
        
        k = k % sizeOfList;
        if (k == 0) {
            return head;
        }
        
        Linked tmp = head;
        int i = 1;
        
        while (i < sizeOfList - k) {
            tmp = tmp.next;
            i++;
        }
        
        Linked temp = tmp.next;
        Linked newHead = temp;
        tmp.next = null;
        
        i = 1;
        while (temp.next != null) {
            temp = temp.next;
        }
        
        temp.next = head;
        return newHead;
    }
    
    public static int getSizeOfList(Linked head) {
        if (head == null) {
            return 0;
        }
        return getSizeOfList(head.next) + 1;
    }
    
    public static void main(String[] args) {
    	Linked head = null;
    	Linked a = new Linked();
    	
    	head = a.insert(head, 12);
    	head = a.insert(head, 99);
    	head = a.insert(head, 37);
    	head = a.insert(head, 8);
    	head = a.insert(head, 18);
    	
    	a.printList(head);
    	System.out.println();
    	
    	head = a.rotateRight(head, 2);
    	
    	a.printList(head);
    	System.out.println();
    	
    }
    
    }

