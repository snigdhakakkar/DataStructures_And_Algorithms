package BinaryTree;

public class GetMinimumDistanceFromRootToLeaf {
	
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
		
		System.out.println(minimumDistance(root));
		
	}
	
	//Method 1: time complexity: O(N); space complexity: O(1)
	public static int minimumDistance(Node node) {
		
		if(node == null) {
			return Integer.MAX_VALUE;
		}
		
		if(node.left == null && node.right == null) {
			return 0;
		}
		
		return 1 + Math.min(minimumDistance(node.left), minimumDistance(node.right));
		
	}


}
