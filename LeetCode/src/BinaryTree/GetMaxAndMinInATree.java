package BinaryTree;

public class GetMaxAndMinInATree {
	
	public static int min = Integer.MAX_VALUE;
	public static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		
		BinaryTree a = new BinaryTree();
		
		Node root = a.createNewNode(2);
		root.left = a.createNewNode(7);
		root.right = a.createNewNode(5);
		root.left.left = a.createNewNode(2);
		root.left.right = a.createNewNode(6);
		root.left.right.left = a.createNewNode(5);
		root.left.right.right = a.createNewNode(1);
		root.right.right = a.createNewNode(9);
		root.right.right.left = a.createNewNode(4);
		
		getMaxAndMinInATree(root);
		System.out.println(min);
		System.out.println(max);
		
	}
	//Solving in pre-order manner recursively
	public static void getMaxAndMinInATree(Node node) {
		
		if(node == null) {
			return;
		}
		
		if(node.data > max) {
			max = node.data;
		}
		
		if(node.data < min) {
			min = node.data;
		}
		
		getMaxAndMinInATree(node.left);
		getMaxAndMinInATree(node.right);
	}
}
