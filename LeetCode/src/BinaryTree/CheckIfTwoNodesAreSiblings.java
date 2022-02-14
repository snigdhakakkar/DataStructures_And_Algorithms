package BinaryTree;

public class CheckIfTwoNodesAreSiblings {
	
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
		
		System.out.println(checkIfSiblings(root, root.left.right.left, root.left.right.right));
		
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

}
