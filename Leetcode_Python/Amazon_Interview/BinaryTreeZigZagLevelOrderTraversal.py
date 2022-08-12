## Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. 
# (i.e., from left to right, then right to left for the next level and alternate between).

#Example -
# Input: root = [3,9,20,null,null,15,7]
# Output: [[3],[20,9],[15,7]]

# Definition for a binary tree node.
from collections import deque
from typing import List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

## Approach 1: DFS - time complexity: O(N), space complexity: O(N)

class Solution:
    def zigzagLevelOrder(self, root: TreeNode) -> List[List[int]]:
        res = []
        
        def dfs(node, level, res):
            if not node:
                return
            
            if len(res) <= level:
                res.append(deque([]))
            
            dfs(node.left, level + 1, res)
            dfs(node.right, level + 1, res)
            
            if level%2 == 0:
                res[level].append(node.val)
                
            else:
                res[level].appendleft(node.val)
                
        dfs(root, 0, res)
        return res