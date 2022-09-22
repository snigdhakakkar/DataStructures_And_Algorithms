# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def reverseKGroup(self, head: ListNode, k: int) -> ListNode:
        dummy = ListNode(0, head) ##taking dummy node handles the cases of empty list
        groupPrev = dummy 
        
        while True: ##group of k nodes exist
            kth = self.getKth(groupPrev, k)
            if not kth:
                break
            groupNext = kth.next
            
            #reversing the group
            prev, curr = kth.next, groupPrev.next # can't take prev as None as it would split the list
            
            while curr != groupNext: ##end of reversing would be when curr approaches groupNext
                tmp = curr.next
                curr.next = prev
                prev = curr
                curr = tmp
            
            tmp = groupPrev.next ##storing groupPrev.next i.e. present head
            groupPrev.next = kth ## Now, updating links of groupPrev.next as list has reversed
            groupPrev = tmp ## Updating the groupPrev pointer to next kth group prev
            
        return dummy.next
            
    def getKth(self, curr, k):
        while curr and k > 0:
            curr = curr.next
            k -= 1
        return curr
        