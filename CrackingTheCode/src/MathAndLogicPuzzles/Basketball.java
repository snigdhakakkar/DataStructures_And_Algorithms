package MathAndLogicPuzzles;

public class Basketball {
	
	/* The probability of winning a game is p as given in the question. Game 1: p
	 * For game 2: Let s(k,n) be the probability of making exactly k shots out of n. Probability of winning game 2 is the probability of making exactly 2 shots out of 3 shots or all 3 shots
	 * P(winning) = s(2,3) + s(3,3)
	 * s(3,3) = p^3
	 * s(2,3) = P(making 1 and 2, missing 3) + P(making 1 and 3, missing 2) + P(making 2 and 3, missing 1) = 3(1-p)p^2
	 * Adding the above two probabilities, P(game 2) = p^3 + 3(1-p)p^2 = 3p^2 - 2p^3
	 * To decide which game to play, game chosen probability should be higher
	 * P(Game 1) > P(Game 2) if we choose Game 1
	 * p > 3p^2 - 2P^3 => (2p - 1)(p - 1) > 0 so, both terms must be either positive or negative for choosing game 1, but we know p is always between 0 and 1
	 * thus, p - 1 < 0; hence 2p - 1 < 0 => p < 0.5
	 * So, we should play Game 1 if p < 0.5 and Game 2 if 0.5 < p < 1
	 * And, it does not matter which game we choose at p = 0, 0.5 or 1 as P(Game 1) = P(Game 2)
	 */

}
