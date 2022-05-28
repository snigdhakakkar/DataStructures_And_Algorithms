package Top75;

/*
 * Problem statement: ou are given an m x n integer array grid. 
 * 
 * There is a robot initially located at the top-left corner (i.e., grid[0][0]). 
 * 
 * The robot tries to move to the bottom-right corner (i.e., grid[m-1][n-1]). 
 * 
 * The robot can only move either down or right at any point in time.

An obstacle and space are marked as 1 or 0 respectively in grid. 

A path that the robot takes cannot include any square that is an obstacle.

Return the number of possible unique paths that the robot can take to reach the 

bottom-right corner.

The testcases are generated so that the answer will be less than or equal to 2 * 10^9.
 */

public class unique_pathsII {
	
	//DP Approach
	//time complexity: O(MXN); Space complexity: O(1) as obstacle grid 
	//is being used as DP array
	
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int R = obstacleGrid.length;
        int C = obstacleGrid[0].length;
        
        // If the starting cell has an obstacle, then simply return as there would be
        // no paths to the destination.
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        
        // Number of ways of reaching the starting cell = 1.
        obstacleGrid[0][0] = 1;
        
        // Filling the values for the first column
        for (int i = 1; i < R; i++){
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) ? 1 : 0;
        }
        
       // Filling the values for the first row
        for (int i = 1; i < C; i++){
            obstacleGrid[0][i] = (obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1) ? 1 : 0;
        }
        
        // Starting from cell(1,1) fill up the values
        // No. of ways of reaching cell[i][j] = cell[i - 1][j] + cell[i][j - 1]
        // i.e. From above and left.
        for (int i = 1; i < R; i++){
            for (int j = 1; j < C; j++){
                if (obstacleGrid[i][j] == 0){
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                } else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }
        
        // Return value stored in rightmost bottommost cell. That is the destination.
        return obstacleGrid[R - 1][C - 1];
    }

}
