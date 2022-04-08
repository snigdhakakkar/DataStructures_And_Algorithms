package array;

public class RotateMatrix_v1 {
	
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
	
	public static void printMatrix(int[][] matrix) {
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			
			System.out.println();
		}
		
	}
	
	public static boolean rotate(int[][] matrix) {
		
		if (matrix.length == 0 || matrix.length != matrix[0].length) {
			return false;
		}
		
		int n = matrix.length;
		
		//taking transpose of the matrix
		
		for(int i = 0; i < n; i++) {
			for(int j = i; j < n; j++) {
				if(i != j) {
					int temp = matrix[i][j];
					matrix[i][j] = matrix[j][i];
					matrix[j][i] = temp;
				}
			}
		}
		
		//swap the elements from column 1 with the last column 
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n/2; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][n - j - 1];
				matrix[i][n - j - 1] = temp;
			}
		}
		
		return true;
	}
	
	//time complexity: O(N^2)
	//space complexity: O(1)
}
