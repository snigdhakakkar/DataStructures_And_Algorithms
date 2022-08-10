## You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
# Merge all the linked-lists into one sorted linked-list and return it.

# Example:
# Input: lists = [[1,4,5],[1,3,4],[2,6]]
# Output: [1,1,2,3,4,4,5,6]



# Definition for singly-linked list.
from typing import List


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
        
class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        if not lists or len(lists) == 0:
            return None
        
        while len(lists) > 1:
            mergedList = []
            
            for i in range(0, len(lists), 2):
                l1 = lists[i]
                l2 = lists[i+1] if (i+1) < len(lists) else None
                
                mergedList.append(self.mergeList(l1,l2))
                
            lists = mergedList
        return lists[0]
        
        
    def mergeList(self, l1, l2):
        dummy = ListNode()
        tail = dummy
        
        while l1 and l2:
            if l1.val < l2.val:
                tail.next = l1
                l1 = l1.next
                
            else:
                tail.next = l2
                l2 = l2.next
                
            tail = tail.next
        if l1:
            tail.next = l1
        if l2:
            tail.next = l2
        return dummy.next