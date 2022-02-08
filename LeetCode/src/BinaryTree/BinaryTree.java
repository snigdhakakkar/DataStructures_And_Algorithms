package BinaryTree;

public class BinaryTree {
	
	public Node createNewNode(int val) {
		Node a = new Node();
		
		a.data = val;
		a.left = null;
		a.right = null;
		return a;
	}
	
	public void inorder(Node node) {
		if(node == null) {
			return;
		}
		
		inorder(node.left);
		System.out.print(node.data + " ");
		inorder(node.right);
		
	}
	
	public void preorder(Node node) {
		if(node == null) {
			return;
		}
		
		System.out.print(node.data + " ");
		preorder(node.left);
		preorder(node.right);
	}
	
	public void postorder(Node node) {
		if(node == null) {
			return;
		}
		
		postorder(node.left);
		postorder(node.right);
		System.out.print(node.data + " ");
	}
	
	public int getSumOfNodes(Node node) {
		if(node == null) {
			return 0;
		}
		
		return node.data + getSumOfNodes(node.left) + getSumOfNodes(node.right);
	}
	
	
	public int getDifferenceEvenOddValues(Node node) {
		if(node == null) {
			return 0;
		}
		
		return node.data - getDifferenceEvenOddValues(node.left) - getDifferenceEvenOddValues(node.right);
	}
	

}
