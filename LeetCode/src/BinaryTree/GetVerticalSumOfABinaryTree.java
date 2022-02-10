package BinaryTree;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class GetVerticalSumOfABinaryTree {
	
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
		
		getVerticalSum(root);
		
	}
	
	public static void getVerticalSum(Node node) {
		
		if(node == null) {
			return;
		}
		
		Map<Integer, Integer> m = new TreeMap<Integer, Integer>();
		
		verticalSum(node, 0, m);
		
		if(m != null) {
			System.out.println(m.values());
		}
	}
	
	public static void verticalSum(Node node, int hd, Map<Integer, Integer> m) {
		
		if(node == null) {
			return;
		}
		
		verticalSum(node.left, hd - 1, m);
		
		int s = (m.get(hd) == null) ? 0 : m.get(hd);
		m.put(hd,  s + node.data);
		
		verticalSum(node.right, hd + 1, m);
		
	}

}
