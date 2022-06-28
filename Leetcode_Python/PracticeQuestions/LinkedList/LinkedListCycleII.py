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

##Approach 2: Floyd's Tortoise and hare approach - O(N), space complexity - O(1)
class SolutionII:
    def detectCycle(self, head: ListNode) -> ListNode:
        if head is None:
            return None
        
        # if there is a cycle, the fast/slow pointers will intersect at some node. otherwise, there is no cycle, so we canot find an entrance to the cycle
        intersect = self.getIntersect(head)
        if intersect is None:
            return None
        
        ##to find the entrance to the cycle, we have two pointers, which traverse at the same speed -- one from the front of the list, and the other from the point of intersection
        ptr1 = head
        ptr2 = intersect
        while ptr1 != ptr2:
            ptr1 = ptr1.next
            ptr2 = ptr2.next
        
        return ptr1
    
    def getIntersect(self, head):
        tortoise = head
        hare = head
        
        #a fast pointer will either loop around a cycle and meet the slow pointer or reach the null at the end of the non-cyclic list
        
        while hare is not None and hare.next is not None:
            tortoise = tortoise.next
            hare = hare.next.next
            if tortoise == hare:
                return tortoise
            
        return None
        
