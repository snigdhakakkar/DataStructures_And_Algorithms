## There is a new alien language that uses the English alphabet. However, the order among the letters 
# is unknown to you. You are given a list of strings words from the alien language's dictionary, where the 
# strings in words are sorted lexicographically by the rules of this new language. Return a string of the 
# unique letters in the new alien language sorted in lexicographically increasing order by the new language's 
# rules. If there is no solution, return "". If there are multiple solutions, return any of them. A string s 
# is lexicographically smaller than a string t if at the first letter where they differ, the letter in 
# s comes before the letter in t in the alien language. If the first min(s.length, t.length) letters are the 
# same, then s is smaller if and only if s.length < t.length.

##Approach 1: BFS - 
from collections import defaultdict, Counter, deque
from typing import List

class Solution:
    
    def alienOrder(self, words: List[str]) -> str:
        # Step 0: create data structures + the in_degree of each unique letter to 0.
        adj_list = defaultdict(set)
        in_degree = Counter({c : 0 for word in words for c in word})
        
        ##Step 1: we need to populate adj_list and in_degree
        # for each pair of adjacent words..
        for first_word, second_word in zip(words, words[1:]):
            for c, d in zip(first_word, second_word):
                if c != d:
                    if d not in adj_list[c]:
                        adj_list[c].add(d)
                        in_degree[d] += 1
                        
                    break
            else: #check that second word in not a prefix of the first word
                    if len(second_word) < len(first_word): return ""
                    
        #step 2: we need to repeatedly pick off nodes with indegree of 0
        output = []
        queue = deque([c for c in in_degree if in_degree[c] == 0])
        while queue:
            c = queue.popleft()
            output.append(c)
            for d in adj_list[c]:
                in_degree[d] -=1
                if in_degree[d] == 0:
                    queue.append(d)
                    
        ##if not all the letters are in the output, that means there was a cycle and so no valid ordering. Return "" as per the problem description
        if len(output) < len(in_degree):
            return ""
        
        #otherwise convert the ordering we got into a string and return it
        return "".join(output)

    ##Approach 2: Topological sort / postorder DFS

    def alienOrder(self, words: List[str]) -> str:
        adj_list = {c:set() for word in words for c in word}
        
        for i in range(len(words) - 1):
            w1, w2 = words[i], words[i + 1]
            minLen = min(len(w1), len(w2))
            if len(w1) > len(w2) and w1[:minLen] == w2[:minLen]:
                return ""
            
            for j in range(minLen):
                if w1[j] != w2[j]:
                    adj_list[w1[j]].add(w2[j])
                    break
                    
        visit = {} #False: visited, True: in current path
        output = []
        
        def dfs(c):
            if c in visit:
                return visit[c]
            
            visit[c] = True
            for neighbor in adj_list[c]:
                if dfs(neighbor):
                    return True
            visit[c] = False
            output.append(c)
        
        for c in adj_list:
            if dfs(c):
                return ""
            
        output.reverse()
        return "".join(output)