package BinarySearchTree;

import java.util.Arrays;

//balanced BST - absolute difference between the left height and right height for each node should not be more than 1
public class ConstructBalancedBSTFromGivenValues {
	
	public static void main(String[] args) {
		
		int[] arr = {8, 3, 6, 10, 4, 7, 1, 14, 13};
		
		Node root = constructBalancedBSTFromGivenValues(arr);
		
		inorder(root);
	}
	
	//time complexity = O(NlogN); Space complexity = O(1)
	public static Node constructBalancedBSTFromGivenValues(int[] a) {
		Arrays.sort(a);
		
		return constructBalancedBSTUtil(a, 0, a.length - 1);
	}
	
	public static Node constructBalancedBSTUtil(int[] arr, int start, int end) {
		if(start > end) {
			return null;
		}
		
		int mid = (start + end) / 2 ;
		
		Node node = CreateBinarySearchTree.createNewNode(arr[mid]);
		
		node.left = constructBalancedBSTUtil(arr, start, mid - 1);
		node.right = constructBalancedBSTUtil(arr, mid + 1, end);
		
		return node;
	}
	
	public static void inorder(Node node) {
		if (node == null) {
			return;
		}
		
		inorder(node.left);
		System.out.print(node.data + " ");
		inorder(node.right);
	}

}
