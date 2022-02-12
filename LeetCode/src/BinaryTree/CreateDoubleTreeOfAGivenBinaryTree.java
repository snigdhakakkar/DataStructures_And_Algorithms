package BinaryTree;

public class CreateDoubleTreeOfAGivenBinaryTree {
	
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
		
		
		doubleTree(root);
		a.inorder(root);
	}
	
	//time complexity: O(N), space complexity: O(N)
	public static void doubleTree(Node node) {
		
		if(node == null) {
			return;
		}
		
		doubleTree(node.left);
		doubleTree(node.right);
		
		Node newNode = createNewNode(node.data);
		newNode.left = node.left;
		node.left = newNode;
			
		}
	
	public static Node createNewNode(int val) {
		Node a = new Node();
		
		a.data = val;
		a.left = null;
		a.right = null;
		return a;
	}

}
