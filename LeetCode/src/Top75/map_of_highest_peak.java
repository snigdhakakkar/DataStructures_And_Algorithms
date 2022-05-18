package Top75;
import java.util.Queue;
import java.util.LinkedList;

/*
 * Problem statement - You are given an integer matrix isWater of size m x n that represents a map of land and water cells.

If isWater[i][j] == 0, cell (i, j) is a land cell.
If isWater[i][j] == 1, cell (i, j) is a water cell.
You must assign each cell a height in a way that follows these rules:

The height of each cell must be non-negative.
If the cell is a water cell, its height must be 0.
Any two adjacent cells must have an absolute height difference of at most 1. A cell is adjacent to another cell if the former is directly north, east, south, or west of the latter (i.e., their sides are touching).
Find an assignment of heights such that the maximum height in the matrix is maximized.

Return an integer matrix height of size m x n where height[i][j] is cell (i, j)'s height. If there are multiple solutions, return any of them.
 */
public class map_of_highest_peak {
	
	int m, n;
    int[][] ans;
    Queue<int[]> queue;
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int[][] highestPeak(int[][] isWater) {
        
        //we can use a BFS
        m = isWater.length;
        n = isWater[0].length;
        ans = new int[m][n];
        queue = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(isWater[i][j] == 1){
                    ans[i][j] = 0;
                    queue.offer(new int[]{i, j});
                } else {
                    ans[i][j] = -1;
                }
            }
        }
        
        //starting the BFS here
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] cur = queue.poll();
                int x = cur[0], y = cur[1];
                for(int k = 0; k < 4; k++) {
                    int newx = x + directions[k][0];
                    int newy = y + directions[k][1];
                    if(newx >= 0 && newx < m && newy >= 0 && newy < n && ans[newx][newy] == -1) {
                        ans[newx][newy] = ans[x][y] + 1;
                        queue.offer(new int[]{newx, newy});
                    }
                }
            }
        }
        
        return ans;
        
    }
}
