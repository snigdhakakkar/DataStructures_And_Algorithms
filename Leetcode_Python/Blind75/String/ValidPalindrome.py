##A phrase is a palindrome if, after converting all uppercase letters into lowercase letters 
# and removing all non-alphanumeric characters, it reads the same forward and backward. 
# Alphanumeric characters include letters and numbers.
# Given a string s, return true if it is a palindrome, or false otherwise.

## Approach 1: Compare with Reverse: time complexity - O(N), space complexity - O(N)

def isPalindrome(self, s: str) -> bool:
        
        filtered_char = filter(lambda ch: ch.isalnum(), s)
        lower_filtered_char = map(lambda ch: ch.lower(), filtered_char)
        
        filtered_char_list = list(lower_filtered_char)
        reversed_char_list = filtered_char_list[::-1]
        
        return filtered_char_list==reversed_char_list

