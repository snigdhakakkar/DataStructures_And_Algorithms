package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class PrintElementsBetweenGivenTwoLevels {
	
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
		
		printElementsBetweenGivenTwoLevels(root, 2, 3);
	}
	
	public static void printElementsBetweenGivenTwoLevels(Node node, int min, int max) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(node);
		int l = 1;
		
		while(true) {
			int size = q.size();
			if(size == 0 || l > max) {
				break;
			}
			
			while(size > 0) {
				Node t = q.remove();
				if(l >= min && l <= max) {
					System.out.print(t.data + " ");
				}
				
				if(t.left != null) {
					q.add(t.left);
				}
				
				if(t.right != null) {
					q.add(t.right);
				}
				
				size--;
			}
			
			l++;
		}
	}

}
