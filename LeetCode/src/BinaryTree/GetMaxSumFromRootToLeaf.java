package BinaryTree;

public class GetMaxSumFromRootToLeaf {
	
	public static void main(String[] args) {
		BinaryTree a = new BinaryTree();
		Node root = a.createNewNode(2);
		root.left = a.createNewNode(7);
		root.right = a.createNewNode(5);
		root.left.left = a.createNewNode(12);
		root.left.right = a.createNewNode(6);
		root.left.right.left = a.createNewNode(5);
		root.left.right.right = a.createNewNode(11);
		root.right.right = a.createNewNode(9);
		root.right.right.left = a.createNewNode(4);
		
		getMaxSumFromRootToLeaf(root, 0);
		System.out.print(max_sum);
	}
	
	public static int max_sum = 0;
	
	//time complexity: O(N); space complexity: O(1)
	
	public static void getMaxSumFromRootToLeaf(Node node, int sum) {
		
		if(node == null) {
			return;
		}
		
		if(node.left == null && node.right == null && sum + node.data > max_sum) {
			max_sum = sum + node.data;
			return;
		}
		
		getMaxSumFromRootToLeaf(node.left, sum + node.data);
		getMaxSumFromRootToLeaf(node.right, sum + node.data);
		
	}
	

}
