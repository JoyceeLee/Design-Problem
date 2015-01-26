package Deck.BlackJack;

import Deck.Card;
import Deck.Suit;

public class BlackJackCard extends Card {

	public BlackJackCard(int v, Suit s) {
		super(v, s);
	}
	
	@Override
	public int value() {
		if(isAce()) return 1;
		else if (faceValue >= 11 && faceValue <= 13) return 10;
		else return faceValue;
	}
	
	public boolean isAce() {
		return this.faceValue==1;
	}
	
	public int minValue() {
		if(isAce()) return 1;
		else return faceValue;
	}
	
	public int maxValue() {
		if(isAce()) return 11;
		else return faceValue;
	}
	
	public boolean isFaceCard() {
		return faceValue>=11 && faceValue<=13;
	}
}
