package object_oriented_design;

public class Q2_Respondent extends Q2_Employee{
	
	public Q2_Respondent(Q2_CallHandler callHandler) {
    	super(callHandler);
    	rank = Q2_Rank.Q2_Responder;
    }
}
