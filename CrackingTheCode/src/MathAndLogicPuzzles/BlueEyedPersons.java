package MathAndLogicPuzzles;

public class BlueEyedPersons {
	
	/*
	 * Let us apply the base case and build approach. Assume there were n people on the island out of which c people were blue eyed. We are explicitly told that c > 0
	 * Case c = 1: Exactly one person is blue eyed.
	 * Assumign that all the people are intelligent, the blue-eyed person should look around and see that no one has blue eyes. Since no one but at least one person has blue eyes,
	 * he must conclude that it is him who has blue eyes and must leave the island in the evening flight.
	 * 
	 * Case c = 2, Exactly 2 people have blue eyes
	 * The two blue-eyes persons would ee each other but would be unsure if c = 1 or 2.
	 * They know from the previous case that if c = 1, the blue eyed person would leave the island the same evening.
	 * Therefore, if the other blue-eyed person is there, he must deduce c= 2, which means that he himself has blue eyes.
	 * Both men would then leave on the flight on second night.
	 * 
	 * Case c>2: General case
	 * As we increase c, the same logic continues.
	 * If c = 3, those three people will immediately know that there are 2 or 3 people with ble eyes.
	 * When there were just 2 people, they would have left on the second night. 
	 * So, when the others are still around on the secodn night, each person would deduce that c=3 and he himself has blue eyes and will leave the island next evening
	 * This same pattern continues for any values of c. If c men have blue eyes, it will take c nights to leave the island.
	 */

}
