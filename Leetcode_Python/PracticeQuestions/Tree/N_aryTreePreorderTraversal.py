## Given the root of an n-ary tree, return the preorder traversal of its nodes' values.
# Nary-Tree input serialization is represented in their level order traversal. 
# Each group of children is separated by the null value (See examples)

##iterative approach - time complexity - O(N), space complexity - O(N)

# Definition for a Node.
from typing import List


class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children


class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        if root is None:
            return []
        
        stack, output = [root, ], []
        
        while stack:
            root = stack.pop()
            output.append(root.val)
            stack.extend(root.children[::-1])
            
        return output