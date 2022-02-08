package BinaryTree;

public class DifferenceOfNodesAtEvenAndOddLevels {
	
	public int getDifferenceEvenOddValues(Node node) {
		if(node == null) {
			return 0;
		}
		
		return node.data - getDifferenceEvenOddValues(node.left) - getDifferenceEvenOddValues(node.right);
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
		
		System.out.println("Difference of even and odd nodes: " + a.getDifferenceEvenOddValues(root));
	}
}
