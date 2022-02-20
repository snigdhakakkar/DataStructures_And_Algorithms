package BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class FindFloorAndCeilOfAGivenValueInABST {
	
	public static void main(String[] args) {
		
		Node root = null;
		//8, 3, 6, 10, 4, 7, 1, 14, 13
		root = CreateBinarySearchTree.insert(root, 8);
		root = CreateBinarySearchTree.insert(root, 3);
		root = CreateBinarySearchTree.insert(root, 6);
		root = CreateBinarySearchTree.insert(root, 1);
		root = CreateBinarySearchTree.insert(root, 4);
		root = CreateBinarySearchTree.insert(root, 7);
		root = CreateBinarySearchTree.insert(root, 10);
		root = CreateBinarySearchTree.insert(root, 14);
		root = CreateBinarySearchTree.insert(root, 13);
		
		List<Node> data = getFloorAndCeil(root, 5);
		
		if(data.get(0) != null) {
			System.out.println(data.get(0).data);
		} else {
			System.out.println("Floor does not exist for the given value");
		}
		
		if(data.get(1) != null) {
			System.out.println(data.get(1).data);
		} else {
			System.out.println("Ceiling does not exist for the given value");
		}
		
	}
	
	//time complexity: O(logN) or O(h) ; space complexity: O(1)
	public static List<Node> getFloorAndCeil(Node node, int val) {
		if(node == null) {
			return new ArrayList<>();
		}
		
		Node floor = null;
		Node ceil = null;
		
		while(node != null) {
			if(val < node.data) {
				ceil = node;
				node = node.left;
			} else if (val > node.data) {
				floor = node;
				node = node.right;
			} else {
				ceil = floor = node;
				break;
			}
		}
		
		List<Node> result = new ArrayList<>();
		result.add(floor);
		result.add(ceil);
		
		return result;
	}

}
