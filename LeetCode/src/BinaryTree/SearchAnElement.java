package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class SearchAnElement {
	
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
		
		System.out.println(recursiveSearch(root, 11));
		
		System.out.println(iterativeSearch(root, 11));
		
	}
	
	//Time complexity: O(N)
	public static boolean recursiveSearch(Node node, int key) {
		if(node == null) {
			return false;
		}
		
		if(node.data == key) {
			return true;
		}
		
		return recursiveSearch(node.left, key) || recursiveSearch(node.right, key);
	}
	
	//Time complexity: O(N), Space complexity: O(N)
	public static boolean iterativeSearch(Node node, int key) {
		if(node == null) {
			return false;
		}
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(node);
		
		while(!q.isEmpty()) {
			Node t = q.remove();
			if(t.data == key) {
				return true;
			}
			
			if(t.left != null) {
				q.add(t.left);
			}
			
			if(t.right != null) {
				q.add(t.right);
			}
		}
		
		return false;
	}

}
