package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectNextPointerToLevelOrderSuccessor {
	
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
		
		connectNextPointerToLevelOrderSuccessor(root);
		
	}
	
	public static void connectNextPointerToLevelOrderSuccessor(Node node) {
		
		Node prev = null;
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(node);
		
		while(!q.isEmpty()) {
			node = q.remove();
			
			if(prev != null) {
				prev.next = node;
			}
			
			prev = node;
			
			if(node.left != null) {
				q.add(node.left);
			}
			
			if(node.right != null) {
				q.add(node.right);
			}
		}
	}

}
