package BinaryTree;

// height balanced tree has a difference of 1 or less between left height and right height
public class CheckIfAHeightBalancedTree {
	
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
		
		System.out.println(checkIfAHeightBalancedTree(root) != -1);
		
	}

	//time complexity: O(N); space complexity: O(1)
	public static int checkIfAHeightBalancedTree(Node node) {
		if(node == null) {
			return 0;
		}
		
		if(node.left == null && node.right == null) {
			return 1;
		}
		
		int lH = checkIfAHeightBalancedTree(node.left);
		int rH = checkIfAHeightBalancedTree(node.right);
		
		if(lH == -1 || rH == -1 || Math.abs(lH - rH) > 1) {
			return -1;
		}
		
		return Math.max(lH, rH) + 1;
	}

}
