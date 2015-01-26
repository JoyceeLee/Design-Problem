package Deck;

public enum Suit {
	Club(0), Diamond(1), Heart(2), Sprade(3);
	private int value;
	
	private Suit(int v) {
		this.value = v;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public static Suit getSuitFromValue(int v) {
		for(Suit suit : Suit.values()) {
			if(suit.value == v) {
				return suit;
			}
		}
		return null;
	}
}