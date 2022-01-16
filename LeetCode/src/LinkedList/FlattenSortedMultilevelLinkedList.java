package LinkedList;

public class FlattenSortedMultilevelLinkedList {
	
	//driver method
	public static void main(String[] args) {
		ListNode root = null;
		Linked a = new Linked();
		
		
		//using right pointer for going right in the Linked list
		//using next pointer for going to the child nodes in the list
		root = a.insert(root, 20);
		root = a.insert(root, 22);
		root = a.insert(root, 25);
		root = a.insert(root, 65);
		root = a.insert(root, 70);
		
		root.right = a.insert(root.right, 7);
		root.right = a.insert(root.right, 12);
		root.right = a.insert(root.right, 23);
		root.right = a.insert(root.right, 34);
		
		root.right.right = a.insert(root.right.right, 10);
		root.right.right = a.insert(root.right.right, 15);
		root.right.right = a.insert(root.right.right, 17);
		root.right.right = a.insert(root.right.right, 18);
		root.right.right = a.insert(root.right.right, 21);
		root.right.right = a.insert(root.right.right, 33);
		
		root.right.right.right = a.insert(root.right.right.right, 32);
		root.right.right.right = a.insert(root.right.right.right, 39);
		root.right.right.right = a.insert(root.right.right.right, 40);
		
		ListNode flattenList = flatten(root);
		a.printLinkedList(flattenList);
		
	}
	
	private static ListNode flatten(ListNode node) {
		if (node == null || node.right == null) {
			return node;
		}
		return merge(node, flatten(node.right));
	}

	
	public static ListNode merge(ListNode a, ListNode b) {
		ListNode temp = new ListNode();
		ListNode finalList = temp;
		
		while(a != null && b != null) {
			
			if (a.data < b.data) 
			{
				temp.next = a;
				a = a.next;
			} 
			else  {
				temp.next = b;
				b = b.next;
			} 
			temp = temp.next;
		}
		
		temp.next = (a == null) ? b : a;
		finalList.next.right = null;
		return finalList.next;
	}
}
