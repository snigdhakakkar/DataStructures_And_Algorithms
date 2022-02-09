package BinaryTree;

public class ConvertABinaryTreeToItsMirrorTree {
	
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
		
		Node mirror = convertToItsMirrorTree(root);
		inorder(mirror);
	}
	
	public static Node convertToItsMirrorTree(Node node) {
		if(node == null) {
			return null;
		}
		
		Node t = node.left;
		node.left = node.right;
		node.right = t;
		
		convertToItsMirrorTree(node.left);
		convertToItsMirrorTree(node.right);
		
		return node;
		
	}
	
	public static void inorder(Node node) {
		if(node == null) {
			return;
		}
		
		inorder(node.left);
		System.out.print(node.data + " ");
		inorder(node.right);
		
	}

}
