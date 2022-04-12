package array;
import java.util.Random;

public class ZeroMatrix_v1 {
	
	public static void setZeroes(int[][] matrix) {
		boolean[] row = new boolean[matrix.length];
		boolean[] column = new boolean[matrix[0].length];
		
		//Store the row and column index with value 0
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				
				if (matrix[i][j] == 0 ) {
					row[i] = true;
					column[j] = true;
					
				}
			}
		}
		     
		//Nullify rows
		
		for (int i = 0; i < row.length; i++) {
			if (row[i]) {
				nullifyRow(matrix, i);
				}
		}
		
		//Nullify columns
		
		for (int j = 0; j < column.length; j++) {
			if (column[j]) {
				nullifyColumn(matrix, j);
				}
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
