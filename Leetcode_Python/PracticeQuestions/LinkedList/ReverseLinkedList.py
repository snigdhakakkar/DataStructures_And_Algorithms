##Given the head of a singly linked list, reverse the list, and return the reversed list.

##Approach 1: Iterative: time complexity - O(N), space complexity - O(1)
# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        prev = None
        curr = head
        while curr:
            tmp = curr.next
            curr.next = prev
            prev = curr
            curr = tmp
        
        return prev
##Approach 2: recursive: time complexity - O(N), space complexity - O(N)
    def reverseListI(self, head: ListNode) -> ListNode:
        if (not head) or (not head.next):
            return head
        
        p = self.reverseList(head.next)
        head.next.next = head
        head.next = None
        return p