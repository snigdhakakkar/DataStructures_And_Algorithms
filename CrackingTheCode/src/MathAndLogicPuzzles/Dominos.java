package MathAndLogicPuzzles;

public class Dominos {
	
	/*
	 * At first it seems like this should be possible. It is an 8X8 board and has 64 squares, but two opposite ends have been cutoff, so we are down to 62 squares.
	 * A set of 31 dominoes should be enough to fit there?
	 * But when we try to lay the dominoes in row 1, that has only 7 squares, we see that one domino stretches into row 2.
	 * Then, we try to lay down dominoes into row 2, and same thing happens. We need to stretch a domino into row 3.
	 * For each row we place, we will have one domino that will poke into next row. Nomatter how we try we will not be able to lay down all domioes.
	 * This is due to the fact below:
	 * In a chessboard we have 32 blacks and 32 whites. Now, when two opposite ends are cut off, we might have 30 black boxes and 32 whites.
	 * Each domino we set up on the board will take up one black and one white box each. 
	 * So, 31 dominoes will take up exactly 31 back and 31 white squares. But we just have 30 black and 32 white squares.
	 * Hence, it is impossible.
	 */

}
