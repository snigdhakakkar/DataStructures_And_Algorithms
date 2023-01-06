## Iterative Approach
# time complexity: O(N + M), space complexity: O(1)
# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class SolutionI:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
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
        elif l2:
            tail.next = l2
            
        return dummy.next

class SolutionI:
    def mergeTwoListsI(self, l1: ListNode, l2: ListNode) -> ListNode:
        if l1 is None:
            return l2
        elif l2 is None:
            return l1
        elif l1.val < l2.val:
            l1.next = self.mergeTwoListsI(l1.next, l2)
            return l1
        else:
            l2.next = self.mergeTwoListsI(l1, l2.next)
            return l2

            