##Given the head of a linked list, return the node where the cycle begins. If there is no cycle, 
# return null. There is a cycle in a linked list if there is some node in the list that can be reached 
# again by continuously following the next pointer. Internally, pos is used to denote the index of the 
# node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos 
# is not passed as a parameter. Do not modify the linked list.

#Approach 1: Using a Hash Set: time compelxity - O(N), space complexity - O(N)
# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class SolutionI:
    def detectCycle(self, head: ListNode) -> ListNode:
        visited = set()
        
        node = head
        while node is not None:
            if node in visited:
                return node
            else:
                visited.add(node)
                node = node.next
                
        return None


