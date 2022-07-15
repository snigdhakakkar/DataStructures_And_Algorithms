##Given the root of a binary search tree, and an integer k, return the kth smallest 
# value (1-indexed) of all the values of the nodes in the tree.


##Approach 1: Iterative
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        n = 0 
        stack = []
        curr = root
        
        while True:
            while curr:
                stack.append(curr)
                curr = curr.left
                
            curr = stack.pop()
            n += 1
            if n == k:
                return curr.val
            
            curr = curr.right