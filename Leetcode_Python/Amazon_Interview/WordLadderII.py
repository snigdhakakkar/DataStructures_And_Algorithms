## A transformation sequence from word beginWord to word endWord using a dictionary wordList 
# is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
# Every adjacent pair of words differs by a single letter.
# Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
# sk == endWord
# Given two words, beginWord and endWord, and a dictionary wordList, return all the shortest 
# transformation sequences from beginWord to endWord, or an empty list if no such sequence exists. 
# Each sequence should be returned as a list of the words [beginWord, s1, s2, ..., sk].

# Example 1:

# Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
# Output: [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
# Explanation: There are 2 shortest transformation sequences:
# "hit" -> "hot" -> "dot" -> "dog" -> "cog"
# "hit" -> "hot" -> "lot" -> "log" -> "cog"

import collections
class Solution:
    def findLadders(self, beginWord: str, endWord: str, wordList: List[str]) -> List[List[str]]:
        if endWord not in wordList:
            return []
        
        nei = collections.defaultdict(list)
        wordList.append(beginWord)
        
        for word in wordList:
            for j in range(len(word)):
                pattern = word[:j] + "*" + word[j+1:]
                nei[pattern].append(word)
                
                
        '''
        graph = collections.defaultdict(list)
        for word in wordList:
            for i in range(len(word)):
                graph[word[:i] + '*' + word[i+1:]].append(word)
        '''
                
        queue = collections.deque()
        queue.append((beginWord, [beginWord])) #word, path
        output = []
        visited = {beginWord:1}
        
        while queue:
            for _ in range(len(queue)):
                word, path = queue.popleft()
                if word == endWord:
                    output.append(path)
                    continue
                
                for j in range(len(word)):
                    pattern = word[:j] + "*" + word[j+1:]
                    
                    for neiWord in nei[pattern]:
                         if neiWord not in visited or len(path) <= visited[neiWord]:
                                visited[neiWord] = len(path)
                                queue.append((neiWord, path + [neiWord]))
                        
                
            '''
            for i in range(len(word)):
                for candidate in graph[word[:i] + '*' + word[i+1:]]:
                    if candidate not in visited or len(path) <= visited[candidate]:
                        visited[candidate] = len(path)
                        queue.append((candidate, path + [candidate]))
            '''
        return output
                    