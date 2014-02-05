public class Player {
	private String Name;
	private int Budget;
	Card[] SevenCards = new Card[7];
	private long maxPower;
	PokerHand[] AllCombination = new PokerHand[21];
	private int maxPowerIndex = 0;

	Player(String name, int InitialBudget) {
		Name = name;
		Budget = InitialBudget;
	}

	public int getBudget() {
		return Budget;
	}

	public String getName() {
		return Name;
	}

	public void getCards(Card val1, Card val2) {
		SevenCards[0] = val1;
		SevenCards[1] = val2;
	}

	public void bestHand(Card[] CommunityCard) {
		if (SevenCards[0] == CommunityCard[0]
				|| SevenCards[0] == CommunityCard[1]
				|| SevenCards[0] == CommunityCard[2]
				|| SevenCards[0] == CommunityCard[3]
				|| SevenCards[0] == CommunityCard[4]
				|| SevenCards[1] == CommunityCard[0]
				|| SevenCards[1] == CommunityCard[1]
				|| SevenCards[1] == CommunityCard[2]
				|| SevenCards[1] == CommunityCard[3]
				|| SevenCards[1] == CommunityCard[4])
			throw new DuplicateCardException();
		SevenCards[2] = CommunityCard[0];
		SevenCards[3] = CommunityCard[1];
		SevenCards[4] = CommunityCard[2];
		SevenCards[5] = CommunityCard[3];
		SevenCards[6] = CommunityCard[4];
		// sort the raking array from the largest to the smellest.
		// so it will be easier to detect the ranking of pokerhand
		for (int i = 0; i < SevenCards.length; i++) {
			for (int j = 0; j < SevenCards.length - 1; j++) {
				if (SevenCards[j].rank.getValue() < SevenCards[j + 1].rank
						.getValue()) {
					Card swapnum;
					swapnum = SevenCards[j];
					SevenCards[j] = SevenCards[j + 1];
					SevenCards[j + 1] = swapnum;
				}
			}
		}

		int index = 0;

		long[] AllCombinationPowers = new long[21];
		// There are 21 combinations of pocker hand
		for (int i = 0; i < 7; i++) {
			for (int j = i + 1; j < 7; j++) {
				for (int k = j + 1; k < 7; k++) {
					for (int o = k + 1; o < 7; o++) {
						for (int p = o + 1; p < 7; p++) {
							AllCombination[index] = new PokerHand(
									SevenCards[i], SevenCards[j],
									SevenCards[k], SevenCards[o], SevenCards[p]);
							AllCombinationPowers[index] = AllCombination[index]
									.getthePower();
							index++;
						}
					}
				}
			}
		}

		// Find the largest power
		maxPower = AllCombinationPowers[0];

		for (int i = 1; i < AllCombinationPowers.length; i++) {
			if (maxPower < AllCombinationPowers[i]) {
				maxPower = AllCombinationPowers[i];
				maxPowerIndex = i;
			}
		}
	}

	private PokerHand bestHand = AllCombination[maxPowerIndex];

	public long getBesthandPower() {
		return maxPower;
	}

	public PokerHand getBesthand() {
		return bestHand;
	}

	public void winMoney(int amount) {
		Budget = Budget + amount;
	}
}
