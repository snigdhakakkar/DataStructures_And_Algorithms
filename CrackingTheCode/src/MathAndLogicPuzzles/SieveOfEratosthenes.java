package MathAndLogicPuzzles;

public class SieveOfEratosthenes {
	
	public static boolean[] sieveOfEratosthenes(int max) {
		boolean[] flags = new boolean[max + 1];
		int count = 0;
		
		init(flags); //set all flags to true other than 0 or 1
		int prime = 2;
		
		while(prime <= Math.sqrt(max)) {
			/*cross off the remaining multiples of prime*/
			crossOff(flags, prime);
			//find the next value which is true
			prime = getNextPrime(flags, prime);
		}
		
		return flags;
				
	}
	
	public static void crossOff(boolean[] flags, int prime) {
		/*cross off remaining multiples of prime. we can start with (prime*prime), because if we 
		 * have a k*prime, where k < prime, this value would have already been crossed off in a prior iteration.
		 */
		for(int i = prime*prime; i <flags.length; i+=prime) {
			flags[i] = false;
		}
	}
	
	public static int getNextPrime(boolean[] flags, int prime) {
		int next = prime + 1;
		while(next < flags.length && !flags[next]) {
			next++;
		}
		return next;
	}
	
	public static boolean[] init(boolean[] flags) {
		for(int i = 0; i < flags.length; i++) {
			if(i == 0 || i == 1) {
			flags[i] = false;
			} else {
			flags[i] = true;
			}
		}
		return flags;
	}
	
	public static void main(String[] args) {
		boolean[] primes = sieveOfEratosthenes(10);
		for (int i = 0; i < primes.length; i++) {
			if (primes[i]) {
				System.out.println(i);
			}
		}
	}
	

}
