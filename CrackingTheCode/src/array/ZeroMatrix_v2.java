package array;
import java.util.Random;

public class ZeroMatrix_v2 {
	/*reduce the space complexity from O(N) to O(1) by using first row and 
	 * first column of the matrix to store the location of zero elements in the matrix 
	 * for nullifying in place of using two separate boolean arrays
	 */
	
	public static void setZeroes(int[][] matrix) {
		boolean rowHasZero = false;
		boolean columnHasZero = false;
		
	//validate if first row has zero
		for (int j = 0; j < matrix[0].length; j++) {
			
			if(matrix[0][j] == 0) {
				rowHasZero = true;
				break;
			}
		}
		
	//validate if first column has zero
		for (int i = 0; i < matrix.length; i++) {
			
			if (matrix[i][0] == 0) {
				columnHasZero = true;
				break;
			}
		}
		
	//check for zeroes in the rest of the matrix
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		
	//Nullify rows based on the values in the first column
		for (int i = 1; i < matrix.length; i++) {
			
			if (matrix[i][0] == 0) {
				nullifyRow(matrix, i);
			}
		}
		
	//Nullify column based on the values in the first row
		for (int j = 1; j < matrix[0].length; j++) {
			
			if (matrix[0][j] == 0) {
				nullifyColumn(matrix,j);
			}
		}
		
	//Nullify first row
		if (rowHasZero) {
			nullifyRow(matrix,0);
		}    
		
	//Nullify first column
		if (columnHasZero) {
			nullifyColumn(matrix,0);
		}
	}
	
	public static void nullifyRow(int[][] matrix, int row) {
		for (int j = 0; j < matrix[0].length; j++) {
			matrix[row][j] = 0;
		}
	}
	
	public static void nullifyColumn(int[][] matrix, int column) {
		for (int i = 0; i < matrix.length; i++) {
			matrix[i][column] = 0;
		}
	}
	
	public static int[][] randomMatrix(int nRows, int nColumns) {
		Random r = new Random();
		int[][] matrix = new int[nRows][nColumns];
		for(int i = 0; i < nRows; i++) {
			for (int j = 0; j < nColumns; j++) {
				matrix[i][j] = r.nextInt(20);
			}
		}
		return matrix;
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
		int nRows = 10;
		int nColumns = 15;	
		int[][] matrix = randomMatrix(nRows, nColumns);
		printMatrix(matrix);
		setZeroes(matrix);
		System.out.println();
		printMatrix(matrix);
	}

}
