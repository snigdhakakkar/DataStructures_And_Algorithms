package object_oriented_design;

public class Q2_Director extends Q2_Employee{
	
	public Q2_Director(Q2_CallHandler callHandler) {
    	super(callHandler);
    	rank = Q2_Rank.Q2_Director;
    }

}
