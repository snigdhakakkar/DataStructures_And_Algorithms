package BinarySearchTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CheckIfPairExistsForAGivenSumInABST {
	
	public static void main(String[] args) {
		
		Node root = null;
		//8, 3, 6, 10, 4, 7, 1, 14, 13
		root = CreateBinarySearchTree.insert(root, 8);
		root = CreateBinarySearchTree.insert(root, 3);
		root = CreateBinarySearchTree.insert(root, 6);
		root = CreateBinarySearchTree.insert(root, 10);
		root = CreateBinarySearchTree.insert(root, 4);
		root = CreateBinarySearchTree.insert(root, 7);
		root = CreateBinarySearchTree.insert(root, 1);
		root = CreateBinarySearchTree.insert(root, 14);
		root = CreateBinarySearchTree.insert(root, 13);
		
		//METHOD 1 - USING HASHSET
		System.out.println(ifpairsExist(root, 9));
		
		//METHOD 2 - USING ARRAYLIST
		System.out.println(ifpairsForGivenSumExist(root, 14));
		
	}
	
	//TIME COMPLEXITY: O(N) , SPACE COMPLEXITY: O(N)
	public static boolean ifpairsExist(Node node, int sum) {
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
	
	
	//TIME COMPLEXITY: O(N) , SPACE COMPLEXITY: O(N)
	public static boolean ifpairsForGivenSumExist(Node node, int sum) {
		List<Integer> list = new ArrayList<>();
		
		inorder(node, list);
		return checkIfpairsForGivenSumExist(sum, list);
		
	}
	
	public static void inorder(Node node, List<Integer> list) {
		if (node == null) {
			return;
		}
		
		inorder(node.left, list);
		list.add(node.data);
		inorder(node.right, list);
	}
	
	public static boolean checkIfpairsForGivenSumExist(int sum, List<Integer> list) {
		int start = 0;
		int end = list.size() - 1;
		
		while(start < end) {
			int currentSum = list.get(start) + list.get(end);
			
			if(currentSum == sum) {
				return true;
			} else if (currentSum < sum) {
				start++;
			} else {
				end--;
			}
		}
		return false;
	}
	
	

}
