## Approach 1: Two pointers approach (left and right pointers) after converting LL to Array
## Time Complexity: O(N), space complexity: O(N)

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        nums = []
        
        while head:
            nums.append(head.val)
            head = head.next
        
        l, r = 0, len(nums) - 1
        
        while l < r:
            if nums[l] != nums[r]:
                return False
            l += 1
            r -= 1
            
        return True

## Approach 2: Slow and Fast Pointers Approach to find the middle node, then reversing the second half and comparing the two halves to check if that is indeed a palindrome
# time complexity: O(N), space complexity: O(1)

class SolutionI:
    def isPalindromeI(self, head: ListNode) -> bool:
        fast, slow = head, head
        
        #find middle node (slow)
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            
        #reverse second half
        prev = None
        
        while slow:
            tmp = slow.next
            slow.next = prev
            prev = slow
            slow = tmp
            
        #check if it is a palindrome
        left, right = head, prev
        
        while right:
            if left.val != right.val:
                return False
            left = left.next
            right = right.next
            
        return True
