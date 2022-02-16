package BinaryTree;

public class ConvertABinaryTreeToDoublyLinkedList {
	
	public static void main(String[] args) {
		BinaryTree a = new BinaryTree();
		Node root = a.createNewNode(2);
		root.left = a.createNewNode(7);
		root.right = a.createNewNode(9);
		root.right.right = a.createNewNode(3);
		root.left.left = a.createNewNode(10);
		root.left.right = a.createNewNode(6);
		root.left.right.left = a.createNewNode(5);
		root.left.right.right = a.createNewNode(11);
		
		convertBinaryTreeToDLL(root);
		
	}
	//time complexity: O(N), space complexity: O(1)
	public static Node headOfLinkedList = null;
	public static Node prev = null;
	
	public static void convertBinaryTreeToDLL(Node node) {
		
		if(node == null) {
			return;
		}
		
		convertBinaryTreeToDLL(node.left);
		
		if(prev == null) {
			headOfLinkedList = node;
			prev = node;
		} else {
			node.left = prev;
			prev.right = node;
			prev = node;
		}
		convertBinaryTreeToDLL(node.right);
	}
	
	

}
