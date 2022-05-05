package object_oriented_design.CallCenter;

public enum Q2_Rank {
	
	Q2_Responder (0),
	Q2_Manager (1),
	Q2_Director (2);
	
	private int value;
	
	private Q2_Rank(int v) {
		value = v;
	}
	
	public int getValue() {
		return value;
	}

}
