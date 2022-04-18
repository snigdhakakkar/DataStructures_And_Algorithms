package Trees_And_Graphs;

public class Q4_02_Minimal_Tree {
	
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; //we have been given a sorted array to create a binary search tree with minimal height
		
		/*
		 * In order to get a BST with minimal height, we need to ensure that the root node is almost in the middle of the array.
		 * This means that the number of nodes in the left subtree is almost equal to the number of nodes
		 * in the right subtree.
		 *     
		 * One bruteforce method is to traverse the tree each time adding a node and use insert node method - time complexity: O(NlogN)
		 * 
		 * Another method is to pass a subarray each time and pick the middle element to create the node
		 */
		// We needed this code for other files, so check out the code in the library in TreeNode class
		TreeNode root = TreeNode.createMinimalBST(array);
		System.out.println("Root? " + root.data);
		System.out.println("Created BST? " + root.isBST());
		System.out.println("Height: " + root.height());
	}

}
