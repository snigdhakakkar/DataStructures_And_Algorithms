# Definition for a binary tree node.
from collections import deque


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

#Approach 1 : Recursive
class Solution:
    def invertTree(self, root: TreeNode) -> TreeNode:
        if not root:
            return None
        
        #swap the children
        tmp = root.left
        root.left =root.right
        root.right = tmp
        
        self.invertTree(root.left)
        self.invertTree(root.right)
        
        return root

#Approach 2: Using deque
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