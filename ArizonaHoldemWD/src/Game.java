import java.util.Scanner;

public class Game {
	Scanner keyboard = new Scanner(System.in);
	{
		System.out.print("How Many Players:?");
	}
	int NumofPlayers = keyboard.nextInt();
	Player[] AllPlayers = new Player[NumofPlayers];
	Dealer theDealer = new Dealer();
	Card[] CommunityCards;

	public void initialtheGame() {
		for (int i = 1; i <= NumofPlayers; i++) {
			{
				System.out.print("Player" + i + "'sName is?");
			}
			String PlayerName = keyboard.next();
			AllPlayers[i - 1] = new Player(PlayerName, 100);
		}
	}

	Player[] winners;
	public boolean CountinePlay = true;

	public void playtheGame() {
		while (CountinePlay = true) {
			theDealer.shuffle();
			CommunityCards = theDealer.dealCards(AllPlayers);
			for (int i = 0; i < AllPlayers.length; i++) {
				AllPlayers[i].bestHand(CommunityCards);
			}
			winners = theDealer.Winners;
			theDealer.distributeMoney();
			{
				System.out.print("Play another game?");
			}
			CountinePlay = keyboard.nextBoolean();
		}
	}
}