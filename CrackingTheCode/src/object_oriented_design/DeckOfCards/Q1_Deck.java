package object_oriented_design.DeckOfCards;

import java.util.ArrayList;


public class Q1_Deck<T extends Q1_Card> {
	
	private ArrayList<T> cards;
	private int dealtIndex = 0; // marks first undealt card
	
	public Q1_Deck() {
	}
	
	public void setDeckOfCards(ArrayList<T> deckOfCards) {
		cards = deckOfCards;
	}
	
	public void shuffle() {
		for (int i = 0; i < cards.size(); i++) {
			int j = randomIntInRange(i, cards.size() - i - 1);
			T card1 = cards.get(i);
			T card2 = cards.get(j);
			cards.set(i, card2);
			cards.set(j, card1);
		}
	}
	
	public int remainingCards() {
		return cards.size() - dealtIndex;
	}
	
	public T[] dealHand(int number) {
		if (remainingCards() < number) {
			return null;
		}
		
		T[] hand = (T[]) new Q1_Card[number];
		int count = 0;
		while (count < number) {
			T card = dealCard();
			if (card != null) {
				hand[count] = card;
				count++;
			}
		}
		
		return hand;
	}
	
	public T dealCard() {
		if (remainingCards() == 0) {
			return null;
		}
		
		T card = cards.get(dealtIndex);
		card.markUnavailable();
		dealtIndex++;
		
		return card;		
	}
	
	public void print() {
		for (Q1_Card card : cards) {
			card.print();   
		}
	}
	
	
	public static int randomInt(int n) {
		return (int) (Math.random() * n);
	}

	public static int randomIntInRange(int min, int max) {
		return randomInt(max + 1 - min) + min;
	}

}
