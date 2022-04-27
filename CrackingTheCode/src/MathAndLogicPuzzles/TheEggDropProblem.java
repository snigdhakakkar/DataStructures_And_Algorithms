package MathAndLogicPuzzles;

/*
 * First observation: Regardless of how we drop egg1, egg 2 must do a linear search b/w lowest and highest i.e. the "breaking floor" and the next highest non-breaking floor.
 * For example if egg1 is dropped from floors 5 and 10 without breaking but it breaks when dropped from floor 15, then egg2 must be dropped, in the worst case from floors 11, 12, 13, 14.
 * 
 * Approach:
 * As a first try, let us suppose, we drop egg1 from the 10th floor, then the 20th floor..
 * if egg1 breaks on the first drop(floor 10), then we have at most 10 drops in total for egg2 to check.
 * if egg1 breaks on the last drop(floor 100), then we have at most 19 drops in total for egg2 to check.(floors 10, 20, 30....90, 91,92, 93...99)
 * That is good but we are still considering worst case scenarios only for egg2.
 * We should do some load balancing to make the above two cases even.
 * 
 * Our goal is to create a system for dropping egg1 such that the number of drops is as consistent as possible.
 * even if egg1 breaks on floor1 or floor 100 i.e. Drops(Egg1) + Drops(Egg2) is always the same, regardless of where egg1 breaks
 * For that to be the case, since each drop of egg1 takes one additional step, egg should be allowed one fewer step
 * We must thus reduce the number of steps potentially required by egg2 by one drop each time as drops for egg1 increases by 1 each time.
 * For example, if egg1 is dropped on floor 20, and then floor 30, egg 2 is potentially required to take 9 steps. Whe we drop egg1 again, we must reduce potential egg2 steps by 1.
 * That is we must drop egg1 at floor 39 instead of 40 next.
 * Therefore, egg1 must start at floor X, then go up by X-1 floors, then X-2 floors...
 * Solve for X : X + X - 1 + X - 2 + .... + 1 = 100 => X(X + 1)/2 = 100 => X ~ 13.65 
 * 
 * iF WE ROUND UP x to 14, then we would go up by 14, 13, 12 and so on. The last increment would be 4, which would happen on floor 99. 
 * If egg1 breaks before floor 99, then it is already load balanced, and if it does not break until floor 99
 * we just need one more drop of egg2 to check.
 * Either way, the number of drops is no more than 14.
 * 
 * On the other hand, if we round up to 13, then the last increment will be 1 which will happen at floor 91.
 * This is after 13 drops. Floors 92 to 100 have not been covered yet. We cannot cover these in just one drop.
 * Therefore, we should round up to 14 here.
 * 
 */

public class TheEggDropProblem {
	
	public static int breakingPoint = 89;
	public static int countDrops = 0;


	public static boolean willBreak(int floor) {
		countDrops++;
		return floor >= breakingPoint;
	}


	public static int findBreakingPoint(int floors) {
		int interval = 14;
		int previousFloor = 0;
		int egg1 = interval;
		
		/* Drop egg1 at decreasing intervals. */
		while (!willBreak(egg1) && egg1 <= floors) {
			interval -= 1;
			previousFloor = egg1;
			egg1 += interval;
		}
		
		/* Drop egg2 at 1 unit increments. */
		int egg2 = previousFloor + 1;
		while (egg2 < egg1 && egg2 <= floors && !willBreak(egg2)) {
			egg2 += 1;
		}
		
		/* If it didn’t break, return -1. */
		return egg2 > floors ? -1 : egg2;
	}


	public static void main(String[] args) {
		int max = 0;
		for (int i = 1; i <= 100; i++) {
			countDrops = 0;
			breakingPoint = i;
			int bp = findBreakingPoint(100);
			
			if (bp == breakingPoint) {
				System.out.println("SUCCESS: " + i + " -> " + bp + " -> " + countDrops);
			} else {
				System.out.println("ERROR: " + i + " -> " + bp + " vs " + breakingPoint);
				break;
			}
			max = countDrops > max ? countDrops : max;
		}
		System.out.println(max);
	}

}
