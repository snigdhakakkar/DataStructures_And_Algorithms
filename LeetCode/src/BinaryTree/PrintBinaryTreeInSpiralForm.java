package BinaryTree;

import java.util.Stack;

public class PrintBinaryTreeInSpiralForm {
	
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
		
		printInSpiralOrder(root);
	}
	
	public static void printInSpiralOrder(Node node) {
		
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();
		
		s1.push(node);
		while(!s1.isEmpty() || !s2.isEmpty()) {
			
			while(!s1.isEmpty()) {
				Node tmp = s1.pop();
				System.out.print(tmp.data + " ");
				
				if(tmp.left != null) {
					s2.push(tmp.left);
				}
				
				if(tmp.right != null) {
					s2.push(tmp.right);
				}
			}
			
			System.out.println();
			
			while(!s2.isEmpty()) {
				Node tmp = s2.pop();
				System.out.print(tmp.data + " ");
				
				if(tmp.right != null) {
					s1.push(tmp.right);
				}
				
				if(tmp.left != null) {
					s1.push(tmp.left);
				}
				
			}
			
			System.out.println();
		}
		
	}

}
