package BinaryTree;

public class BinaryTreeApp {
	
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
	
	
	System.out.print("Inorder:" );
	a.inorder(root);
	System.out.println();
	
	System.out.print("Preorder:" );
	a.preorder(root);
	System.out.println();
	
	System.out.print("Postorder:" );
	a.postorder(root);
	System.out.println();
	
	System.out.println("Sum of all the nodes: " + a.getSumOfNodes(root));
	
	System.out.println("Difference of even and odd nodes: " + a.getDifferenceEvenOddValues(root));
	
	System.out.println("Total number of nodes in the tree: " + a.getNumberOfNodes(root));
	
	System.out.println("Total number of leaf nodes in the tree: " + a.getNumberOfLeafNodes(root));
	
	System.out.println("Height of the tree: " + a.getHeightOfTheTree(root));
	}
}
