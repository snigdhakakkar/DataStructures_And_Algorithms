## Given the root of an n-ary tree, return the preorder traversal of its nodes' values.
# Nary-Tree input serialization is represented in their level order traversal. 
# Each group of children is separated by the null value (See examples)

##iterative approach - time complexity - O(N), space complexity - O(N)

# Definition for a Node.
from collections import deque
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

##Approach 2: Recursive solution
class Solution:
    
    def preorder(self, root: 'Node') -> List[int]:
        result = []
        if root is None:
            return []
    
        def preorderhelper(node):
            if not node:
                return
            result.append(node.val)
            for child in node.children:
                preorderhelper(child)
            
        preorderhelper(root)
        return result

##Approach 3: Iterative using a queue
class Solution:
    
    def preorder(self, root: 'Node') -> List[int]:
        result = []
        if root is None:
            return []
    
        q = deque([root])
        
        while q:
            cand = q.popleft()
            result.append(cand.val)
            for c in reversed(cand.children):
                q.appendleft(c)
                
        return result