/*
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), 
 * return the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
You may assume all four edges of the grid are all surrounded by water.
 */

//Approach 1: DFS - time complexity : O(MN), space complexity : O(MN)

class Solution {
    public int numIslands(char[][] grid) {
        
        if (grid == null || grid.length == 0){
            return 0;
        }
        
        int nr = grid.length;
        int nc = grid[0].length;
        
        int num_islands = 0;
        for (int r = 0; r < nr; r++){
            for (int c = 0; c < nc; c++){
                if (grid[r][c] == '1') {
                    ++num_islands;
                    dfs(grid, r, c);
                }
            }
        }
       return num_islands;     
        
    }
    
    public void dfs(char[][] grid, int r, int c){
        int nr = grid.length;
        int nc = grid[0].length;
        
        if ( r< 0|| c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }
        
        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }
}

/*
 * Approach 2: BFS (time complexity: O(mn), space complexity: O(min(m,n)))
 */

class SolutionI {
    public int numIslands(char[][] grid) {
        
        if (grid == null || grid.length == 0){
            return 0;
        }
        
        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        
        for (int r = 0; r < nr; r++){
            for (int c = 0; c < nc; c++){
                if(grid[r][c] == '1'){
                    ++num_islands;
                    grid[r][c] = '0'; //mark it as visited
                    Queue<Integer> neighbors = new LinkedList<>();
                    neighbors.add(r * nc + c);
                    
                    while (!neighbors.isEmpty()){
                        int id = neighbors.remove();
                        int row = id / nc;
                        int col = id % nc;
                        
                        if (row - 1 >= 0 && grid[row - 1][col] == '1'){
                            neighbors.add((row - 1) * nc + col);
                            grid[row - 1][col] = '0';
                        }
                        
                        if (row + 1 < nr && grid[row + 1][col] == '1'){
                            neighbors.add((row + 1) * nc + col);
                            grid[row + 1][col] = '0';
                        }
                        
                        if (col - 1 >= 0 && grid[row][col - 1] == '1'){
                            neighbors.add(row * nc + col - 1);
                            grid[row][col - 1] = '0';
                        }
                        
                        if (col + 1 < nc && grid[row][col + 1] == '1'){
                            neighbors.add(row * nc + col + 1);
                            grid[row][col + 1] = '0';
                        }
                    }
                }
            }
        }
        
        return num_islands;
        
    }
}

