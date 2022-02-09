package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
	
	public Node createNewNode(int val) {
		Node a = new Node();
		
		a.data = val;
		a.left = null;
		a.right = null;
		return a;
	}
	
	public void inorder(Node node) {
		if(node == null) {
			return;
		}
		
		inorder(node.left);
		System.out.print(node.data + " ");
		inorder(node.right);
		
	}
	
	public void preorder(Node node) {
		if(node == null) {
			return;
		}
		
		System.out.print(node.data + " ");
		preorder(node.left);
		preorder(node.right);
	}
	
	public void postorder(Node node) {
		if(node == null) {
			return;
		}
		
		postorder(node.left);
		postorder(node.right);
		System.out.print(node.data + " ");
	}
	
	public int getSumOfNodes(Node node) {
		if(node == null) {
			return 0;
		}
		
		return node.data + getSumOfNodes(node.left) + getSumOfNodes(node.right);
	}
	
	
	public int getDifferenceEvenOddValues(Node node) {
		if(node == null) {
			return 0;
		}
		
		return node.data - getDifferenceEvenOddValues(node.left) - getDifferenceEvenOddValues(node.right);
	}
	
	public int getNumberOfNodes(Node node) {
		if(node == null) {
			return 0;
		}
		
		return 1 + getNumberOfNodes(node.left) + getNumberOfNodes(node.right);
	}
	
	public int getNumberOfLeafNodes(Node node) {
		if(node == null) {
			return 0;
		}
		
		if(node.left == null && node.right == null) {
			return 1;
		}
		
		return getNumberOfLeafNodes(node.left) + getNumberOfLeafNodes(node.right);
	}
	
	public int getHeightOfTheTree(Node node) {
		//height is the maximum number of edges from leaf node to the given node
		if(node == null) {
			return -1;
		}
		
		return max(getHeightOfTheTree(node.left), getHeightOfTheTree(node.right)) + 1;
	}
	
	private int max(int a, int b) {
		return a > b ? a : b;
	}
	
	public void printAtGivenLevel(Node node, int level) {
		if(node == null) {
			return;
		}
		
		if(level == 1) {
			System.out.print(node.data + " ");
			return;
		}
		printAtGivenLevel(node.left, level - 1);
		printAtGivenLevel(node.right, level - 1);
		
	}
	
	public void levelOrderTraversalUsingRecursion(Node node){
		if(node == null) {
			return;
		}
		
		int height = getHeightOfTheTree(node);
		for(int i = 0; i <= height; i++) {
			printAtGivenLevel(node, i+1);
			System.out.println();
		}
	}
	
	public void levelOrderTraversalUsingQueue(Node node) {
		if(node == null) {
			return;
		}
		
		Queue<Node> q = new LinkedList<Node>();
		
		q.add(node);
		
		while(q.size() > 0) {
			Node top = q.remove();
			System.out.print(top.data + " ");
			
			if(top.left != null) {
				q.add(top.left);
			}
			
			if(top.right != null) {
				q.add(top.right);
			}
		}
	}
	
	public void reverseLevelOrderTraversalUsingRecursion(Node node) {
		if(node == null) {
			return;
		}
		
		int height = getHeightOfTheTree(node);
		for(int i = height; i >= 0; i--)
		{
			printAtGivenLevel(node, i+1);
			System.out.println();
		}
		
	}
	
	public void reverseLevelOrderTraversalWithoutRecursion(Node node) {
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
	
	public void levelOrderTraversalLineByLineWithoutRecursion(Node node) {
		if(node == null) {
			return;
		}
		
		Queue<Node> q = new LinkedList<Node>();
		
		q.add(node);
		
		while(true) {
			int count = q.size();
			if(count == 0) {
				break;
			}
			
			while(count > 0) {
				Node top = q.remove();
				System.out.print(top.data + " ");
				
				if(top.left != null) {
					q.add(top.left);
				}
				
				if(top.right != null) {
					q.add(top.right);
				}
				
				count--;
			}
			
			System.out.println();
		}
	}
	

}
