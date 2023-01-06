# Definition for a binary tree node.
from collections import deque


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

#Iterative DFS

class Solution:
    def maxDepth(self, root: TreeNode) -> int:
        if not root:
            return 0
        
        stack = [[root, 1]]
        res = 0
        
        while stack:
            node, depth = stack.pop()
            
            if node:
                res = max(res, depth)
                stack.append([node.left, depth + 1])
                stack.append([node.right, depth + 1])
                
        return res


#Recursive DFS
#Time complexity: O(N), space complexity: O(N)

class Solution:
    def maxDepth(self, root: TreeNode) -> int:
        if not root:
            return 0
        
        return 1 + max(self.maxDepth(root.left), self.maxDepth(root.right))

#BFS
#Time complexity: O(N), space complexity: O(N)

## checking number of levels in level order traversal is going to be the same as depth

class SolutionI:
    def maxDepthI(self, root: TreeNode) -> int:
        if not root:
            return 0
        
        level = 0
        q = deque([root])
        
        while q:
            
            for i in range(len(q)):
                node = q.popleft()
                if node.left:
                    q.append(node.left)
                    
                if node.right:
                    q.append(node.right)
                
            level += 1
            
        return level