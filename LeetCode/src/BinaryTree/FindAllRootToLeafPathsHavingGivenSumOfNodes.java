package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class FindAllRootToLeafPathsHavingGivenSumOfNodes {
	
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
		
		System.out.println(findRootToLeafPathsHavingGivenSumOfNodes(root, 14));
		
	}
	
	//time complexity: O(N); space complexity: O(N)
	public static List<List<Integer>> findRootToLeafPathsHavingGivenSumOfNodes(Node node, int sum) {
		
		List<List<Integer>> allSumPathList = new ArrayList<>();
		
		List<Integer> singlePath = new ArrayList<Integer>();
		
		sumPathUtil(node, sum, allSumPathList, singlePath);
		
		return allSumPathList;
	}
	
	public static void sumPathUtil(Node node, int sum, List<List<Integer>> allSumPathList, List<Integer> singlePath) {
		
		if(node == null) {
			return;
		}
		
		singlePath.add(node.data);
		
		if(node.left == null && node.right == null && node.data == sum) {
			allSumPathList.add(new ArrayList<>(singlePath));
		} else {
			sumPathUtil(node.left, sum - node.data, allSumPathList, singlePath);
			sumPathUtil(node.right, sum - node.data, allSumPathList, singlePath);
		}
		
		singlePath.remove(singlePath.size() - 1);
	}
	
	

}
