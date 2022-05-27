package Top75;

import java.util.HashMap;

/*
 * Problem statement - The thief has found himself a new place for his thievery again. 
 * There is only one entrance to this area, called root.

Besides the root, each house has one and only one parent house. 
After a tour, the smart thief realized that all houses in this place form a 
binary tree. It will automatically contact the police if two directly-linked houses 
were broken into on the same night.

Given the root of the binary tree, return the maximum amount of money the thief 
can rob without alerting the police.
 */

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */

public class house_robberIII {
	//recursion approach
	//time complexity: O(N) as we visit all nodes once
	//space complexity: O(N) as we need stacks for recursion; 
	//max length of array is N and depth of tree logN; 
	//thus best case scenario: O(logN) and worst case scenario: O(N)
	public int rob(TreeNode root) {
        
        int[] answer = helper(root);
        return Math.max(answer[0], answer[1]);
    }
    
    public int[] helper(TreeNode node){
        // return [rob this node, not rob this node]
        if (node == null) {
            return new int[] { 0, 0 };
        }
        
        int left[] = helper(node.left);
        int right[] = helper(node.right);
        
        // if we rob this node, we cannot rob its children
        int rob = node.val + left[1] + right[1];
        
        // else, we free to choose rob its children or not
        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        
        return new int[] {rob, notRob};
        
    }
    
    //recursion with memoization approach
    //time complexity: O(N) as we visit all nodes once
  	//space complexity: O(N) as we use two hashmaps
    HashMap<TreeNode, Integer> robResult = new HashMap<>();
    HashMap<TreeNode, Integer> notRobResult = new HashMap<>();
    
    public int rob(TreeNode root) {
        return helper(root, false);
    }
    
    public int helper(TreeNode node, boolean parentRobbed) {
        if (node == null) {
            return 0;
        }
        
        if (parentRobbed){
            if (robResult.containsKey(node)){
                return robResult.get(node);
            }
            
            int result = helper(node.left, false) + helper(node.right, false);
            robResult.put(node, result);
            return result;
        } else {
            if (notRobResult.containsKey(node)) {
                return notRobResult.get(node);
            } 
            int rob = node.val + helper(node.left, true) + helper(node.right, true);
            int notRob = helper(node.left, false) + helper(node.right, false);
            int result = Math.max(rob, notRob);
            notRobResult.put(node, result);
            return result;
        }
    }
	

}
