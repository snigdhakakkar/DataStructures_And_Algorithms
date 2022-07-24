##Design a data structure that supports adding new words and finding if a string matches any 
# previously added string.
# Implement the WordDictionary class:
# WordDictionary() Initializes the object
# void addWord(word) Adds word to the data structure, it can be matched later.
# bool search(word) Returns true if there is any string in the data structure that 
# matches word or false otherwise. word may contain dots '.' 
# where dots can be matched with any letter.

class TrieNode:
    
    def __init__(self):
        self.children = {}
        self.endOfWord = False
    
    
class WordDictionary:

    def __init__(self):
        self.root = TrieNode()
        

    def addWord(self, word: str) -> None:
        curr = self.root
        
        for c in word:
            if c not in curr.children:
                curr.children[c] = TrieNode()
            curr = curr.children[c]
        curr.endOfWord = True
        

    def search(self, word: str) -> bool:
        def dfs(j, root):
            curr = root
            for i in range(j, len(word)):
                c = word[i]
                if c == ".":
                    for child in curr.children.values():
                        if dfs(i + 1, child):
                            return True
                    return False
                else:
                    if c not in curr.children:
                        return False
                    curr = curr.children[c]   
            return curr.endOfWord
        return dfs(0, self.root)
                  
        


# Your WordDictionary object will be instantiated and called as such:
# obj = WordDictionary()
# obj.addWord(word)
# param_2 = obj.search(word)