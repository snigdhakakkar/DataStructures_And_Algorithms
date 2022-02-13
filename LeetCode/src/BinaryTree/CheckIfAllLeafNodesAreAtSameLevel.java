package BinaryTree;

public class CheckIfAllLeafNodesAreAtSameLevel {
	
	public static int levelOfLeaf = 0;
	
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
		
		System.out.println(checkIfAllLeafNodesAreAtSameLevel(root, 1));
		
	}
	
	//Method 1: time complexity: O(N); space complexity: O(1)
	public static boolean checkIfAllLeafNodesAreAtSameLevel(Node node, int level) {
		
		if(node == null) {
			return true;
		}
		
		if(node.left == null && node.right == null) {
			if(levelOfLeaf == 0) {
				levelOfLeaf = level;
				return true;
			}
			
			return levelOfLeaf == level;
		}
		
		return checkIfAllLeafNodesAreAtSameLevel(node.left, level + 1) && checkIfAllLeafNodesAreAtSameLevel(node.right, level + 1);
	}

}
