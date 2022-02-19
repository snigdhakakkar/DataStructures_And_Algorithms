package BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class CheckIfTripletExistsForAGivenSumInBST {
	
	public static void main(String[] args) {
		
		Node root = null;
		//8, 3, 6, 10, 4, 7, 1, 14, 13
		root = CreateBinarySearchTree.insert(root, 8);
		root = CreateBinarySearchTree.insert(root, 3);
		root = CreateBinarySearchTree.insert(root, 6);
		root = CreateBinarySearchTree.insert(root, 10);
		root = CreateBinarySearchTree.insert(root, 4);
		root = CreateBinarySearchTree.insert(root, 7);
		root = CreateBinarySearchTree.insert(root, -10);
		root = CreateBinarySearchTree.insert(root, 14);
		root = CreateBinarySearchTree.insert(root, 13);
		
		
		System.out.println(ifTripletsForGivenSumExist(root, 30));
		
	}
	
	//time complexity: O(N^2), Space complexity: O(N)
	public static boolean ifTripletsForGivenSumExist(Node node, int sum) {
		List<Integer> list = new ArrayList<>();
		
		inorder(node, list);
		return checkIfTripletsForGivenSumExist(sum, list);
	}
	
	public static void inorder(Node node, List<Integer> list) {
		if (node == null) {
			return;
		}
		
		inorder(node.left, list);
		list.add(node.data);
		inorder(node.right, list);
	}
	
	public static boolean checkIfTripletsForGivenSumExist(int sum, List<Integer> list) {
		
		int elementSize = list.size();
		
		for(int i = 0; i < elementSize - 2; i++) {
			int start = i + 1;
			int end = elementSize - 1;
			
			while(start < end) {
				int currentSum = list.get(i) + list.get(start) + list.get(end);
				
				if(currentSum == sum) {
					return true;
				} else if (currentSum < sum) {
					start++;
				} else {
					end--;
				}
			}
			
		}
		
		return false;
	}

}
