package BinarySearchTree;

public class RemoveBSTNodesOutsideGivenRange {
	
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
		
		root = remove(root, 3, 12);
		printAllElementsInorder(root);
		
	}
	
	
	//time complexity: O(N), space complexity: O(1) 
	public static Node remove(Node node, int min, int max) {
		if(node == null) {
			return null;
		}
		
		node.left = remove(node.left, min, max);
		node.right = remove(node.right, min, max);
		
		if(node.data < min) {
			return node.right;
		} else if (node.data > max) {
			return node.left;
		}
		
		return node;
		
		
	}
	
	public static void printAllElementsInorder(Node node) {
		if (node == null) {
			return;
		}
		
		printAllElementsInorder(node.left);
		System.out.print(node.data + " ");
		printAllElementsInorder(node.right);
	}

}
