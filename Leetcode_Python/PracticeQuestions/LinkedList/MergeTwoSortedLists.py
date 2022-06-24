## You are given the heads of two sorted linked lists list1 and list2. Merge the two lists in a one 
# sorted list. The list should be made by splicing together the nodes of the first two lists.
# Return the head of the merged linked list.

# Definition for singly-linked list.
class ListNode:
        def __init__(self, val=0, next=None):
          self.val = val
          self.next = next
##Approach 1: Recursion - time complexity: O(M + N), space complexity: O(M + N)
class Solution:
    def mergeTwoLists(self, l1, l2):
        if not l1:
            return l2
        elif not l2:
            return l1
        elif l1.val < l2.val:
            l1.next = self.mergeTwoLists(l1.next, l2)
            return l1
        else:
            l2.next = self.mergeTwoLists(l1, l2.next)
            return l2
    ##ITERATIVE APPROACH: time complexity - O(M+N), Space complexity - O(1)
    def mergeTwoListsI(self, l1, l2):
        ##maintain an unchanging reference to node ahead of the return node
        head = ListNode(-1)
        
        tail = head
        while l1 and l2:
            if l1.val <= l2.val:
                tail.next = l1
                l1 = l1.next
            else:
                tail.next = l2
                l2 = l2.next
            tail = tail.next
            
        #atleast one of l1 and l2 can still have remaining nodes at this point, so connecting the non-null list to the end of the merged list
        tail.next = l1 if l1 is not None else l2
        
        return head.next