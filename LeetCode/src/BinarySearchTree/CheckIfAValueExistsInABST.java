package BinarySearchTree;

public class CheckIfAValueExistsInABST {
	
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
		
		System.out.println(checkIfValueExists(root, 11));
		
		
	}
	
	public static boolean checkIfValueExists(Node node, int val) {
		if(node == null) {
			return false;
		}
		
		boolean isPresent = false;
		
		while(node != null) {
		
		if (val > node.data){
			node = node.right;
			} else if (val < node.data) {
			node = node.left;
			} else  {
			isPresent = true;
			break;
			}
		}
		return isPresent;
	}

}
