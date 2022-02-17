package BinaryTree;

public class GetMaxSumPath {
	
	public static void main(String[] args) {
		BinaryTree a = new BinaryTree();
		Node root = a.createNewNode(2);
		root.left = a.createNewNode(7);
		root.right = a.createNewNode(-9);
		root.right.right = a.createNewNode(3);
		root.left.left = a.createNewNode(-10);
		root.left.right = a.createNewNode(-6);
		root.left.right.left = a.createNewNode(-5);
		root.left.right.right = a.createNewNode(11);
		
		maxSumPath(root);
		System.out.println(maxSum);
		
	}
	
	public static int maxSum = 0;
	
	public static int maxSumPath(Node node) {
		
		if (node == null) {
			return 0;
		}
		
		if(ifLeafNode(node)) {
			return node.data;
		}
		
		int l = maxSumPath(node.left);
		int r = maxSumPath(node.right);
		
		int max_one = Math.max(node.data, node.data + Math.max(l,  r));
		
		int max_two = Math.max(max_one, l + r + node.data);
		
		maxSum = Math.max(maxSum, max_two);
		
		return max_one;
	}
	
	public static boolean ifLeafNode(Node node) {
		if(node == null) {
			return false;
		}
		
		if(node.left == null && node.right == null) {
			return true;
		}
		
		return false;
	}

}
