##Given the root of a binary tree, invert the tree, and return its root.

##Approach 1: recursive : time complexity - O(N), space complexity - O(logN) for a balanced tree; O(N) for an imbalanced tree
# Definition for a binary tree node.
from collections import deque


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def invertTree(self, root: TreeNode) -> TreeNode:
        if not root:
            return None
        
        tmp = root.left
        root.left = root.right
        root.right = tmp
        
        self.invertTree(root.left)
        self.invertTree(root.right)
        return root

##Iterative Approach
class Solution:
    def invertTree(self, root: TreeNode) -> TreeNode:
        if not root:
            return None
        
        q = deque([root])
        while q:
            curr = q.popleft()
            curr.left, curr.right = curr.right, curr.left
                
            if curr.left:
                q.append(curr.left)
                
            if curr.right:
                q.append(curr.right)
                
        return root
        