package Top75;

/*
 * Problem statement - You are given an n x n 2D matrix representing an image, 
 * rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the 
input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 */

public class rotate_image {
	
	//Approach 1: Rotate Groups of Four Cells
	//time complexity: O(M)  where M is the number of cells in the matrix
	//space complexity: O(1)
	public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; i++){
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
                matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 -i];
                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
	
	//Approach 2: Reverse on Diagonal and then Reverse Left to Right
	public void rotateI(int[][] matrix) {
        transpose(matrix);
       reflect(matrix);
   }
   
   public void transpose(int[][] matrix) {
       int n = matrix.length;
       for (int i = 0; i < n; i++){
           for (int j = i+1; j < n; j++){
               int tmp = matrix[j][i];
               matrix[j][i] = matrix[i][j];
               matrix[i][j] = tmp;
           }
       }
   }
   
   public void reflect(int[][] matrix){
       int n = matrix.length;
       for (int i = 0; i < n; i++){
           for (int j = 0; j < n / 2; j++) {
               int tmp = matrix[i][j];
               matrix[i][j] = matrix[i][n - j - 1];
               matrix[i][n - j - 1] = tmp;
           }
       }
   }

}
