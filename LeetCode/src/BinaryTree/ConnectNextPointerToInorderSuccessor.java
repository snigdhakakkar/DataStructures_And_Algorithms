package BinaryTree;

//similar question: in a binary search tree, next pointer should point to next bigger value
public class ConnectNextPointerToInorderSuccessor {
	
	public static void main(String[] args) {
		BinaryTree a = new BinaryTree();
		Node root = a.createNewNode(2);
		root.left = a.createNewNode(7);
		root.right = a.createNewNode(9);
		root.right.right = a.createNewNode(3);
		root.left.left = a.createNewNode(10);
		root.left.right = a.createNewNode(6);
		root.left.right.left = a.createNewNode(5);
		root.left.right.right = a.createNewNode(11);
		
		connectNextPointerToInorderSuccessor(root);
		
	}
	//time complexity: O(N), space complexity: O(1)
	public static Node prev = null;
	
	public static void connectNextPointerToInorderSuccessor(Node node) {
		
		if(node == null) {
			return;
		}
		
		connectNextPointerToInorderSuccessor(node.left);
		
		if(prev != null) {
			prev.next = node;
		}
		prev = node;
		
		
		
		connectNextPointerToInorderSuccessor(node.right);
	}

}
