package array;

public class RotateMatrix {
	
	public static boolean rotate(int[][] matrix) {
		
		if (matrix.length == 0 || matrix.length != matrix[0].length) {
			return false;
		}
		   
		int n = matrix.length;
		
		for (int i = 0; i < n/2; i++) {
			    
			for (int j = i; j < n - 1 - i; j++) {
				
				int top = matrix[i][j]; //saving top
				
				//left --> top
				matrix[i][j] = matrix[n - 1 - j][i];
				
				//bottom --> left
				matrix[n - 1 - j][i] = matrix[n - i - 1][n - 1 - j];
				
				//right --> bottom
				matrix[n - i - 1][n - 1 - j] = matrix[j][n - i - 1];
				
				//top --> right
				matrix[j][n - i - 1] = top; //right <- saved top	
				      
			}
		}
		
		return true;
	}
	
	public static void printMatrix(int[][] matrix) {
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			
			System.out.println();
		}
		
	}
	
	public static void main (String[] args) {
		int[][] matrix = {
				{3,3,0,9},
				{3,0,3,9},
				{0,3,3,9},
				{9,3,3,0}
		};
		
		printMatrix(matrix);
		
		rotate(matrix);
		System.out.println();
		
		printMatrix(matrix);
		
		
	}
	
	//time complexity : O(N^2)

}
