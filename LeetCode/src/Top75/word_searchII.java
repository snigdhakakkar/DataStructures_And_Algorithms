package Top75;

import java.util.ArrayList;
import java.util.List;

/*
 * Problem statement - Given an m x n board of characters and a list of strings words, 
 * return all words on the board.

Each word must be constructed from letters of sequentially adjacent cells, 
where adjacent cells are horizontally or vertically neighboring. 
The same letter cell may not be used more than once in a word.
 */

public class word_searchII {
	
	char[][] _board = null;
    ArrayList<String> _result = new ArrayList<String>();
    
    public List<String> findWords(char[][] board, String[] words) {
        
        // Step 1). Construct the Trie
        trienode_ root = new trienode_();
        for (String word : words){
        	trienode_ node = root;
                 
            for (Character letter : word.toCharArray()){
                if (node.children.containsKey(letter)){
                    node = node.children.get(letter);
                } else {
                	trienode_ newNode = new trienode_();
                    node.children.put(letter, newNode);
                    node = newNode;
                }
            }
            
            node.word = word;  // store words in Trie
        }
        
        this._board = board;
        // Step 2). Backtracking starting for each cell in the board
        for (int row = 0; row < board.length; ++row){
            for (int col = 0; col < board[row].length; ++col){
                if (root.children.containsKey(board[row][col])){
                    backtracking(row, col, root);
                }
            }
        }
        return this._result; 
    }
    
    private void backtracking(int row, int col, trienode_ parent){
        Character letter = this._board[row][col];
        trienode_ currNode = parent.children.get(letter);
        
        // check if there is any match
        if (currNode.word != null) {
            this._result.add(currNode.word);
            currNode.word = null;
            }
        
        // mark the current letter before the EXPLORATION
        this._board[row][col] = '#';
        
        // explore neighbor cells in around-clock directions: up, right, down, left
        int[] rowOffset = {-1, 0, 1, 0};
        int[] colOffset = {0, 1, 0, -1};
        for (int i = 0; i < 4; ++i) {
            int newRow = row + rowOffset[i];
            int newCol = col + colOffset[i];
            
            if (newRow < 0 || newRow >= this._board.length || newCol < 0
            || newCol >= this._board[0].length) {
                continue;
                }
            
            if (currNode.children.containsKey(this._board[newRow][newCol])) {
        backtracking(newRow, newCol, currNode);
            }
        }
        
        // End of EXPLORATION, restore the original letter in the board.
        this._board[row][col] = letter;
        
        //Optimization: incrementally remove the leaf nodes
        if (currNode.children.isEmpty()) {
            parent.children.remove(letter);
        }
    }

}
