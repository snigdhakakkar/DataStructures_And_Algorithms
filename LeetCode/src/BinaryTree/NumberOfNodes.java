package BinaryTree;

public class NumberOfNodes {
	
	public int getNumberOfNodes(Node node) {
		if(node == null) {
			return 0;
		}
		
		return 1 + getNumberOfNodes(node.left) + getNumberOfNodes(node.right);
	}
	
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
		
		System.out.println("Total number of nodes in the tree: " + a.getNumberOfNodes(root));
	}

}
