package BinaryTree;

public class CheckIfBinaryTreeIsFoldable {
	
	public static void main(String[] args) {
		BinaryTree a = new BinaryTree();
		Node root = a.createNewNode(2);
		root.left = a.createNewNode(7);
		root.right = a.createNewNode(5);
		root.left.left = a.createNewNode(2);
		root.left.right = a.createNewNode(6);
		root.right.left = a.createNewNode(2);
		root.right.right = a.createNewNode(6);
		root.left.right.left = a.createNewNode(5);
		root.left.right.right = a.createNewNode(11);
		root.right.left.left = a.createNewNode(5);
		root.right.left.right = a.createNewNode(11);
		
		System.out.println(checkIfBinaryTreeIsFoldable(root));
		
	}
	
	//Time complexity: O(N); Space complexity: O(1)
	public static boolean checkIfBinaryTreeIsFoldable(Node node) {
		if(node == null ) {
			return true;
		}
		
		return ifMirrorStructure(node.left, node.right);
	}
	
	public static boolean ifMirrorStructure(Node node1, Node node2) {
		
		if(node1 == null && node2 == null) {
			return true;
		}
		
		if(node1 == null || node2 == null) {
			return false;
		}
		
		return ifMirrorStructure(node1.left, node2.right)
				&& ifMirrorStructure(node1.right, node2.left);
	}
	
	

}
