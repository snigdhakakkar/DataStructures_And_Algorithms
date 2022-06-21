package PracticeQuestions.Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* You are given an m x n grid rooms initialized with these three possible values.
# -1 A wall or an obstacle.
# 0 A gate.
# INF Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent 
# INF as you may assume that the distance to a gate is less than 2147483647.
# Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, 
# it should be filled with INF.

Screenshot 2022-06-20 at 1.58.14 PM.png*/

/*Approach 1: Time complexity : O(m^2n^2). For each point in the m×n size grid, 
the gate could be at most m×n steps away.

Space complexity : O(mn). The space complexity depends on the queue's size. 
Since we won't insert points that have been visited before into the queue, 
we insert at most m \times nm×n points into the queue.
*/
class Solution {
    private static final int EMPTY = Integer.MAX_VALUE;
    private static final int GATE = 0;
    private static final int WALL = -1;
    private static final List<int[]> DIRECTIONS = Arrays.asList(
            new int[] {1, 0},
            new int[] {-1, 0},
            new int[] {0, 1},
            new int[] {0, -1}
    );
    
    
    public void wallsAndGates(int[][] rooms) {
        
        if (rooms.length == 0){
            return;
        }
        
        for (int row = 0; row < rooms.length; row++) {
            for (int col = 0; col < rooms[0].length; col++) {
                if (rooms[row][col] == EMPTY){
                    rooms[row][col] = distanceToNearestGate(rooms, row, col);
                }
            }
        }
        
    }
    
    private int distanceToNearestGate(int[][] rooms, int startRow, int startCol) {
    int m = rooms.length;
    int n = rooms[0].length;
    int[][] distance = new int[m][n];
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[] { startRow, startCol });
    while (!q.isEmpty()) {
        int[] point = q.poll();
        int row = point[0];
        int col = point[1];
        for (int[] direction : DIRECTIONS) {
            int r = row + direction[0];
            int c = col + direction[1];
            if (r < 0 || c < 0 || r >= m || c >= n || rooms[r][c] == WALL
                    || distance[r][c] != 0) {
                continue;
            }
            distance[r][c] = distance[row][col] + 1;
            if (rooms[r][c] == GATE) {
                return distance[r][c];
            }
            q.add(new int[] { r, c });
        }
    }
    return Integer.MAX_VALUE;
    }
}

/*
 * Approach 2: Starting BFS with the gate first: time complexity: O(mn), space complexity: O(mn)
 */

class SolutionI {
    private static final int EMPTY = Integer.MAX_VALUE;
    private static final int GATE = 0;
    private static final List<int[]> DIRECTIONS = Arrays.asList(
    new int[] {1, 0},
    new int[] {-1, 0},
    new int[] {0, 1}, 
    new int[] {0, -1});
    
    public void wallsAndGates(int[][] rooms){
        int m = rooms.length;
        
        if (m == 0){
            return;
        }
        
        int n = rooms[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        
        for (int row = 0; row < m; row++){
            for (int col = 0; col < n; col++){
                if (rooms[row][col] == GATE) {
                    q.add(new int[] {row, col});
                }
            }
        }
        
        while (!q.isEmpty()){
            int[] point = q.poll();
            int row = point[0];
            int col = point[1];
            for (int[] direction : DIRECTIONS){
                int r = row + direction[0];
                int c = col + direction[1];
                
                if(r < 0 || c < 0 || r >= m || c >= n || rooms[r][c] != EMPTY) {
                    continue;
                }
                
                rooms[r][c] = rooms[row][col] + 1;
                q.add(new int[] {r,c});
            }
        }
    }
}
