##Given the root of a binary tree, return its maximum depth.
# A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

##Approach 1: Recrusion - time complexity: O(N), space complexity in worst case: O(N) & in best case: O(logN)
# Definition for a binary tree node.
from collections import deque


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def maxDepth(self, root: TreeNode) -> int:
        if root is None:
            return 0
        else:
            left_height = self.maxDepth(root.left)
            right_height = self.maxDepth(root.right)
            return max(left_height, right_height) + 1

##Approach 2: Iterative with BFS - time complexity: O(N), space complexity: O(N) or O(logN)

class Solution:
    def maxDepth(self, root: TreeNode) -> int:
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

## Approach 3: Iterative with DFS:  time complexity: O(N), space complexity: O(N) or O(logN)
class Solution:
    def maxDepth(self, root: TreeNode) -> int:
        if not root:
            return 0
        
        stack = [[root, 1]]
        res = 1
        
        while stack:
            node, depth = stack.pop()
            
            if node:
                res = max(res, depth)
                stack.append([node.left, depth + 1])
                stack.append([node.right, depth + 1])
                
        return res