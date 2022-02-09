package BinaryTree;

import java.util.Stack;

public class PrintPreOrderTraversalWithoutUsingRecursion {
	
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
		
		preOrderUsingStack(root);
	}
	
	
	public static void preOrderUsingStack(Node node) {
		if(node == null) {
			return;
		}
		
		Stack<Node> s = new Stack<Node>();
		
		s.push(node);
		
		while(s.size() > 0) {
			Node t = s.pop();
			System.out.print(t.data + " ");
			
			if(t.right != null) {
				s.push(t.right);
			}
			
			if(t.left != null) {
				s.push(t.left);
			}
		}
	}

}
