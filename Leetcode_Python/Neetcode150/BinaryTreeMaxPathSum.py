class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def maxPathSum(self, root: TreeNode) -> int:
        res = [root.val] ##global variable - it's taken as a list to make it's edit easier
        #time complexity: O(n), space complexity: O(n)
        ##return the max path sum without split
        def dfs(root):
            if not root: ##when no root node, return zero
                return 0
            
            leftMax = dfs(root.left) 
            rightMax = dfs(root.right)
            leftMax = max(leftMax, 0) ##handling negative cases
            rightMax = max(rightMax, 0) ##handling negative cases
            
            #compute max path sum with split
            res[0] = max(res[0], root.val + leftMax + rightMax)
            
            return root.val + max(leftMax, rightMax)
        
        dfs(root)
        return res[0]
        