package BinaryTree;

public class GetDeepestLeftLeafNode {
	
	public static Node deepestLeftLeafNode;
	public static int currentLevel;
	
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
		
		getDeepestLeftLeafNode(root, 1, false);
		System.out.println(deepestLeftLeafNode.data);
		System.out.println(currentLevel);
		
	}
	
	//Method 1: time complexity: O(N); space complexity: O(1)
	public static void getDeepestLeftLeafNode(Node node, int level, boolean ifLeft) {
		
		if(node == null) {
			return;
		}
		
		if(ifLeft && node.left == null && node.right == null && level > currentLevel) {
			deepestLeftLeafNode = node;
			currentLevel = level;
		}
		
		getDeepestLeftLeafNode(node.left, level + 1, true);
		getDeepestLeftLeafNode(node.right, level + 1, false);
	}

}
