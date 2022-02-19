package BinarySearchTree;

public class CreateBinarySearchTree {
	
	public static void main(String[] args) {
		Node root = null;
		//8, 3, 6, 10, 4, 7, 1, 14, 13
		root = insert(root, 8);
		root = insert(root, 3);
		root = insert(root, 6);
		root = insert(root, 10);
		root = insert(root, 4);
		root = insert(root, 7);
		root = insert(root, 1);
		root = insert(root, 14);
		root = insert(root, 13);
		
	}
	
	public static Node insert(Node node, int val) {
		if(node == null) {
			return createNewNode(val);
		}
		
		if(val <= node.data) {
			node.left = insert(node.left, val);
		} else if (val > node.data) {
			node.right = insert(node.right, val);
		}
		
		return node;
	}
	
	public static Node createNewNode(int k) {
		Node a = new Node();
		a.data = k;
		a.left = null;
		a.right = null;
		a.next = null;
		return a;
	}

}
