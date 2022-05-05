package object_oriented_design.DeckOfCards;

public enum Q1_Suit {
	
	Club (0),
	Diamond (1),
	Heart(2),
	Spade(3);
	
	private int value;
	private Q1_Suit(int v) {
		value = v;
	}
	
	public int getValue() {
		return value;
	}
	
	public static Q1_Suit getSuitFromValue(int value) {
		switch (value) {
		case 0:     
			return Q1_Suit.Club;
		case 1:
			return Q1_Suit.Diamond;
		case 2:
			return Q1_Suit.Heart;
		case 3: 
			return Q1_Suit.Spade;
		default:
				return null;
		}
	}

}
