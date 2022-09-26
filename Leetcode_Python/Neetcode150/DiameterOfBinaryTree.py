# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
    def diameterOfBinaryTree(self, root:TreeNode) -> int:
        res = [0] 
        
        def dfs(root):
            if not root:
                return -1 #default height as -1 for null tree
            
            leftHeight = dfs(root.left)
            rightHeight = dfs(root.right)
            
            res[0] = max(res[0], 2 + leftHeight + rightHeight)
            
            return 1 + max(leftHeight, rightHeight)
        
        dfs(root)
        return res[0]