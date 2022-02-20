package BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class CheckIfElementsOfTwoBSTsAreSame {
	
	public static void main(String[] args) {
		
		Node root1 = null;
		//8, 3, 6, 10, 4, 7, 1, 14, 13
		root1 = CreateBinarySearchTree.insert(root1, 8);
		root1 = CreateBinarySearchTree.insert(root1, 3);
		root1 = CreateBinarySearchTree.insert(root1, 6);
		root1 = CreateBinarySearchTree.insert(root1, 1);
		root1 = CreateBinarySearchTree.insert(root1, 4);
		root1 = CreateBinarySearchTree.insert(root1, 7);
		root1 = CreateBinarySearchTree.insert(root1, 10);
		root1 = CreateBinarySearchTree.insert(root1, 14);
		root1 = CreateBinarySearchTree.insert(root1, 13);
		
		Node root2 = null;
		root2 = CreateBinarySearchTree.insert(root2, 7);
		root2 = CreateBinarySearchTree.insert(root2, 3);
		root2 = CreateBinarySearchTree.insert(root2, 6);
		root2 = CreateBinarySearchTree.insert(root2, 4);
		root2 = CreateBinarySearchTree.insert(root2, 8);
		root2 = CreateBinarySearchTree.insert(root2, 1);
		root2 = CreateBinarySearchTree.insert(root2, 13);
		root2 = CreateBinarySearchTree.insert(root2, 10);
		root2 = CreateBinarySearchTree.insert(root2, 14);
		
		System.out.println(checkIfElementsOfTwoBSTsAreSame(root1, root2));
		
	}
	
	//time complexity: O(N + M); Space complexity: O(N + M)
	public static boolean checkIfElementsOfTwoBSTsAreSame(Node node1, Node node2) {
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		
		inorder(node1, list1);
		inorder(node2, list2);
		
		return list1.equals(list2);
		
	}
	
	public static void inorder(Node node, List<Integer> list) {
		if (node == null) {
			return;
		}
		
		inorder(node.left, list);
		list.add(node.data);
		inorder(node.right, list);
	}
		

}
