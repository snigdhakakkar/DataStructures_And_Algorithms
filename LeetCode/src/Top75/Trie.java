package Top75;

public class Trie {
	
	private TrieNode root;

    public Trie() {
        
        root = new TrieNode();
        
    }
    
    public void insert(String word) {
        
        TrieNode node = root;
        
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            } 
            
            node = node.get(currentChar);
        }
        
        node.setEnd();
        
    }
    
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }
    
    // search a prefix or whole key in trie and
    // returns the node where search ends
    private TrieNode searchPrefix(String word){
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++){
            char curLetter = word.charAt(i);
            if (node.containsKey(curLetter)) {
                node = node.get(curLetter);
            } else {
                return null;
            }
        }
        
        return node;
    }
    
    
    public boolean startsWith(String prefix) {
        // Returns if there is any word in the trie
        // that starts with the given prefix.
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

}
