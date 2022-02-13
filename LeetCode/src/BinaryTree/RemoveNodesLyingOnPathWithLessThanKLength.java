package BinaryTree;

public class RemoveNodesLyingOnPathWithLessThanKLength {
	
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
		
		root = removeNodesLyingOnPathWithLessThanKLength(root, 3, 1);
		inorder(root);
	}
	//time complexity: O(N); space complexity: O(1)
	public static Node removeNodesLyingOnPathWithLessThanKLength(Node node, int k, int level){
		
		if(node == null) {
			return null;
		}
		
		node.left = removeNodesLyingOnPathWithLessThanKLength(node.left, k, level + 1);
		node.right = removeNodesLyingOnPathWithLessThanKLength(node.right, k, level + 1);
		
		if(node.left == null && node.right == null && level < k) {
			return null;
		}
		
		return node;
	}
	
	public static void inorder(Node node) {
		if(node == null) {
			return;
		}
		
		inorder(node.left);
		System.out.print(node.data + " ");
		inorder(node.right);
		
	}

}
