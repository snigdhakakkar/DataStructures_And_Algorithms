package BinaryTree;

public class CheckIfTwoNodesAreCousins {
	
	public static void main(String[] args) {
		
		BinaryTree a = new BinaryTree();
		
		Node root = a.createNewNode(2);
		root.left = a.createNewNode(7);
		root.right = a.createNewNode(5);
		root.left.left = a.createNewNode(10);
		root.left.right = a.createNewNode(6);
		root.left.right.left = a.createNewNode(5);
		root.left.right.right = a.createNewNode(1);
		root.right.right = a.createNewNode(9);
		root.right.right.left = a.createNewNode(4);
		
		System.out.println(checkIfCousins(root, root.left.right.left, root.right.right.left));
		
	}
	
	public static boolean checkIfCousins(Node node, Node val1, Node val2) {
		
		if(node == null || val1 == null || val2 == null) {
			return false;
		}
		
		if(getLevelOfNode(node, val1.data, 1) != getLevelOfNode(node, val2.data, 1)) {
			return false;
		}
		
		return !checkIfSiblings(node, val1, val2);
	}
	
	public static boolean checkIfSiblings(Node node, Node val1, Node val2) {
		
		if(node == null) {
			return false;
		}
		
		return (node.left == val1 && node.right == val2) || 
				(node.right == val1 && node.left == val2) ||
				checkIfSiblings(node.left, val1, val2) ||
				checkIfSiblings(node.right, val1, val2);
	}
	
	public static int getLevelOfNode(Node node, int val, int level) {
		if(node == null) {
			return 0;
		}
		
		if(node.data == val) {
			return level;
		}
		
		int l = getLevelOfNode(node.left, val, level + 1);
		if(l != 0) {
			return l;
		}
		
		l = getLevelOfNode(node.right, val, level + 1);
		return l;		
	}
	
	

}
