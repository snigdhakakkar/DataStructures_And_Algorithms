package recursion_and_dynamic_programming.Robot_in_a_grid;

/*
 * At first, time complexity appears to be at most O(2^(r+c))
 * But, we can find a tighter bound.
 * imagine we labelled our paths with steps 1,2,3....n where n = r+ c
 * our subset is formed when we pick r of those numbers to be our along-row moves.
 * this reduces our runtime to O((r+c)!/r!c!)
 * 
 */
import java.util.ArrayList;

public class recursive_approach {
	
	public static ArrayList<point> getPath(boolean[][] maze) {
		if (maze == null || maze.length == 0) return null;
		ArrayList<point> path = new ArrayList<point>();
		if (getPath(maze, maze.length - 1, maze[0].length - 1, path)) {
			return path;
		}
		return null;
	}	
	
	public static boolean getPath(boolean[][] maze, int row, int col, ArrayList<point> path) {
		// If out of bounds or not available, return.
		if (col < 0 || row < 0 || !maze[row][col]) {
			return false;
		}
		
		boolean isAtOrigin = (row == 0) && (col == 0);
		
		// If there's a path from the start to my current location, add my location.
		if (isAtOrigin || getPath(maze, row, col - 1, path) || getPath(maze, row - 1, col, path)) { 
			point p = new point(row, col);
			path.add(p);
			return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		int size = 5;
		boolean[][] maze = randomBooleanMatrix(size, size, 70);
		
		printMatrix(maze);
		
		ArrayList<point> path = getPath(maze);
		if (path != null) {
			System.out.println(path.toString());
		} else {
			System.out.println("No path found.");
		}
	}
	
	public static int randomInt(int n) {
		return (int) (Math.random() * n);
	}

	public static int randomIntInRange(int min, int max) {
		return randomInt(max + 1 - min) + min;
	}

	public static boolean randomBoolean() {
		return randomIntInRange(0, 1) == 0;
	}

	public static boolean randomBoolean(int percentTrue) {
		return randomIntInRange(1, 100) <= percentTrue;
	}
	
	public static boolean[][] randomBooleanMatrix(int M, int N, int percentTrue) {
		boolean[][] matrix = new boolean[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] = randomBoolean(percentTrue);
			}
		}
		return matrix;
	}	
	
	public static void printMatrix(boolean[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j]) {
					System.out.print("1");
				} else {
					System.out.print("0");
				}
			}
			System.out.println();
		}
	}

}
