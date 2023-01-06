##Iterative Approach: Two Pointer: prev and curr
# time complexity: O(N), space complexity: O(1)
# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class SolutionI:
    def reverseList(self, head: ListNode) -> ListNode:
        prev, curr = None, head
        
        while curr:
            tmp = curr.next
            curr.next = prev
            prev = curr
            curr = tmp
            
        return prev


##Recursive Approach
# time complexity: O(N), space complexity: O(N)