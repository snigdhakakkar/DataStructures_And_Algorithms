package BinaryTree;

//diameter of a tree means the maximum distance between any of its leaf nodes

public class GetDiameterOfABinaryTree {
	
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
		
		System.out.println(getDiameter(root));
		
	}
	
	public static int diameter;
	
	//time complexity: O(N); space complexity: O(1)
	public static int getDiameter(Node node) {
		if(node == null) {
			return 0;
		}
		
		if(node.left == null && node.right == null) {
			return 1;
		}
		
		int lH = getDiameter(node.left);
		int rH = getDiameter(node.right);
		
		diameter = Math.max(diameter, lH + rH + 1);
		
		return diameter;
		
		
		
	}

}
