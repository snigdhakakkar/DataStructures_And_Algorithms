package BinaryTree;

public class SumOfAllNodes {
	
	public int getSumOfNodes(Node node) {
		if(node == null) {
			return 0;
		}
		
		return node.data + getSumOfNodes(node.left) + getSumOfNodes(node.right);
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
		
		System.out.println("Sum of all the nodes: " + a.getSumOfNodes(root));
	}

}
