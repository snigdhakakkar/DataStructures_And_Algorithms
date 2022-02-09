package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseLevelOrderTraversalWithoutRecursion {
	
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
		
		reverseLevelOrderTraversalWithoutRecursion(root);
	}
	
	public static void reverseLevelOrderTraversalWithoutRecursion(Node node) {
		if(node == null) {
			return;
		}
		
		Queue<Node> q = new LinkedList<Node>();
		
		q.add(node);
		
		Stack<Node> s = new Stack<Node>();
		
		while(q.size() > 0) {
			Node t = q.remove();
			
			if(t.right != null) {
				q.add(t.right);
			}
			
			if(t.left != null) {
				q.add(t.left);
			}
			
			s.push(t);
		}
		
		while(s.size() > 0) {
			System.out.print(s.pop().data + " ");
		}
	}

}
