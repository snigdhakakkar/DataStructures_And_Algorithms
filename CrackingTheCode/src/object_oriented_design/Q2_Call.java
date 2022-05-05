package object_oriented_design;

/* Represents a call from a user. Calls have a minimum rank and are assigned to the
 * first employee who can handle that call.
 */

public class Q2_Call {
	
	/* Minimal rank of employee who can handle this call. */
	private Q2_Rank rank;

	/* Person who is calling. */
	private Q2_Caller caller;

	/* Employee who is handling call. */
	private Q2_Employee handler;

	public Q2_Call(Q2_Caller c) {
		rank = Q2_Rank.Q2_Responder;
		caller = c;
	}

	/* Set employee who is handling call. */
	public void setHandler(Q2_Employee e) {
		handler = e;
	}

	/* Play recorded message to the customer. */
	public void reply(String message) {
		System.out.println(message);
	}

	public Q2_Rank getRank() {
		return rank;
	}

	public void setRank(Q2_Rank r) {
		rank = r;
	}

	public Q2_Rank incrementRank() {
		if (rank == Q2_Rank.Q2_Responder) {
			rank = Q2_Rank.Q2_Manager;
		} else if (rank == Q2_Rank.Q2_Manager) {
			rank = Q2_Rank.Q2_Director;
		}
		return rank;
	}

	/* Disconnect call. */
	public void disconnect() {
		reply("Thank you for calling");
	}

}
