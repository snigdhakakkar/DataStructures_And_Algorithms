package object_oriented_design;

import java.util.ArrayList;

public class Q1_Hand<T extends Q1_Card> {
	
	protected ArrayList<T> cards = new ArrayList<T>();
	
	public int score() {
		int score = 0;
		for (T card : cards) {
			score += card.value();
		}
		return score;
	}
	
	public void addCard(T card) {
		cards.add(card);
	}	
	
	public void print() {
		for (Q1_Card card : cards) {
			card.print();
		}
	}	
   
}
