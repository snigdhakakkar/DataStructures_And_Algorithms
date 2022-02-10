package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class PrintTopViewOfTheTree {
	
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
		
		topViewOfTree(root);
		
	}
	
	public static void topViewOfTree(Node node) {
		
		if(node == null) {
			return;
		}
		
		TreeMap<Integer, Integer> m = new TreeMap<Integer, Integer>();
		Queue<Node> q = new LinkedList<Node>();
		
		q.add(node);
		
		while(!q.isEmpty()) {
			Node temp = q.remove();
			int hd = temp.height;
			
			if(m.get(hd) == null) {
				m.put(hd, temp.data);
			}
			
			if(temp.left != null) {
				temp.left.height = hd - 1;
				q.add(temp.left);
			}
			
			if(temp.right != null) {
				temp.right.height = hd + 1;
				q.add(temp.right);
			}
		}
		System.out.println(m.values());
	}

}
