package BinarySearchTree;

public class PrintAllElementsInPreOrderInBST {
	
	public static void main(String[] args) {
		
		Node root = null;
		//8, 3, 6, 10, 4, 7, 1, 14, 13
		root = CreateBinarySearchTree.insert(root, 8);
		root = CreateBinarySearchTree.insert(root, 3);
		root = CreateBinarySearchTree.insert(root, 6);
		root = CreateBinarySearchTree.insert(root, 10);
		root = CreateBinarySearchTree.insert(root, 4);
		root = CreateBinarySearchTree.insert(root, 7);
		root = CreateBinarySearchTree.insert(root, 1);
		root = CreateBinarySearchTree.insert(root, 14);
		root = CreateBinarySearchTree.insert(root, 13);
		
		printAllElementsPreorder(root);
		
		
	}
	
	public static void printAllElementsPreorder(Node node) {
		if (node == null) {
			return;
		}
		
		System.out.print(node.data + " ");
		printAllElementsPreorder(node.left);
		printAllElementsPreorder(node.right);
	}

}
