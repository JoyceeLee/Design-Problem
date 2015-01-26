package Deck.BlackJack;

import java.util.ArrayList;
import java.util.Arrays;

import Deck.Card;
import Deck.Hand;
import Deck.Suit;

public class BlackJackHand<T extends BlackJackCard> extends Hand<T> {
	public BlackJackHand() {
		super();
	}
	public int score () {
		ArrayList<Integer> scores = possibleScores();
		int MAX_UNDER = Integer.MIN_VALUE;
		int MIN_OVER = Integer.MAX_VALUE;
		for(int score : scores) {
			if(score>21 && score<MIN_OVER) {
				MIN_OVER = score;
			} else if(score<=21 && score>MAX_UNDER) {
				MAX_UNDER = score;
			}
		}
		return MAX_UNDER == Integer.MIN_VALUE ? MIN_OVER : MAX_UNDER;
	}
	public ArrayList<Integer> possibleScores() {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		int[] sum = new int[]{0};
		for(int i=0; i<cards.size(); i++) {
			T card = cards.get(i);
			int minv = card.minValue();
			int maxv = card.maxValue();
			System.out.println(minv + " -- " + maxv);
			if(minv == maxv) {
				for(int j=0; j<sum.length; j++) {
					sum[j] += minv;
				}
			} else {
				int[] tmp = new int[sum.length*2];
				for(int j=0; j<sum.length; j++) {
					tmp[j] = sum[j] + minv;
					tmp[j+sum.length] = sum[j] + maxv;
				}
				sum = tmp;
			}
		}
		for(int a : sum) {
			System.out.print(a+", ");
			ret.add(a);
			System.out.print("\n");
		}
		return ret;
	}
}
