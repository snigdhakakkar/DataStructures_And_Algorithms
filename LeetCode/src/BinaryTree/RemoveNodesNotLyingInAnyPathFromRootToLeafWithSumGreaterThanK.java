package BinaryTree;

public class RemoveNodesNotLyingInAnyPathFromRootToLeafWithSumGreaterThanK {
	
	public static void main(String[] args) {
		
		BinaryTree a = new BinaryTree();
		
		Node root = a.createNewNode(2);
		root.left = a.createNewNode(7);
		root.right = a.createNewNode(5);
		root.left.left = a.createNewNode(2);
		root.left.right = a.createNewNode(6);
		root.left.right.left = a.createNewNode(5);
		root.left.right.right = a.createNewNode(1);
		root.right.right = a.createNewNode(9);
		root.right.right.left = a.createNewNode(4);
		
		root = removeNodesNotLyingInAnyPathFromRootToLeafWithSumGreaterThanK(root, 12, 1);
		a.inorder(root);
		
	}
	
	//time complexity: O(N); space complexity: O(1)
	public static Node removeNodesNotLyingInAnyPathFromRootToLeafWithSumGreaterThanK(Node node, int sum, int s) {
		
		if(node == null) {
			return node;
		}
		
		node.left = removeNodesNotLyingInAnyPathFromRootToLeafWithSumGreaterThanK(node.left, sum, s + node.data);
		node.right = removeNodesNotLyingInAnyPathFromRootToLeafWithSumGreaterThanK(node.right, sum, s + node.data);
		
		if(node.left == null && node.right == null && (s + node.data) < sum) {
			return null;
		}
		
		return node;
	}

}
