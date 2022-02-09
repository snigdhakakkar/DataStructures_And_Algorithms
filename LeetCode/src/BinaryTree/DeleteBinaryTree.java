package BinaryTree;

public class DeleteBinaryTree {
	
	public static void main(String[] args) {
		BinaryTree a = new BinaryTree();
		Node root = a.createNewNode(2);
		root.left = a.createNewNode(7);
		root.right = a.createNewNode(5);
		root.left.left = a.createNewNode(2);
		root.left.right = a.createNewNode(6);
		root.left.right.left = a.createNewNode(5);
		root.left.right.right = a.createNewNode(11);
		root.right.right = a.createNewNode(9);
		root.right.right.left = a.createNewNode(4);
		
		root = deleteBinaryTree(root);
	}
	
	public static Node deleteBinaryTree(Node node) {
		if(node == null) {
			return null;
		}
		
		node.left = deleteBinaryTree(node.left);
		node.right = deleteBinaryTree(node.right);
		
		System.out.println("Deleting node: " + node.data);
		node= null;
		return node;
	}

}
