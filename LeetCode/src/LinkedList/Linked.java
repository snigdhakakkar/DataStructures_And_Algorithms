package LinkedList;

public class Linked {
	
	ListNode root;
	
	public Linked() {
		root = null;
		
	}
	
	public  ListNode getNewNode(int key) {
		ListNode a = new ListNode();
		a.next = null;
		a.right = null;
		a.child = null;
		a.data = key;
		return a;
	}
	
	//insert method
	public ListNode insert (ListNode dummy, int key) {
		
		if (dummy == null) {
			return getNewNode(key);
		}
		dummy.next = insert(dummy.next, key);
		return dummy;
	}
	
	//print method
	public void printLinkedList(ListNode node) {
		if (node == null) {
			return;
		}
		
		System.out.print(node.data + " ");
		printLinkedList(node.next);
	}
	
	
	//create linked list from array
	
	public ListNode createList(int arr[]) {
		ListNode node = null;
		
		for (int i = 0; i < arr.length; i++) {
			node = insert(node, arr[i]);
		}
		
		return node;
	}
	
	
	

}
