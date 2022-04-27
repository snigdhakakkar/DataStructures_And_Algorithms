package MathAndLogicPuzzles;

public class TheApocalypse {
	
	/*
	 * If each family abides by the new policy, then each family will have zero or more boys followed by a girl.
	 * That is, G; BG; BBG; BBBG; BBBBG; and so on
	 * Using probability of 50% of having a girl and 50% of a boy each time; P(G) = 1/2; P(BG) = 1/4; P(BBG) = 1/8; P(BBBG) = 1/16; P(BBBBG) = 1/32
	 * Now to get the number of boys on average in each family, we need to look at the expected value of number of boys which is calculated by multiplying the probability with number of boys
	 * Thus, for family with exactly one girl and 0 boys, expected value of number of boys = 0
	 * for family with exactly one girl and 1 boys, expected value of number of boys = 1*1/4 = 1/4
	 * for family with exactly one girl and 2 boys, expected value of number of boys = 2*1/8 = 1/4
	 * for family with exactly one girl and 3 boys, expected value of number of boys = 3*1/16 = 3/16
	 * for family with exactly one girl and 4 boys, expected value of number of boys = 4*1/32 = 1/8
	 * for family with exactly one girl and 5 boys, expected value of number of boys = 5*1/64 = 5/64
	 * 
	 * so, generalized formula would be summation of i/2^(i+1) over i = 0 to infinity
	 * 
	 * And, when we add all these numbers by converting them to the same denominator, we see that the sum is quite close to 1.
	 * 
	 * Logically, if the earlier sum is 1, then the gender ratio is even, families contribute exactly one girl and one boy on average. The birth policy is therefore ineffective.
	 * 
	 * If we append all the family births in one string, the probability of next character being a B or G would be 50% each. Therefore, roughly half of the string would be G's and half B's
	 * This actually makes sense as biology has not changed with the rule coming in.
	 * There would be 50% boys and 50% girls on average
	 */

}
