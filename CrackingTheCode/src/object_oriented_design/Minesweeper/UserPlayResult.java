package object_oriented_design.Minesweeper;

public class UserPlayResult {
	
	private boolean successful;
	private Game.GameState resultingState;
	
	
	public UserPlayResult(boolean success, Game.GameState state) {
		successful = success;
		resultingState = state;
	}
	
	public boolean successfulMove() {
		return successful;
	}
	
	public Game.GameState getResultingState() {
		return resultingState;
	}

}
