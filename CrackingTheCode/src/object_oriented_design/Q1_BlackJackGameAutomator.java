package object_oriented_design;

import java.util.ArrayList;

public class Q1_BlackJackGameAutomator {
	
	private Q1_Deck<Q1_BlackJackCard> deck;
	private Q1_BlackJackHand[] hands;
	private static final int HIT_UNTIL = 16;
	
	public Q1_BlackJackGameAutomator(int numPlayers) {
		hands = new Q1_BlackJackHand[numPlayers];
		for (int i = 0; i < numPlayers; i++) {
			hands[i] = new Q1_BlackJackHand();
		}
	}
	
	public boolean dealInitial() {
		for (Q1_BlackJackHand hand : hands) {
			Q1_BlackJackCard card1 = deck.dealCard();
			Q1_BlackJackCard card2 = deck.dealCard();
			if (card1 == null || card2 == null) {
				return false;
			}
			hand.addCard(card1);
			hand.addCard(card2);	
		}
		return true;
	}
	
	public ArrayList<Integer> getBlackJacks() {
		ArrayList<Integer> winners = new ArrayList<Integer>();
		for (int i = 0; i < hands.length; i++) {
			if (hands[i].isBlackJack()) {
				winners.add(i);
			}
		}
		return winners;
	}
	
	public boolean playHand(int i) {
		Q1_BlackJackHand hand = hands[i];
		return playHand(hand);
	}
	
	public boolean playHand(Q1_BlackJackHand hand) {
		while (hand.score() < HIT_UNTIL) {
			Q1_BlackJackCard card = deck.dealCard();
			if (card == null) {
				return false;
			}
			hand.addCard(card);
		}
		return true;
	}	
	
	public boolean playAllHands() {
		for (Q1_BlackJackHand hand : hands) {
			if (!playHand(hand)) {
				return false;
			}
		}
		return true;
	}
	
	public ArrayList<Integer> getWinners() {
		ArrayList<Integer> winners = new ArrayList<Integer>();
		int winningScore = 0;
		for (int i = 0; i < hands.length; i++) {
			Q1_BlackJackHand hand = hands[i];
			if (!hand.busted()) {
				if (hand.score() > winningScore) {
					winningScore = hand.score();
					winners.clear();
					winners.add(i);
				} else if (hand.score() == winningScore) {
					winners.add(i);
				}
			}
		}
		return winners;
	}
	
	public void initializeDeck() {
		ArrayList<Q1_BlackJackCard> cards = new ArrayList<Q1_BlackJackCard>();
		for (int i = 1; i <= 13; i++) {
			for (int j = 0; j <= 3; j++) {
				Q1_Suit suit = Q1_Suit.getSuitFromValue(j);
				Q1_BlackJackCard card = new Q1_BlackJackCard(i, suit);
				cards.add(card);
			}
		}
		
		deck = new Q1_Deck<Q1_BlackJackCard>();
		deck.setDeckOfCards(cards);
		deck.shuffle();	
	}
	
	public void printHandsAndScore() {
		for (int i = 0; i < hands.length; i++) {
			System.out.print("Hand " + i + " (" + hands[i].score() + "): ");
			hands[i].print();
			System.out.println("");
		}
	}

}
