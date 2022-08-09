## You are given the heads of two sorted linked lists list1 and list2.
# Merge the two lists in a one sorted list. The list should be made by splicing together the nodes 
# of the first two lists. Return the head of the merged linked list.

# Input: list1 = [1,2,4], list2 = [1,3,4]
# Output: [1,1,2,3,4,4]

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def mergeTwoLists(self, l1:ListNode, l2:ListNode) -> ListNode :
        dummy = ListNode()
        curr = dummy
        
        while l1 and l2:
            if l1.val < l2.val:
                curr.next = l1
                l1 = l1.next
                
            else:
                curr.next = l2
                l2 = l2.next
            
            curr = curr.next
            
        if l1:
            curr.next = l1
        elif l2:
            curr.next = l2
            
        return dummy.next