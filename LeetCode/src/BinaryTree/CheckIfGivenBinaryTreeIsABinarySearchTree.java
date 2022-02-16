package BinaryTree;

//Time complexity: O(N^2)
public class CheckIfGivenBinaryTreeIsABinarySearchTree {
	
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
		
		System.out.println(isBST(root));
		
	}

	public static Node prev = null;
	
	public static boolean isBST(Node node) {
		if(node == null) {
			return true;
		}
		
		if(!isBST(node.left)) {
			return false;
		}
		
		if(prev != null && prev.data > node.data) {
			return false;
		}
		prev = node;
		
		return isBST(node.right);
	}
}


