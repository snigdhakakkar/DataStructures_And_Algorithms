## Given the roots of two binary trees p and q, write a function to check if they are the same or not.
# Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

##Approach 1: Recursion - time complexity: O(N), space complexity: O(N) for unbalanced tree; O(logN) for a balanced tree
# Definition for a binary tree node.
from collections import deque


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def isSameTree(self, p: TreeNode, q: TreeNode) -> bool:
        if not p and not q:
            return True
        if not p or not q:
            return False
        if p.val != q.val:
            return False
        return self.isSameTree(p.right,q.right) and self.isSameTree(p.left, q.left)

## Approach 2: Iteration: time complexity: O(N), space complexity: O(N) for unbalanced tree; O(logN) for a balanced tree

class Solution: 
    def isSameTree(self, p: TreeNode, q: TreeNode) -> bool:
        
        def check(p,q):
            if not p and not q:
                return True
            if not p or not q:
                return False
            if p.val != q.val:
                return False
            return True
        
        deq = deque([(p,q),])
        while deq:
            p,q = deq.popleft()
            if not check(p,q):
                return False
            
            if p:
                deq.append((p.left, q.left))
                deq.append((p.right, q.right))
                
        return True