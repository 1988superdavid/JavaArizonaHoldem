//By Wei Dai
// This is  a enum class of rank, which consists of all thirteen ranks of poker

enum Rank {
	Deuce(2), Three(3), Four(4), Five(5), Six(6), Seven(7), Eight(8), Nine(9), Ten(
			10), Jack(11), Queen(12), King(13), Ace(14);

	public int getValue() {
		return value;
	}

	private int value;

	Rank(int val) {
		value = val;
	}
}
