package LinkedList;

public class Linked {
	
	int i;
	Linked next;
	
	private static Linked getNewNode(int i) {
		Linked newNode = new Linked();
		newNode .i = i;
		newNode .next = null;
		
		return newNode;
	}
	
	public static Linked insert(Linked node, int i) {
		if (node == null) {
			return getNewNode(i);
		} else {
			node.next = insert(node.next, i);
		}
		
		return node;
	}
	
	public void printList(Linked node) {
		if (node == null) {
			return;
		}
		
		System.out.println(node.i + " ");
		
		printList(node.next);
	}
	
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

}
