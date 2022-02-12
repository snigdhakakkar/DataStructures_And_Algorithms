package BinaryTree;

public class GetSumOfAllNumbersFormedFromRootToLeaf {
	
	public static int sumRootToLeaf;
	
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
		
		sumOfAllFromRootToLeaf(root, 0);
		System.out.print(sumRootToLeaf);
	}
	
	//time complexity: O(N); space complexity: O(1)
	
	public static void sumOfAllFromRootToLeaf(Node node, int i) {
		
		if(node == null) {
			return;
		}
		
		if(node.left == null && node.right == null) {
			sumRootToLeaf = sumRootToLeaf + (i * 10 + node.data);
			return;
		}
		
		 sumOfAllFromRootToLeaf(node.left, i * 10 + node.data);
		 sumOfAllFromRootToLeaf(node.right, i * 10 + node.data);
	}
	
	

}
