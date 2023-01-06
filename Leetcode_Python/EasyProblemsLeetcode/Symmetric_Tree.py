# Definition for a binary tree node.
from collections import deque


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

## Approach 1: Recursive - time complexity: O(N), space complexity: O(N)
class SolutionI:
    def isSymmetric(self, root: TreeNode) -> bool:
        return self.mirror(root, root)
        
    def mirror(self, tree1, tree2):
        if (tree1 is None and tree2 is None):
            return True
            
        if tree1 is None or tree2 is None:
            return False
            
        return ((tree1.val == tree2.val) and self.mirror(tree1.right, tree2.left) and self.mirror(tree1.left, tree2.right))

## Approach 2: Iterative

class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        q = deque()
        q.append(root)
        q.append(root)
        
        while q:
            tree1 = q.popleft()
            tree2 = q.popleft()
            
            if (tree1 is None and tree2 is None):
                continue
            if (tree1 is None and tree2 is not None):
                return False
            if (tree1 is not None and tree2 is None):
                return False
            
            if (tree1.val != tree2.val):
                return False
            
            q.append(tree1.left)
            q.append(tree2.right)
            q.append(tree1.right)
            q.append(tree2.left)
            
        return True