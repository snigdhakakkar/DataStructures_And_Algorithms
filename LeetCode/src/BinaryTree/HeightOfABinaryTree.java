package BinaryTree;

public class HeightOfABinaryTree {
	
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
		
		System.out.println("Height of the tree: " + getHeightOfTheTree(root));
	}
	
	public static int getHeightOfTheTree(Node node) {
		//height is the maximum number of edges from leaf node to the given node
		
		if(node == null) {
			return -1;
		}
		
		return max(getHeightOfTheTree(node.left), getHeightOfTheTree(node.right)) + 1;
	}
	
	private static int max(int a, int b) {
		return a > b ? a : b;
	}

}
