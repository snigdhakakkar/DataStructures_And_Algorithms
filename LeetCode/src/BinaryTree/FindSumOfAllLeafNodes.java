package BinaryTree;

public class FindSumOfAllLeafNodes {
	
	public static int sumOfLeafNode;
	
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
		
		System.out.println(sumOfAllLeafNodes(root));
		sumOfLeafNodes(root);
		System.out.println(sumOfLeafNode);
	}
	
	//Method 1: time complexity: O(N); space complexity: O(1)
	public static int sumOfAllLeafNodes(Node node) {
		
		if(node == null) {
			return 0;
		}
		
		if(node.left == null && node.right == null) {
			return node.data;
		}
		
		return sumOfAllLeafNodes(node.left) + sumOfAllLeafNodes(node.right);
	}
	
	//Method 2: time complexity: O(N); space complexity: O(1)
	public static void sumOfLeafNodes(Node node) {
		
		if(node == null) {
			return;
		}
		
		if(node.left == null && node.right == null) {
			sumOfLeafNode = sumOfLeafNode + node.data;
			return;
		}
		
		sumOfLeafNodes(node.left);
		sumOfLeafNodes(node.right);
	}

}
