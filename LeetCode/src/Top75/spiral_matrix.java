package Top75;

import java.util.ArrayList;
import java.util.List;

/*
 * Problem statement - Given an m x n matrix, 
 * return all elements of the matrix in spiral order.
 */

public class spiral_matrix {
	
	 public List<Integer> spiralOrder(int[][] matrix) {
	        
	        //Approach 1: Set Up Boundaries
		 	//time complexity: O(M*N); space complexity: O(1)
	        List<Integer> result = new ArrayList<>();
	        
	        int rows = matrix.length;
	        int columns = matrix[0].length;
	        
	        int up = 0;
	        int left = 0;
	        int right = columns - 1;
	        int down = rows - 1;
	        
	        while(result.size() < rows * columns){
	            // Traverse from left to right.
	            for (int col = left; col <= right; col++) {
	                result.add(matrix[up][col]);
	            }
	            
	            //Traverse downwards
	            for(int row = up + 1; row <= down; row++){
	                result.add(matrix[row][right]);
	            }
	            
	            // Make sure we are now on a different row.
	            if (up != down) {
	                // Traverse from right to left.
	                for (int col = right - 1; col >= left; col--){
	                    result.add(matrix[down][col]);
	                }
	            }
	            
	            // Make sure we are now on a different column.
	            if (left != right){
	                // Traverse upwards.
	                for (int row = down - 1; row > up; row--){
	                    result.add(matrix[row][left]);
	                }
	            }
	            
	            left++;
	            right--;
	            up++;
	            down--;
	        }
	        
	        return result;
	        
	    }
	 
	 public List<Integer> spiralOrder1(int[][] matrix) {
	        
	        //Approach 2: mark as visited
		//time complexity: O(M*N); space complexity: O(1) if we allow mutation in the 
		 //original matrix to mark visited else it would be O(M*N) as we would need another
		 //boolean matrix to mark visited
	        int VISITED = 101;
	        int rows = matrix.length;
	        int columns = matrix[0].length;
	        // Four directions that we will move: right, down, left, up.
	        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	        
	        // Initial direction: moving right.
	        int currentDirection = 0;
	        
	        // The number of times we change the direction.
	        int changeDirection = 0;
	        
	        // Current place that we are at is (row, col).
	        // row is the row index; col is the column index.
	        int row = 0;
	        int col = 0;
	        
	        // Store the first element and mark it as visited.
	        List<Integer> result = new ArrayList<>();
	        result.add(matrix[0][0]);
	        matrix[0][0] = VISITED;
	        
	        while (changeDirection < 2){
	            while (row + directions[currentDirection][0] >= 0 &&
	                   row + directions[currentDirection][0] < rows &&
	                   col + directions[currentDirection][1] >= 0 &&
	                   col + directions[currentDirection][1] < columns &&
	                   matrix[row + directions[currentDirection][0]]
	                   [col + directions[currentDirection][1]] != VISITED){
	                // Reset this to 0 since we did not break and change the direction.
	                changeDirection = 0;
	                
	                // Calculate the next place that we will move to.
	                row = row + directions[currentDirection][0];
	                col = col + directions[currentDirection][1];
	                result.add(matrix[row][col]);
	                matrix[row][col] = VISITED;
	            }
	            
	            // Change our direction.
	            currentDirection = (currentDirection + 1) % 4;
	            // Increment change_direction because we changed our direction.
	            changeDirection++;
	        }
	        
	        return result;
	        
	    }

}
