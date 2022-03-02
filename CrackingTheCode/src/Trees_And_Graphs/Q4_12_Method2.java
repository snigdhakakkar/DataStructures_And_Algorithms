package Trees_And_Graphs;

import java.util.HashMap;
//time complexity: O(N), space complexity: O(logN) for a balanced tree
public class Q4_12_Method2 {
	
	public static int countPathsWithSum(TreeNode root, int targetSum) {
		return countPathsWithSum(root, targetSum, 0, new HashMap<Integer, Integer>());
	}
	
	public static int countPathsWithSum(TreeNode node, int targetSum, int runningSum, HashMap<Integer, Integer> pathCount) {
		if (node == null) {
			return 0;
		}
		
		runningSum += node.data;
		
		/* Count paths with sum ending at the current node. */
		/* Count paths with sum ending at the current node. */
		int sum = runningSum - targetSum;
		
		int totalPaths = pathCount.getOrDefault(sum, 0);
		
		/* If runningSum equals targetSum, then one additional path starts at root. Add in this path.*/
		if (runningSum == targetSum) {
			totalPaths++;
		}
		
		/* Add runningSum to pathCounts. */
		incrementHashTable(pathCount, runningSum, 1);
		
		/* Count paths with sum on the left and right. */
		totalPaths += countPathsWithSum(node.left, targetSum, runningSum, pathCount);
		totalPaths += countPathsWithSum(node.right, targetSum, runningSum, pathCount);
		
		incrementHashTable(pathCount, runningSum, -1); // Remove runningSum
		return totalPaths;
		
	}
	
	public static void incrementHashTable(HashMap<Integer, Integer> hashTable, int key, int delta) {
		int newCount = hashTable.getOrDefault(key, 0) + delta;
		
		if (newCount == 0) { // Remove when zero to reduce space usage
			hashTable.remove(key);
		} else {
			hashTable.put(key, newCount);
		}
	}
	
	public static void main(String [] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);		
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(-8);
		root.left.right = new TreeNode(8);
		root.right.left = new TreeNode(2);
		root.right.right = new TreeNode(6);	
		System.out.println(countPathsWithSum(root, 0));
		System.out.println();
		
		TreeNode root1 = new TreeNode(-7);
		root1.left = new TreeNode(-7);
		root1.left.right = new TreeNode(1);
		root1.left.right.left = new TreeNode(2);
		root1.right = new TreeNode(7);
		root1.right.left = new TreeNode(3);
		root1.right.right = new TreeNode(20);
		root1.right.right.left = new TreeNode(0);
		root1.right.right.left.left = new TreeNode(-3);
		root1.right.right.left.left.right = new TreeNode(2);
		root1.right.right.left.left.right.left = new TreeNode(1);
		System.out.println(countPathsWithSum(root1, -14));
		System.out.println();
		
		TreeNode root2 = new TreeNode(0);
		root2.left = new TreeNode(0);
		root2.right = new TreeNode(0);
		root2.right.left = new TreeNode(0);
		root2.right.left.right = new TreeNode(0);
		root2.right.right = new TreeNode(0);
		System.out.println(countPathsWithSum(root2, 0));
		System.out.println();
		System.out.println(countPathsWithSum(root2, 4));
		System.out.println();
	}

}
