package DynamicProgrammingProblems;

public class MaxPiecesRetrievedAfterCuttingAGivenLengthPiece {
	
	//max number of pieces = max(include, exclude)
	// max number of pieces = max(1 + dp[i][j - pieces[i]], dp[i - 1][j]) , here, repetition is allowed
	
	//time complexity: O(no. of pieces * piece length l)
	//space complexity = O(no. of pieces *l)
	public static void main(String[] args) {
		
		MaxPiecesRetrievedAfterCuttingAGivenLengthPiece a = new MaxPiecesRetrievedAfterCuttingAGivenLengthPiece();
		
		int l = 7; //piece length given
		
		int[] pieces = {4, 2, 3, 5};
		
		System.out.println(a.maxPiecesCountForGivenPieceLength(l, pieces));
	}
	
	public int maxPiecesCountForGivenPieceLength(int l, int[] pieces) {
		
		if(pieces.length == 0 || l <= 0) {
			return 0;
		}
		
		int numberOfPieces = pieces.length;
		
		int[][] dp = new int[numberOfPieces][l + 1];
		
		for(int i = 0; i < numberOfPieces; i++) {
			for(int j = 0; j <= l; j++) {
				dp[i][j] = -1;
			}
		}
		
		for(int i = 0; i < numberOfPieces; i++) {
			dp[i][0] = 0;
		}
		
		for(int i = 0; i < numberOfPieces; i++) {
			for(int j = 1; j <= l; j++) {
				
				int includingCurrentPiece = -1;
				int excludingCurrentPiece = -1;
				
				if(pieces[i] <= j && dp[i][j - pieces[i]] != -1) {
					includingCurrentPiece = 1 + dp[i][j - pieces[i]];
				}
				
				if(i > 0) {
					excludingCurrentPiece = dp[i - 1][j];
				}
				
				dp[i][j] = Math.max(includingCurrentPiece, excludingCurrentPiece);
			}
		}
		
		return dp[numberOfPieces - 1][l];
	}

}
