package BinaryTree;

import java.util.Stack;

public class PrintPostOrderTraversalWithoutUsingRecursion {
	
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
		
		postOrderUsingStack(root);
	}
	
	public static void postOrderUsingStack(Node node) {
		if(node == null) {
			return;
		}
		
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();
		
		s1.push(node);
		
		while(s1.size() > 0) {
			Node t = s1.pop();
			
			if(t.left != null) {
				s1.push(t.left);
			}
			
			if(t.right != null) {
				s1.push(t.right);
			}
			
			s2.push(t);
		}
		
		while(s2.size() > 0) {
			System.out.print(s2.pop().data + " ");
		}
	}

}
