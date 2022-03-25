package DynamicProgrammingProblems;

public class RodCuttingProblem {
	//max profit = max(including, excluding)
	//max profit = max(pf[i] + arr[i][j - pieces[i]], arr[i - 1][j])
	
	//time complexity: O(no. of pieces * length of the rod)
	
	//space complexity: O(no. of pieces * length of the rod)
	
	public static void main(String[] args) {
		
		RodCuttingProblem a = new RodCuttingProblem();
		
		int[] rp = {1, 2, 3, 4, 5}; // number of pieces in which rod is cut
		int[] pf = {3, 5, 10, 11, 15}; //profit associated for number of pieces
		
		int l = 5; //length of the rod
		
		System.out.println(a.getNoOfPiecesForMaxProfitWithGivenRodLength(rp, pf, l));
	}
	
	public int getNoOfPiecesForMaxProfitWithGivenRodLength(int[] rp, int[] pf, int l) {
		
		if(rp.length == 0 || pf.length == 0 || l <= 0) {
			return 0;
		}
		
		int numberOfPieces = rp.length;
		
		int[][] arr = new int[numberOfPieces][l + 1];
		
		for(int i = 0; i < numberOfPieces; i++) {
			for(int j = 1; j <= l; j++) {
				
				int includingCurrentPieceProfit = 0;
				int excludingCurrentPieceProfit = 0;
				
				if(rp[i] <= j) {
					includingCurrentPieceProfit = pf[i] + arr[i][j - rp[i]];
				}
				
				if(i > 0) {
					excludingCurrentPieceProfit = arr[i - 1][j];
				}
				
				arr[i][j] =  Math.max(includingCurrentPieceProfit, excludingCurrentPieceProfit);
			}
		}
		
		return arr[numberOfPieces - 1][l];
	}

}
