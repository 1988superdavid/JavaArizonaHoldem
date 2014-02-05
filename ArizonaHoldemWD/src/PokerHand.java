//By Wei Dai
//This PokerHand class consists five different cards, which represents a 
//hand of five of poker cards.
//Different five cards have different rankings. StraightFlush, Straight,
//Full house etc. The constructor will detect the ranking of this five cards
// and signed each pokerhand ranking type, which will be used to comparison
// with other pokerhand. 

public class PokerHand {
	private long handPower;
	Card FirstCard, SecondCard, ThrirdCard, FourthCard, FifthCard;
	public CardsType cardtype;
	// To store all rankings of five cards
	public int[] TempRankArray = new int[5];
	// To store all suits of five cards
	public char[] TempSuitArray = new char[5];
	// To store the features of poker hand cards, which is used for comparison
	public int[] CardsChars = new int[5];

	PokerHand(Card val1, Card val2, Card val3, Card val4, Card val5) {
		if (val1 == val2 || val1 == val3 || val1 == val4 || val1 == val5
				|| val2 == val3 || val2 == val4 || val2 == val5 || val3 == val4
				|| val3 == val5 || val4 == val5) {
			throw new DuplicateCardException();
		}
		FirstCard = val1;
		TempRankArray[0] = val1.rank.getValue();
		SecondCard = val2;
		TempRankArray[1] = val2.rank.getValue();
		ThrirdCard = val3;
		TempRankArray[2] = val3.rank.getValue();
		FourthCard = val4;
		TempRankArray[3] = val4.rank.getValue();
		FifthCard = val5;
		TempRankArray[4] = val5.rank.getValue();

		FirstCard = val1;
		TempSuitArray[0] = val1.suit.getSuit();
		SecondCard = val2;
		TempSuitArray[1] = val2.suit.getSuit();
		ThrirdCard = val3;
		TempSuitArray[2] = val3.suit.getSuit();
		FourthCard = val4;
		TempSuitArray[3] = val4.suit.getSuit();
		FifthCard = val5;
		TempSuitArray[4] = val5.suit.getSuit();

		// sort the raking array from the largest to the smellest.
		// so it will be easier to detect the ranking of pokerhand
		for (int i = 0; i < TempRankArray.length; i++) {
			for (int j = 0; j < TempRankArray.length - 1; j++) {
				if (TempRankArray[j] < TempRankArray[j + 1]) {
					int swapnum;
					swapnum = TempRankArray[j];
					TempRankArray[j] = TempRankArray[j + 1];
					TempRankArray[j + 1] = swapnum;
				}
			}
		}
		// check if its a hand of straight flush.
		if (val1.suit == val2.suit && val2.suit == val3.suit
				&& val3.suit == val4.suit && val4.suit == val5.suit
				&& TempRankArray[0] - 1 == TempRankArray[1]
				&& TempRankArray[1] - 1 == TempRankArray[2]
				&& TempRankArray[2] - 1 == TempRankArray[3]
				&& TempRankArray[3] - 1 == TempRankArray[4]) {
			cardtype = cardtype.StraightFlush;
			CardsChars[0] = TempRankArray[0];
		}

		// check Ace-lower StraightFlush
		else if (val1.suit == val2.suit && val2.suit == val3.suit
				&& val3.suit == val4.suit && val4.suit == val5.suit
				&& TempRankArray[0] == 14 && TempRankArray[1] == 5
				&& TempRankArray[2] == 4 && TempRankArray[3] == 3
				&& TempRankArray[4] == 2) {
			cardtype = cardtype.StraightFlush;
			CardsChars[0] = TempRankArray[1];
		}

		// check if its a four of a kind
		else if (TempRankArray[0] == TempRankArray[1]
				&& TempRankArray[1] == TempRankArray[2]
				&& TempRankArray[2] == TempRankArray[3]) {
			cardtype = cardtype.FourofaKind;
			CardsChars[0] = TempRankArray[0];
			CardsChars[1] = TempRankArray[4];
		}

		else if (TempRankArray[1] == TempRankArray[2]
				&& TempRankArray[2] == TempRankArray[3]
				&& TempRankArray[3] == TempRankArray[4]) {
			cardtype = cardtype.FourofaKind;
			CardsChars[0] = TempRankArray[1];
			CardsChars[1] = TempRankArray[0];
		}

		// check full house
		else if (TempRankArray[0] == TempRankArray[1]
				&& TempRankArray[1] == TempRankArray[2]
				&& TempRankArray[3] == TempRankArray[4]) {
			cardtype = cardtype.FullHouse;
			CardsChars[0] = TempRankArray[0];
			CardsChars[1] = TempRankArray[3];
		} else if (TempRankArray[0] == TempRankArray[1]
				&& TempRankArray[2] == TempRankArray[3]
				&& TempRankArray[3] == TempRankArray[4]) {
			cardtype = cardtype.FullHouse;
			CardsChars[0] = TempRankArray[2];
			CardsChars[1] = TempRankArray[0];

		}

		// check flush
		else if (val1.suit == val2.suit && val2.suit == val3.suit
				&& val3.suit == val4.suit && val4.suit == val5.suit) {
			cardtype = cardtype.Flush;
			CardsChars[0] = TempRankArray[0];
			CardsChars[1] = TempRankArray[1];
			CardsChars[2] = TempRankArray[2];
			CardsChars[3] = TempRankArray[3];
			CardsChars[4] = TempRankArray[4];
		}

		// check straight
		else if (TempRankArray[0] - 1 == TempRankArray[1]
				&& TempRankArray[1] - 1 == TempRankArray[2]
				&& TempRankArray[2] - 1 == TempRankArray[3]
				&& TempRankArray[3] - 1 == TempRankArray[4]) {
			cardtype = cardtype.Straight;
			CardsChars[0] = TempRankArray[0];
		}

		else if (TempRankArray[0] == 14 && TempRankArray[1] == 5
				&& TempRankArray[2] == 4 && TempRankArray[3] == 3
				&& TempRankArray[4] == 2) {
			cardtype = cardtype.Straight;
			CardsChars[0] = TempRankArray[1];
		}

		// check if its Three of a Kind
		else if (TempRankArray[0] == TempRankArray[1]
				&& TempRankArray[1] == TempRankArray[2]) {
			cardtype = cardtype.ThreeofaKind;
			CardsChars[0] = TempRankArray[0];
			CardsChars[1] = TempRankArray[3];
			CardsChars[2] = TempRankArray[4];
		}

		else if (TempRankArray[1] == TempRankArray[2]
				&& TempRankArray[2] == TempRankArray[3]) {
			cardtype = cardtype.ThreeofaKind;
			CardsChars[0] = TempRankArray[1];
			CardsChars[1] = TempRankArray[0];
			CardsChars[2] = TempRankArray[4];
		}

		else if (TempRankArray[2] == TempRankArray[3]
				&& TempRankArray[3] == TempRankArray[4]) {
			cardtype = cardtype.ThreeofaKind;
			CardsChars[0] = TempRankArray[2];
			CardsChars[1] = TempRankArray[0];
			CardsChars[2] = TempRankArray[1];
		}
		// check if its Two Pairs
		else if (TempRankArray[0] == TempRankArray[1]
				&& TempRankArray[2] == TempRankArray[3]) {
			cardtype = cardtype.TwoPairs;
			CardsChars[0] = TempRankArray[0];
			CardsChars[1] = TempRankArray[2];
			CardsChars[2] = TempRankArray[4];
		} else if (TempRankArray[0] == TempRankArray[1]
				&& TempRankArray[3] == TempRankArray[4]) {
			cardtype = cardtype.TwoPairs;
			CardsChars[0] = TempRankArray[0];
			CardsChars[1] = TempRankArray[3];
			CardsChars[2] = TempRankArray[2];
		}

		else if (TempRankArray[1] == TempRankArray[2]
				&& TempRankArray[3] == TempRankArray[4]) {
			cardtype = cardtype.TwoPairs;
			CardsChars[0] = TempRankArray[1];
			CardsChars[1] = TempRankArray[3];
			CardsChars[2] = TempRankArray[0];
		}

		// check if its One Pair
		else if (TempRankArray[0] == TempRankArray[1]) {
			cardtype = cardtype.Pair;
			CardsChars[0] = TempRankArray[0];
			CardsChars[1] = TempRankArray[2];
			CardsChars[2] = TempRankArray[3];
			CardsChars[3] = TempRankArray[4];
		}

		else if (TempRankArray[1] == TempRankArray[2]) {
			cardtype = cardtype.Pair;
			CardsChars[0] = TempRankArray[1];
			CardsChars[1] = TempRankArray[0];
			CardsChars[2] = TempRankArray[3];
			CardsChars[3] = TempRankArray[4];
		}

		else if (TempRankArray[2] == TempRankArray[3]) {
			cardtype = cardtype.Pair;
			CardsChars[0] = TempRankArray[2];
			CardsChars[1] = TempRankArray[0];
			CardsChars[2] = TempRankArray[1];
			CardsChars[3] = TempRankArray[4];
		}

		else if (TempRankArray[3] == TempRankArray[4]) {
			cardtype = cardtype.Pair;
			CardsChars[0] = TempRankArray[3];
			CardsChars[1] = TempRankArray[0];
			CardsChars[2] = TempRankArray[1];
			CardsChars[3] = TempRankArray[2];
		}

		// The rest is Single Cards
		else {
			cardtype = cardtype.SingleCards;
			CardsChars[0] = TempRankArray[0];
			CardsChars[1] = TempRankArray[1];
			CardsChars[2] = TempRankArray[2];
			CardsChars[3] = TempRankArray[3];
			CardsChars[4] = TempRankArray[4];
		}

	}

	private void PockerhandPower() {
		handPower = this.cardtype.getValue() * 10000000000L
				+ this.CardsChars[4] * 100000000 + this.CardsChars[3] * 1000000
				+ this.CardsChars[2] * 10000 + this.CardsChars[1] * 100
				+ this.CardsChars[0];
	}

	public long getthePower() {
		return handPower;
	}
}

// enum Cardstype is used to list all pokerhand rankings
enum CardsType {
	StraightFlush(8), FourofaKind(7), FullHouse(6), Flush(5), Straight(4), ThreeofaKind(
			3), TwoPairs(2), Pair(1), SingleCards(0);

	public int getValue() {
		return value;
	}

	private int value;

	CardsType(int val) {
		value = val;
	}

}
