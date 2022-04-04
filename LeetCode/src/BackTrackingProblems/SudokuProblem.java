package BackTrackingProblems;

public class SudokuProblem {
	
	//Sudoku can be of 4X4 or 9X9 or 16X16 size
	//In a particular row or column there should not be a duplicate element
	//In this box, there should not be any duplicate element
	//whenever we are filling values, we need to fulfill these conditions
	//Value can range from 1 to N where N could be 4, 9 or 16
	
	
	public static void main(String[] args) {
		
		SudokuProblem a = new SudokuProblem();
		
		int[][] board = new int[][] {{0, 2, 3, 0},
			{0, 0, 0, 1}, 
			{0, 1, 0, 0},
			{2, 4, 1, 0}};
			
		int N = board.length;
		
		if(a.sudokuAutomation(board, N)) {
			a.printSudokuBoard(board, N);
		} else {
			System.out.println("No solution exists");
		}
	}
	
	public boolean sudokuAutomation(int[][] board, int N) {
		int row = -1;
		int col = -1;
		
		boolean isEmpty = true;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(board[i][j] == 0) {
					row = i;
					col = j;
					
					isEmpty = false;
					break;
				}
			}
			if(!isEmpty) {
				return true;
			}
		}
		
		for(int num = 1; num <= N; num++) {
			if(isSafeToPlace(board, row, col, num)) {
				board[row][col] = num;
				if(sudokuAutomation(board, n)) {
					return true;
				} else {
					board[row][col] = 0;
				}
			}
		}
		return false;
	}
	
	public boolean isSafeToPlace(int[][] board, int row, int col, int num) {
		
	}
	
	public void printSudokuBoard(int[][] board, int N) {
		
	}

}
