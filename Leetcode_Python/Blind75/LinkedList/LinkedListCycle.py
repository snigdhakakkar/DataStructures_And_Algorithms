## Given head, the head of a linked list, determine if the linked list has a cycle in it. 
# There is a cycle in a linked list if there is some node in the list that can be reached again 
# by continuously following the next pointer. Internally, pos is used to denote the index of the 
# node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
# Return true if there is a cycle in the linked list. Otherwise, return false.

# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

##Approach 1: Using a hashset - time complexity: O(N), space complexity - O(N)
class SolutionI:
    def hasCycle(self, head: ListNode) -> bool:
        visited = set()
        
        node = head
        while node is not None:
            if node in visited:
                return True
            visited.add(node)
            node = node.next
        return False

##Approach 2: Two pointer approach: time comlexity - O(N), space complexity - O(1)
class Solution:
    def hasCycle(self, head: ListNode) -> bool:
        if head is None:
            return False
        
        slow = head
        fast = head.next
        while slow != fast:
            if fast is None or fast.next is None:
                return False
            slow = slow.next
            fast = fast.next.next
            
        return True
    