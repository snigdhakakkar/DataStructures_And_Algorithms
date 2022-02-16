package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class GetRightNodeOfAGivenValueAtSameLevel {
	
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
		
		//time complexity: O(N), space complexity: O(1)
		getRightNodeOfAGivenValueAtSameLevelRecursive(root, 6);
		System.out.println(rightNode1.data);
		
		//time complexity: O(N), space complexity: O(N)
		Node rightNode = getRightNodeOfAGivenValueAtSameLevelIterative(root, 6);
		if(rightNode != null) {
			System.out.println(rightNode.data);
			}
		}
		
		public static void getRightNodeOfAGivenValueAtSameLevelRecursive(Node node, int key) {
			if(node == null || node.data == key) {
				return;
			}
			
			int levelOfKey = getLevelOfAGivenNode(node, key, 1);
			storeRightNode(node, key, levelOfKey);
		}
		
		public static int getLevelOfAGivenNode(Node node, int val, int level) {
			if(node == null) {
				return 0;
			}
			
			int l;
			
			if(node.data == val) {
				return level;
			}
			
			l = getLevelOfAGivenNode(node.left, val, level + 1); 
			
			if(l != 0) {
				return l;
			}
			
			l = getLevelOfAGivenNode(node.right, val, level + 1); 
			
			return l;
			
		}
		
		public static Node rightNode1;
		public static boolean flag;
		
		public static void storeRightNode(Node node, int key, int level) {
			if(node == null) {
				return;
			}
			
			if(level == 1 && (node.data == key || flag)) {
				if(flag) {
					rightNode1 = node;
					return;
				} else {
					flag = true;
				}
			}
			
			storeRightNode(node.left, key, level - 1);
			storeRightNode(node.right, key, level - 1);
			
		}
		
		
		public static Node getRightNodeOfAGivenValueAtSameLevelIterative(Node node, int key) {
			if(node == null || node.data == key) {
				return null;
			}
			
			Queue<Node> q = new LinkedList<Node>();
			q.add(node);
			
			boolean flag1 = false;
			
			while(true) {
				int size = q.size();
				if(size == 0 || flag1) {
					break;
				}
				
				while(size > 0) {
					Node t = q.remove();
					if(flag1) {
						return t;
					}
					
					if(t.data == key) {
						flag1 = true;
					}
					
					if(t.left != null) {
						q.add(t.left);
					}
					
					if(t.right != null) {
						q.add(t.right);
					}
					
					size--;
				}
			}
			
			return null;
			
		}

}
