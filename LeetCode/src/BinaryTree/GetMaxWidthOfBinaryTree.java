package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class GetMaxWidthOfBinaryTree {
	
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
		
		System.out.println(max_width(root));
		
	}
	
	//Time complexity = O(N), Space complexity = O(N)
	public static int max_width(Node node) {
		if(node == null) {
			return 0;
		}
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(node);
		int max_width = 1;
		
		while(true) {
		int size = q.size();
		if(size == 0) {
			break;
			}
		if(size > max_width) {
			max_width = size;
		}
		
		while(size > 0) {
			Node t = q.remove();
		
		if(t.left != null) {
			q.add(t.left);
		}
		
		if(t.right != null) {
			q.add(t.right);
		}
		
		size--;
		
		}
	}
	return max_width;	
	}

}
