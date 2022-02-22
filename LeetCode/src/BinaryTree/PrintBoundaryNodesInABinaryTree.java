package BinaryTree;

public class PrintBoundaryNodesInABinaryTree {
	
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
		
		printBoundaryNodes(root);
		
	}
	
	public static void printBoundaryNodes(Node node) {
		if(node != null) {
			System.out.print(node.data + " "); 
			
			printBoundaryLeft(node.left);
			
			printLeaves(node.left);
			printLeaves(node.right);
			
			printBoundaryRight(node.right);
		}
	}
	
	public static void printBoundaryLeft(Node node) {
		if(node == null) {
			return;
		}
		
		if(node.left != null) {
			System.out.print(node.data + " ");
			printBoundaryLeft(node.left);
		} else if (node.right != null) {
			System.out.print(node.data + " ");
			printBoundaryRight(node.right);
		}
	}
	
	public static void printLeaves(Node node) {
		if(node == null) {
			return;
		}
		
		printLeaves(node.left);
		
		if(node.left == null && node.right == null) {
			System.out.print(node.data + " ");
		}
		
		printLeaves(node.right);
		
	}
	
	public static void printBoundaryRight(Node node) {
		if(node == null) {
			return;
		}
		
		if(node.right != null) {
			printBoundaryRight(node.right);
			System.out.print(node.data + " ");
		} else if (node.left != null) {
			printBoundaryRight(node.left);
			System.out.print(node.data + " ");
		}
	}

}
