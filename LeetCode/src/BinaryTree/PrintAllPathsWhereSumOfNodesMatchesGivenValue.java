package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPathsWhereSumOfNodesMatchesGivenValue {
	
	public static void main(String[] args) {
		BinaryTree a = new BinaryTree();
		Node root = a.createNewNode(2);
		root.left = a.createNewNode(7);
		root.right = a.createNewNode(-9);
		root.right.right = a.createNewNode(3);
		root.left.left = a.createNewNode(-10);
		root.left.right = a.createNewNode(-6);
		root.left.right.left = a.createNewNode(-5);
		root.left.right.right = a.createNewNode(11);
		
		pathsWhereSumOfNodesMatchesGivenValue(root, 12);
		
	}
	
	static List<Integer> elements = new ArrayList<Integer>();
	
	//time complexity: O(N); space complexity: O(N)
	public static void pathsWhereSumOfNodesMatchesGivenValue(Node node, int val){
		
		if(node == null) {
			return;
		}
		
		elements.add(node.data);
		
		pathsWhereSumOfNodesMatchesGivenValue(node.left, val);
		pathsWhereSumOfNodesMatchesGivenValue(node.right, val);
		
		int sum = 0;
		
		for(int i = elements.size() - 1; i >= 0; i--) {
			
			sum = sum + elements.get(i);
			
			if(sum == val) {
				for(int j = i; j < elements.size(); j++) {
					System.out.print(elements.get(j) + " ");
				}
				System.out.println();
			}
		}
		
		elements.remove(elements.size() - 1);
	}

}
