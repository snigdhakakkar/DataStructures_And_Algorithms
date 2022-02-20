package BinarySearchTree;

public class ConvertBSTIntoSortedDoublyLinkedList {
	
	public static void main(String[] args) {
		
		Node root = null;
		//8, 3, 6, 10, 4, 7, 1, 14, 13
		root = CreateBinarySearchTree.insert(root, 8);
		root = CreateBinarySearchTree.insert(root, 3);
		root = CreateBinarySearchTree.insert(root, 6);
		root = CreateBinarySearchTree.insert(root, 1);
		root = CreateBinarySearchTree.insert(root, 4);
		root = CreateBinarySearchTree.insert(root, 7);
		root = CreateBinarySearchTree.insert(root, 10);
		root = CreateBinarySearchTree.insert(root, 14);
		root = CreateBinarySearchTree.insert(root, 13);
		
		convertBinarySearchTreeToDLL(root);
		printList();
		
	}
	
	//time complexity: O(N), space complexity: O(1)
	public static Node headOfDoublyLinkedList = null;
	public static Node prev = null;
	
	public static void convertBinarySearchTreeToDLL(Node node) {
		
		if(node == null) {
			return;
		}
		
		convertBinarySearchTreeToDLL(node.left);
		
		if(prev == null) {
			headOfDoublyLinkedList = node;
		} else {
			node.left = prev;
			prev.right = node;
		}
		
		prev = node;
		
		convertBinarySearchTreeToDLL(node.right);
	}
	
	public static void printList() {
		
		Node node = headOfDoublyLinkedList;
		
		while(node != null) {
			System.out.print(node.data + " ");
			node = node.right;
		}
	}

}
