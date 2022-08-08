## Given a string paragraph and a string array of the banned words banned, 
# return the most frequent word that is not banned. It is guaranteed there is at least one word 
# that is not banned, and that the answer is unique.
# The words in paragraph are case-insensitive and the answer should be returned in lowercase.
#
#Example:
# Input: paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.", banned = ["hit"]
# Output: "ball"
# Explanation: 
# "hit" occurs 3 times, but it is a banned word.
# "ball" occurs twice (and no other word does), so it is the most frequent non-banned word 
# in the paragraph. 
# Note that words in the paragraph are not case sensitive,
# that punctuation is ignored (even if adjacent to words, such as "ball,"), 
# and that "hit" isn't the answer even though it occurs more because it is banned.

from typing import List


class Solution:
    def mostCommonWord(self, paragraph: str, banned: List[str]) -> str:
        word_counter = {}
        banned_words = set(banned)
        # 1) Normalize the string (replace non-alphanumeric characters, convert to the lower case)
        normal_str = ''.join(char.lower() if char.isalnum() else ' ' for char in paragraph)
        
        # 2) Tally up every non-banned word
        for word in normal_str.split():
            if word not in banned_words:
                word_counter[word] = word_counter.get(word, 0) + 1
                
        # 3) Find the word with the maximum count value
        curr_max = 0
        max_word = ''
        
        for word in word_counter:
            if word_counter[word] > curr_max:
                curr_max = word_counter[word]
                max_word = word
            
        return max_word
