## You are given an array of logs. Each log is a space-delimited string of words, 
# where the first word is the identifier.
# There are two types of logs:
# 
# Letter-logs: All words (except the identifier) consist of lowercase English letters.
# Digit-logs: All words (except the identifier) consist of digits.
# Reorder these logs so that:
# 
# The letter-logs come before all digit-logs.
# The letter-logs are sorted lexicographically by their contents. If their contents are the same, 
# then sort them lexicographically by their identifiers.
# The digit-logs maintain their relative ordering.
# Return the final order of the logs.

from typing import List


class Solution:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        res1, res2 = [], []
        for log in logs:
            if (log.split()[1]).isdigit():
                res2.append(log)
            else:
                res1.append(log)
                
        return sorted(res1, key = lambda x:(x.split(' ', 1)[1:], x.split(' ', 1)[0] )) + res2   