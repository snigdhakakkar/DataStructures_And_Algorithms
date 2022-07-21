##Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
# According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T 
# that has both p and q as descendants (where we allow a node to be a descendant of itself).”

##Approach 1: Iterative - time complexity: O(N), Space complexity: O(1)
# Definition for a binary tree node.
class TreeNode:
   def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        curr = root
        
        while curr:
            if p.val > curr.val and q.val > curr.val:
                curr = curr.right
            elif p.val < curr.val and q.val < curr.val:
                curr = curr.left
            else:
                return curr

##Approach 2: Recursive approach - time complexity: O(N), Space complexity: O(N)
class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        curr = root
        
        while curr:
            if p.val > curr.val and q.val > curr.val:
                return self.lowestCommonAncestor(curr.right, p, q)
            elif p.val < curr.val and q.val < curr.val:
                return self.lowestCommonAncestor(curr.left, p, q)
            else:
                return curr
        