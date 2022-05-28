package Top75;

/*
 * Problem statement: You are given an m x n integer array grid where grid[i][j] could be:

1 representing the starting square. There is exactly one starting square.
2 representing the ending square. There is exactly one ending square.
0 representing empty squares we can walk over.
-1 representing obstacles that we cannot walk over.
Return the number of 4-directional walks from the starting square to the ending
 square, that walk over every non-obstacle square exactly once.
 */

public class unique_pathsIII {
	//time complexity: O(3^N)
	/*
	 * Although technically we have 4 directions to explore at each step, 
	 * we have at most 3 directions to try at any moment except the first step. 
	 * The last direction is the direction where we came from, therefore we don't need
	 *  to explore it, since we have been there before.
	 *  
	 *  In the worst case where none of the cells is an obstacle, 
	 *  we have to explore each cell.  
	 *  Hence, the time complexity of the algorithm is O(4*3^N-1) = O(3^N)
	 *  
	 *  Space complexity: O(N)
	 *  
	 */
	int rows, cols;
    int[][] grid;
    int path_count;
    
    public int uniquePathsIII(int[][] grid) {
        int non_obstacles = 0, start_row = 0, start_col = 0;
        
        this.rows = grid.length;
        this.cols = grid[0].length;
        
        // step 1). initialize the conditions for backtracking
        //   i.e. initial state and final state
        for (int row = 0; row < rows; ++row){
            for (int col = 0; col < cols; ++col) {
                int cell = grid[row][col];
                if (cell >= 0){
                    non_obstacles += 1;
                }
                
                if (cell == 1){
                    start_row = row;
                    start_col = col;
                }
            }
        }
        
        this.path_count = 0;
        this.grid = grid;
        
        // kick-off the backtracking
        backtrack(start_row, start_col, non_obstacles);
        
        return this.path_count;  
    }
    
    protected void backtrack(int row, int col, int remain){
        // base case for the termination of backtracking
        if (this.grid[row][col] == 2 && remain == 1){
            // reach the destination
            this.path_count += 1;
            return;
        }
        
        // mark the square as visited. case: 0, 1, 2
        int temp = grid[row][col];
        grid[row][col] = -4; //in-place modification
        remain -= 1; // we now have one less square to visit
        
        // explore the 4 potential directions around
        int[] row_offsets = {0, 0, 1, -1};
        int[] col_offsets = {1, -1, 0, 0};
        for (int i = 0; i < 4; ++i){
            int next_row = row + row_offsets[i];
            int next_col = col + col_offsets[i];
            
            if (0 > next_row || next_row >= this.rows ||
                0 > next_col || next_col >= this.cols)
                // invalid coordinate
                continue;
            
            if (grid[next_row][next_col] < 0)
                // either obstacle or visited square
                continue;
            
            backtrack(next_row, next_col, remain);
        }
        
        // unmark the square after the visit
        grid[row][col] = temp;
    }

}
