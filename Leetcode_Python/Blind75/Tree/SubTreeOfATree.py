## Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and 
# node values of subRoot and false otherwise. 
# A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. 
# The tree tree could also be considered as a subtree of itself.

##time complexity: O(s.t) 

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def isSubtree(self, s: TreeNode, t: TreeNode) -> bool:
        if not t: 
            return True
        if not s and t:
            return False
        if self.sameTree(s, t):
            return True
        
        return (self.isSubtree(s.left, t) or self.isSubtree(s.right, t))
    
    def sameTree(self, s, t):
        if not s and not t:
            return True
        
        if s and t and s.val == t.val:
            return (self.sameTree(s.left, t.left) and self.sameTree(s.right, t.right))
        
        return False