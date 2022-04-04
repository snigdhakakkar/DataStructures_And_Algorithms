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
		
	}

}
