package Deck;

import java.util.ArrayList;


public class Deck<T extends Card> {
	
	private ArrayList<T> cards; 
	
	private int dealtIdx = 0;
	
	public void setDeckOfCards(ArrayList<T> deckOfCards) {
		cards = deckOfCards;
	}
	
	public void shuffle() {
		for(int i=cards.size()-1; i>0; i--) {
			int rand = (int)(Math.random()*(i));
			T tmp = cards.get(rand);
			cards.set(rand, cards.get(i));
			cards.set(i, tmp);
		}
		dealtIdx = 0;
	}
	
	public int remainCards(){
		return cards.size()-dealtIdx;
	}
	
	public T dealCard() {
		if(dealtIdx==cards.size()) 
			shuffle();
		return cards.get(dealtIdx++);
	}
}
