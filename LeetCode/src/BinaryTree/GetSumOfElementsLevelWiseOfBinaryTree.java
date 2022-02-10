package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class GetSumOfElementsLevelWiseOfBinaryTree {
	
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
		
		getSumLevelWise(root);
		
	}
	
	//Time complexity: O(N); Space complexity: O(N)
	public static void getSumLevelWise(Node node) {
		if(node == null) {
			return;
		}
		
		Queue<Node> q = new LinkedList<Node>();
		
		q.add(node);
		
		while(true) {
			int size = q.size();
			if(size == 0) {
				break;
			}
			int sum = 0;
			
			while(size > 0) {
				Node t = q.remove();
				sum = sum + t.data;
				
				if(t.left != null) {
					q.add(t.left);
				}
				
				if(t.right != null) {
					q.add(t.right);
				}
				
				size--;
			}
			
			System.out.println(sum);
		}
		return;
	}
}
