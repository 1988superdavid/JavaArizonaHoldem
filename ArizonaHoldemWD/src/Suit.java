//By Wei Dai
//This is a enum class contains four types of suit of poker

enum Suit {
	Diamonds('d'), Clubs('c'), Hearts('h'), Spades('s');
	public char getSuit() {
		return SuitValue;
	}

	private char SuitValue;

	Suit(char val) {
		SuitValue = val;
	}
}
