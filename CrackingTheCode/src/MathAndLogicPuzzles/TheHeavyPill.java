package MathAndLogicPuzzles;

public class TheHeavyPill {
	
	/* we just have one time to use the scale, so we cannot skip measuring one or two bottles. 
	 * we need to take pills from all the bottles, but then how would we distinguish which pill measures more.
	 * Suppose, we just had 2 bottles, and we took1 pill from the first and 2 pills from the second, actual weight should be 3 grams taking that no pill is heavier than the other.
	 * Now, we know that one pill is heavier. If that pill is pill 1, we would see a weight of 3.1 grams and if it is from bottle 2, we would get a weight of 3.2 grams.
	 * And, we get our answer.
	 * This same rule we would apply for 20 bottles we have been provided with.
	 * So, the right weight should be (1 + 2 + 3 + 4.... +20) = 20*21/2 = 210 as we took 1 pill from bottle 1, 2 pills from bottle 2, 3 from bottle 3 and so on.
	 * Now, we would use this formula to find the bottle with heavier pills = weight seen - 210 grams / 0.1 grams.
	 * Suppose, the weight seen is 211.3 grams, then 211.3 - 210 / 0.1 = 13
	 * This implies bottle 13 would have heavy pills.
	 */

}
