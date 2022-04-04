package BackTrackingProblems;

public class NQueensProblem {
	
	final int N;
	
	NQueensProblem(int N){
		this.N = N;
	}
	
	
	//we are given number N
	//we have to place these N queens in NXN matrix
	//First condition: single queen in one row
	//Second condition: single queen in one column
	//Third condition: single queen in diagonal
	
	public static void main(String[] args) {
		int n = 4; //queencount
		NQueensProblem prob = new NQueensProblem(n);
		prob.queenProblem();
	}
	
	public boolean queenProblem() {
		int[][] sol = new int[N][N];
		
		if(!queenProblemUtil(0, sol)) {
			System.out.println("N Queen placement not possible");
			return false;
		}
		
		printQueenPlacement(sol);
		return true;
	}
	
	private boolean queenProblemUtil(int col, int[][] sol) {
		
		if(col >= N) {
			return true;
		}
		
		for(int i = 0; i < N; i++) {
			
			if(isSafeToPlaceQueen(i, col, sol)) {
				sol[i][col] = 1;
				
				if(queenProblemUtil(col + 1, sol)) {
					return true;
				}
				
				sol[i][col] = 0;
				
			}
			
		}
		return false;
		
	}
	
	private boolean isSafeToPlaceQueen(int row, int col, int[][] sol) {
		int i, j;
		
		for(i = 0; i < col; i++) {
			if(sol[row][i] == 1) {
				return false;
			}
		}
		
		for(i = row, j = col; i >= 0 && j >= 0 ; i--, j--) {
			if(sol[i][j] == 1) {
				return false;
			}
		}
		
		for(i = row, j = col; i < N && j >= 0; i++, j--) {
			if(sol[i][j] == 1) {
				return false;
			}
		}
		
		return true;
	}

}
