package BinarySearchTree;

public class GetMaxValueElementInBST {
	
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
		
		System.out.println(getMaxElementValue(root));
		
	}
	
	public static int getMaxElementValue(Node node) {
		if(node == null) {
			System.out.println("Tree is empty.");
			return -1;
		}
		
		while(node.right != null) {
			node = node.right;
		}
		
		return node.data;
		
		
	}

}
