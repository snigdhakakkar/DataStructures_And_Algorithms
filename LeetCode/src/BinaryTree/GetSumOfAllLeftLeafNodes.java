package BinaryTree;

public class GetSumOfAllLeftLeafNodes {
	
public static int sumOfLeftLeafNode = 0;
	
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
		
		System.out.println(sumOfLeftLeafNodes(root, false));
		sumOfLeftLeafNodesAnother(root, false);
		System.out.println(sumOfLeftLeafNode);
	}
	
	//Method 1: time complexity: O(N); space complexity: O(1)
	public static void sumOfLeftLeafNodesAnother(Node node, boolean ifLeftLeaf) {
		
		if(node == null) {
			return;
		}
		
		if(node.left == null && node.right == null && ifLeftLeaf) {
			sumOfLeftLeafNode = sumOfLeftLeafNode + node.data;
		}
		
		sumOfLeftLeafNodesAnother(node.left, true);
		sumOfLeftLeafNodesAnother(node.right, false);
	}
	
	//Method 2: time complexity: O(N); space complexity: O(1)
	public static int sumOfLeftLeafNodes(Node node, boolean ifLeftLeaf) {
		
		if(node == null) {
			return 0;
		}
		
		if(node.left == null && node.right == null && ifLeftLeaf) {
			return node.data;
		}
		
		return sumOfLeftLeafNodes(node.left, true) + sumOfLeftLeafNodes(node.right, false);
	}
	

}
