## Given the root of a binary tree, return the length of the diameter of the tree.
# The diameter of a binary tree is the length of the longest path between any two nodes in a tree. 
# This path may or may not pass through the root.
# The length of a path between two nodes is represented by the number of edges between them.

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def diameterOfBinaryTree(self, root:TreeNode) -> int:
        res = [0] ##global variable
        
        def dfs(root): ##nested function
            if not root:
                return -1 ##height for a null node would be -1 and for a singles leaf node would be 0
            
            leftHeight = dfs(root.left)
            rightHeight = dfs(root.right)
            
            res[0] = max(res[0], 2 + leftHeight + rightHeight) ##taken max of itself and new diameter
            
            return 1 + max(leftHeight, rightHeight) ##returning the height
        
        dfs(root) ##calling the dfs function
        return res[0] ##returning the answer       
        