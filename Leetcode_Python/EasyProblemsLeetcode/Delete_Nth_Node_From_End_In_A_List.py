# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
        
class Solution:
    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        dummy = ListNode(0, head)
        left = dummy
        right = head
        
        #move the right pointer to head + offset position
        while n > 0 and right:
            right = right.next
            n = n - 1
            
        while right:
            left = left.next
            right = right.next
            
        #delete the node and update next pointers
        left.next = left.next.next
        
        return dummy.next