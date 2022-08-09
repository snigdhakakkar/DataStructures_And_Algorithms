## Given the head of a singly linked list, reverse the list, and return the reversed list.
## Input: head = [1,2,3,4,5]  Output: [5,4,3,2,1]

##Approach 1: Iterative (time complexity - O(N), space complexity - O(1))
# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        prev, curr = None, head
        while curr:
            tmp = curr.next
            curr.next = prev
            prev = curr
            curr = tmp
        return prev

##Approach 2: Recursive approach (time complexity: O(N), space complexity: O(N))
class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        if not head: ##base case
            return None
        
        newHead = head ##final head after reversing initialized from the current head
        if head.next: ##list has not ended
            newHead = self.reverseList(head.next) 
            head.next.next = head
        head.next = None
        return newHead