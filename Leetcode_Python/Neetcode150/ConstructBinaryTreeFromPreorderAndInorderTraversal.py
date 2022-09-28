from typing import List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        #Example: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if not preorder or not inorder:
            return None
        
        root = TreeNode(preorder[0]) #preorder has root as it's first element , here root = 3
        mid = inorder.index(preorder[0]) #finding index of 3 in inorder to get left and right portions: mid: 1
        root.left = self.buildTree(preorder[1:mid + 1], inorder[:mid]) #recursion: left - 1 index to 2 with 2 being non-inclusive in preorder, and up to index 1 in inorder with 1 being non-inclusive 
        root.right = self.buildTree(preorder[mid + 1: ], inorder[mid + 1:]) #right portion: index 2 and beyond for both pre-order and inorder
        return root