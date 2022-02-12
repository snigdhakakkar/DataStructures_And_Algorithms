package BinaryTree;

public class CheckIfRootToLeafSumEqualsGivenSum {
	
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
		
		System.out.println(checkIfRootToLeafSumMatchesGivenValue(root, 25));
		
	}
	
	//time complexity: O(N), space complexity: O(1)
	public static boolean checkIfRootToLeafSumMatchesGivenValue(Node node, int sum) {
		
		if(node == null) {
			return false;
		}
		
		if(node.left == null && node.right == null 
				&& sum == node.data) {
			return true;
		}
		
		
		return checkIfRootToLeafSumMatchesGivenValue(node.left, sum - node.data)
		|| checkIfRootToLeafSumMatchesGivenValue(node.right, sum - node.data);
		
		
	}

}
