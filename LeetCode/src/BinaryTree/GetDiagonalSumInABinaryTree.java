package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class GetDiagonalSumInABinaryTree {
	
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
		
		getDiagonalSum(root);
		
	}
	
	//time complexity: O(N), space complexity: O(N)
	public static void getDiagonalSum(Node node) {
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
			
			int s = 0;
			
			while(size > 0) {
				Node temp = q.remove();
				
				while(temp != null) {
					s = s + temp.data;
					
					if(temp.left != null) {
						q.add(temp.left);
					}
					
					temp = temp.right;
				}
				
				size--;
			}
			
			System.out.println(s);
		}
	}

}
