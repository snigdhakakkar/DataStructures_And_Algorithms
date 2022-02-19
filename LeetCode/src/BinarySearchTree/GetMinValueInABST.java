package BinarySearchTree;

public class GetMinValueInABST {
	
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
		
		System.out.println(getMinElementValue(root));
		
	}
	
	public static int getMinElementValue(Node node) {
		if(node == null) {
			System.out.println("Tree is empty.");
			return -1;
		}
		
		while(node.left != null) {
			node = node.left;
		}
		
		return node.data;
		
		
	}

}
