package array;

public class RotateMatrix {
	
	public static boolean rotate(int[][] matrix) {
		
		if (matrix.length == 0 || matrix.length != matrix[0].length) {
			return false;
		}
		
		int n = matrix.length;
		
		for (int layer = 0; layer < n/2; layer++) {
			int first = layer;
			int last = n - 1 - layer;
			
			for (int i = first; i < last; i++) {
				int offset = i - first;
				
				int top = matrix[first][i]; //saving top
				
				//left --> top
				matrix[first][i] = matrix[last - offset][first];
				
				//bottom --> left
				matrix[last - offset][first] = matrix[last][last - offset];
				
				//right --> bottom
				matrix[last][last - offset] = matrix[i][last];
				
				//top --> right
				matrix[i][last] = top; //right <- saved top	
				
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

}
