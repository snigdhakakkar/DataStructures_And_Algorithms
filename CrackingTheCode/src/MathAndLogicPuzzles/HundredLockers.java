package MathAndLogicPuzzles;

public class HundredLockers {
	
	/*
	 * What does it mean for the door to be toggled?
	 * A door n is toggled once for each factor of n, including itself and 1. That, is door 15 is toggled for rounds 1, 3, 5, 15
	 * 
	 * When would the door be left open?
	 * A door is left open when the number of factors is odd as we would need pairs to do open and close actions. If there is one remaining, the door would be open.
	 * 
	 * When would x be odd?
	 * It would be odd when x is a perfect square. We can check it if we pair n's factors by their complements. 
	 * For example, if n is 36, the factors are: (1,36), (2,18), (3,12), (4,9), (6,6). Here (6,6) contributes to only one factor, thus giving odd factors.
	 * 
	 * How many perfect squares are there?
	 * 10 perfect squares until n = 100; therefore 10 lockers would be open at the end of the process.
	 */

}
