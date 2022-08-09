## Given the head of a linked list, reverse the nodes of the list k at a time, and 
# return the modified list.
# k is a positive integer and is less than or equal to the length of the linked list. 
# If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain 
# as it is.
# You may not alter the values in the list's nodes, only nodes themselves may be changed.

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def reverseKGroup(self, head: ListNode, k: int) -> ListNode:
        dummy = ListNode(0, head) ##initializing a dummy node
        groupPrev = dummy ##setting a group previous
        
        while True: ##group of k nodes exist
            kth = self.getKth(groupPrev, k)
            if not kth: ##for the last group
                break
            groupNext = kth.next
            
            #reversing the group
            prev, curr = kth.next, groupPrev.next
            
            while curr != groupNext:
                tmp = curr.next
                curr.next = prev
                prev = curr
                curr = tmp
            
            tmp = groupPrev.next ##changing the pointers for each kth group
            groupPrev.next = kth
            groupPrev = tmp ##updating group prev for further iteration
            
        return dummy.next
            
    def getKth(self, curr, k):
        while curr and k > 0:
            curr = curr.next
            k -= 1
        return curr