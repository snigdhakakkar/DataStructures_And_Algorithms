package BinaryTree;

import java.util.HashSet;

public class CheckIfThereExistsAPairForGivenSum {
	
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
		
		System.out.println(ifpairsForGivenSumExist(root, 15));
		
	}
	
	public static boolean ifpairsForGivenSumExist(Node node, int sum) {
		HashSet<Integer> set = new HashSet<>();
		
		return ifPairExistsUtil(node, sum, set);
	}
	
	public static boolean ifPairExistsUtil(Node node, int sum, HashSet<Integer> set) {
		if(node == null) {
			return false;
		}
		
		if(set.contains(sum - node.data)) {
			return true;
		}
		
		set.add(node.data);
		
		if(ifPairExistsUtil(node.left, sum, set)) {
			return true;
		}
		
		return ifPairExistsUtil(node.right, sum, set);
	}

}
