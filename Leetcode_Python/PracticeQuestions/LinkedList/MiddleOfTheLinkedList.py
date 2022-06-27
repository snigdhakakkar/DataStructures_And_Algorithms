##Given the head of a singly linked list, return the middle node of the linked list.
# If there are two middle nodes, return the second middle node.

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

##Approach 1: Output to array - time complexity: O(N), space complexity - O(N)
class Solution:
    def middleNode(self, head: ListNode) -> ListNode:
        arr = [head]
        while arr[-1].next:
            arr.append(arr[-1].next)
        return arr[len(arr) // 2]

