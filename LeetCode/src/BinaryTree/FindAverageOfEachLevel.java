package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindAverageOfEachLevel {
	
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
		
		System.out.println(levelOrderAverage(root));
		
	}
	
	
	
	public static List<Integer> levelOrderAverage(Node node) {
		
		if(node == null) {
			return new ArrayList<Integer>();
		}
		
		List<Integer> avgList = new ArrayList<Integer>();
		
		Queue<Node> q = new LinkedList<Node>();
		
		q.add(node);
		
		while(true) {
			int size = q.size();
			if(size == 0) {
				break;
			}
			
			int sum = 0;
			int count = 0;
			
			while(size > 0) {
				Node headNode = q.remove();
				
				sum = sum + headNode.data;
				count++;
				
				if(headNode.left != null) {
					q.add(headNode.left);
				}
				
				if(headNode.right != null) {
					q.add(headNode.right);
				}
				
				size--;
			}
			
			avgList.add(sum / count);
		}
		
		return avgList;
		
	}

}
