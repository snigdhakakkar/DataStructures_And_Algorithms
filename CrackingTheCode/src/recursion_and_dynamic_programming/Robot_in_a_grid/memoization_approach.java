package recursion_and_dynamic_programming.Robot_in_a_grid;

//time complexity: O(rc)

import java.util.ArrayList;
import java.util.HashSet;

public class memoization_approach {
	
	public static ArrayList<point> getPath(boolean[][] maze) {
		if (maze == null || maze.length == 0) return null;
		ArrayList<point> path = new ArrayList<point>();
		HashSet<point> failedPoints = new HashSet<point>();
		if (getPath(maze, maze.length - 1, maze[0].length - 1, path, failedPoints)) {
			return path;
		}
		return null;
	}
	
	public static boolean getPath(boolean[][] maze, int row, int col, ArrayList<point> path, HashSet<point> failedPoints) {
		/* If out of bounds or not available, return.*/
		if (col < 0 || row < 0 || !maze[row][col]) {
			return false;
		}
		
		point p = new point(row, col);
		
		/* If we've already visited this cell, return. */
		if (failedPoints.contains(p)) { 
			return false;
		}	
		
		boolean isAtOrigin = (row == 0) && (col == 0);
		
		/* If there's a path from the start to my current location, add my location.*/
		if (isAtOrigin || getPath(maze, row, col - 1, path, failedPoints) || getPath(maze, row - 1, col, path, failedPoints)) {
			path.add(p);
			return true;
		}
		
		failedPoints.add(p); // Cache result
		return false;
	}
	
	public static void main(String[] args) {
		int size = 20;
		boolean[][] maze = randomBooleanMatrix(size, size, 60);
		
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
