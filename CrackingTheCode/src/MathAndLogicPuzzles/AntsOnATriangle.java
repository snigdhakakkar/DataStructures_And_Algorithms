package MathAndLogicPuzzles;

public class AntsOnATriangle {
	
	/*
	 * Ants need to move in the same direction - either clockwise or counter-clockwise to avoid collision. They would collide if they choose to walk towards each other.
	 * P(clockwise) = (1/2)^3 as each ant would have two choices. Similarly, P(Counter-clockwise) = (1/2)^3
	 * Thus, P(samedirection) = 2 * (1/2)^3
	 * P(collision) = 1 - 2 * (1/2)^3 = 3/4
	 * 
	 * Now, we can generalize this for n-vertex polynomial
	 * P(clockwise) = (1/2)^n
	 * P(counter-clockwise) = (1/2)^n
	 * P(samedirection) = 2 * (1/2)^n
	 * P(collision) = 1 - (1/2)^(n -1)
	 */

}
