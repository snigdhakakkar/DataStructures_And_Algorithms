package BinaryTree;

public class CheckIfEachParentContainsSumOfChildren {
	
	public static void main(String[] args) {
		
		BinaryTree a = new BinaryTree();
		
		Node root = a.createNewNode(16);
		root.left = a.createNewNode(7);
		root.right = a.createNewNode(9);
		root.right.right = a.createNewNode(9);
		root.left.left = a.createNewNode(3);
		root.left.right = a.createNewNode(4);
		root.left.right.left = a.createNewNode(3);
		root.left.right.right = a.createNewNode(1);
		
		System.out.println(ifEachParentContainsSumOfChildren(root));
	}
	
	//time complexity: O(N), space complexity: O(1)
	public static boolean ifEachParentContainsSumOfChildren(Node node) {
		
		if(node == null) {
			return true;
		}
		
		if(node.left == null && node.right == null ) {
			return true;
		}
		
		int a = node.left == null ? 0 : node.left.data;
		int b = node.right == null ? 0 : node.right.data;
		
		return a + b == node.data
				&& ifEachParentContainsSumOfChildren(node.left)
				&& ifEachParentContainsSumOfChildren(node.right);
	}
	
	

}
