package object_oriented_design;

public class Q1_BlackJackCard extends Q1_Card {
	
	public Q1_BlackJackCard(int c, Q1_Suit s) {
		super(c, s);
	}
	
	public int value() {
		if (isAce()) { // Ace
			return 1; 
		} else if (isFaceCard()) { // Face card
			return 10;
		} else { // Number card
			return faceValue;
		}
	}
	
	public int minValue() {
		if (isAce()) { // Ace
			return 1;    
		} else {
			return value();
		}
	}
	
	public int maxValue() {
		if (isAce()) { // Ace
			return 11; 
		} else {
			return value();
		}
	}
	
	public boolean isAce() { 
		return faceValue == 1;
	} 
	
	public boolean isFaceCard() {
		return faceValue >= 11 && faceValue <= 13;
	}

}
