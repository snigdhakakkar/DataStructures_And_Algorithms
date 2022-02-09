package BinaryTree;

import java.util.Stack;

public class PrintInOrderTraversalWithoutUsingRecursion {
	
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
		
		inOrderUsingStack(root);
	}
	
	public static void inOrderUsingStack(Node node) {
		if(node == null) {
			return;
		}
		
		Stack<Node> s = new Stack<Node>();
		while(node != null) {
			s.push(node);
			node = node.left;
		}
		
		while(s.size() > 0) {
			Node t = s.pop();
			System.out.print(t.data + " ");
			if(t.right != null) {
				Node tmp = t.right;
				while(tmp != null) {
					s.push(tmp);
					tmp = tmp.left;
				}
			}
		}
	}

}
