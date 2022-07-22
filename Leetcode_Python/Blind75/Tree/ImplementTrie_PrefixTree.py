##A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently 
# store and retrieve keys in a dataset of strings. There are various applications of this data 
# structure, such as autocomplete and spellchecker.
# 
# Implement the Trie class:
#Trie() Initializes the trie object.
# void insert(String word) Inserts the string word into the trie.
# boolean search(String word) Returns true if the string word is in the trie (i.e., 
# was inserted before), and false otherwise.
# boolean startsWith(String prefix) Returns true if there is a previously inserted string word 
# that has the prefix prefix, and false otherwise.

##Application of trie: Auto-correct and spell-checker
##time complexity for startsWith: O(1)

class TrieNode:
    def __init__(self):
        self.children = {}
        self.endOfWord = False
        
class Trie:

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        curr = self.root
        
        for c in word:
            if c not in curr.children:
                curr.children[c] = TrieNode()
            curr = curr.children[c]
        curr.endOfWord = True
        

    def search(self, word: str) -> bool:
        curr = self.root
        
        for c in word:
            if c not in curr.children:
                return False
            curr = curr.children[c]
        return curr.endOfWord 
        

    def startsWith(self, prefix: str) -> bool:
        curr = self.root
        
        for c in prefix:
            if c not in curr.children:
                return False
            curr = curr.children[c]
        return True
    
            
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)