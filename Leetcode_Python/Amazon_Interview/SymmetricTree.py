## Given the root of a binary tree, check whether it is a mirror of itself 
# (i.e., symmetric around its center).

#Example:
# Input: root = [1,2,2,3,4,4,3], Output: true

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if not root:
            return True
        
        
        return self.isMirror(root.left, root.right)
    
    def isMirror(self, leftRoot, rightRoot):
        if not leftRoot and not rightRoot:
            return True
        
        if not leftRoot or not rightRoot:
            return False
        
        if leftRoot and rightRoot:
            return ((leftRoot.val == rightRoot.val) and 
                    self.isMirror(leftRoot.left, rightRoot.right) and 
                     self.isMirror(leftRoot.right, rightRoot.left))

