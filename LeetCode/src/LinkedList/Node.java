package LinkedList;

public class Node {
	
	int i;
	Node next;
	
	private static Node getNewNode(int i) {
		Node newNode = new Node();
		newNode.i = i;
		newNode.next = null;
		
		return newNode;
	}
	
	public static Node insert(Node node, int i) {
		if (node == null) {
			return getNewNode(i);
		} else {
			node.next = insert(node.next, i);
		}
		
		return node;
	}
	
	public void printList(Node node) {
		if (node == null) {
			return;
		}
		
		System.out.println(node.i + " ");
		
		printList(node.next);
	}
	
	public static Node rotateRight(Node head, int k) {
        return RotateClockwise.rotateRight(head, k);
    }
	
	public static int getSizeOfList(Node head) {
        if (head == null) {
            return 0;
        }
        return getSizeOfList(head.next) + 1;
	}

}
