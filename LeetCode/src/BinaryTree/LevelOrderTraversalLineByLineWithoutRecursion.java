package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversalLineByLineWithoutRecursion {
	
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
		
		levelOrderTraversalLineByLineWithoutRecursion(root);
	}
	
	public static void levelOrderTraversalLineByLineWithoutRecursion(Node node) {
		if(node == null) {
			return;
		}
		
		Queue<Node> q = new LinkedList<Node>();
		
		q.add(node);
		
		while(true) {
			int count = q.size();
			if(count == 0) {
				break;
			}
			
			while(count > 0) {
				Node top = q.remove();
				System.out.print(top.data + " ");
				
				if(top.left != null) {
					q.add(top.left);
				}
				
				if(top.right != null) {
					q.add(top.right);
				}
				
				count--;
			}
			
			System.out.println();
		}
		
		
	}

}
