package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class FindMinHeightOfBinaryTree {
	
	public static int min_Height = Integer.MAX_VALUE;
	
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
		
		System.out.println(findMinHeightLevelWise(root));
		System.out.println(minHeight(root));
		findMinHeightRecursive(root, 1);
		System.out.println(min_Height);
		
	}
	
	//Method1 - Level Order Traversal: Time complexity: O(N), Space complexity: O(N)
	public static int findMinHeightLevelWise(Node node) {
		
		if(node == null) {
			return 0;
		}
		
		int height = 1;
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(node);
		
		while(true) {
			int size = q.size();
			
			if(q.isEmpty() || size == 0) {
				break;
			}
			
			while(size > 0) {
				Node temp = q.remove();
				
				if(temp.left == null && temp.right == null) {
					return height;
				}
				
				if(temp.left != null) {
					q.add(temp.left);
				}
				
				if(temp.right != null) {
					q.add(temp.right);
				}
				
				size--;
			}
			height++;
		}
		return height;
	}
	
	//Method2: recursively calling - Time complexity: O(N), Space complexity: O(N) if we consider system stack usage else its O(1)
	public static int minHeight(Node node) {
		
		if(node == null) {
			return 0;
		}
		
		if(node.left == null && node.right == null) {
			return 1;
		}
		
		if(node.left == null) {
			return minHeight(node.right) + 1;
		}
		
		if(node.right == null) {
			return minHeight(node.left) + 1;
		}
		
		return Math.min(minHeight(node.left), minHeight(node.right)) + 1;
	}
	
	//Method3: Time complexity: O(N), Space complexity: O(N) if we consider system stack usage else its O(1)
	public static void findMinHeightRecursive(Node node, int height) {
		
		if(node == null) {
			return;
		}
		
		if(node.left == null && node.right == null && height < min_Height) {
			min_Height = height;
		}
		
		findMinHeightRecursive(node.left, height + 1);
		findMinHeightRecursive(node.right, height + 1);
	}
	
	

}
