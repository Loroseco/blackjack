package house;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class to handle player hand storage / display, and player score calculation
 * @author Loroseco
 *
 */
class Board {
	
	private Deck deck;
	private int nOfPlayers;
	private HashMap<String, Integer> cardValues = new HashMap<String, Integer>();
	private ArrayList<ArrayList<String>> playerHands = new ArrayList<ArrayList<String>>();
	
	/**
	 * Board constructor. Populates cardValues in order to calculate score later
	 * @param nOfPlayers	Number of players not including dealer
	 */
	Board(int nOfPlayers, int nOfDecks) {
		this.nOfPlayers = nOfPlayers;
		
		deck = new Deck(nOfDecks);
		deck.createDeck();
		
		cardValues.put("A", 11);
		cardValues.put("2", 2);
		cardValues.put("3", 3);
		cardValues.put("4", 4);
		cardValues.put("5", 5);
		cardValues.put("6", 6);
		cardValues.put("7", 7);
		cardValues.put("8", 8);
		cardValues.put("9", 9);
		cardValues.put("10", 10);
		cardValues.put("J", 10);
		cardValues.put("Q", 10);
		cardValues.put("K", 10);
	}
	
	/**
	 * Accessor
	 * @return	Number of players (not including dealer)
	 */
	int getNOfPlayers() {
		return nOfPlayers;
	}
	
	/**
	 * Calculates the value of a chosen player's hand
	 * @param player	Chosen player
	 * @return			Vaue of player's hand
	 */
	int getScore(int player) {
		int score = 0;
		ArrayList<String> hand = playerHands.get(player);
		for (String card : hand) {
			score += cardValues.get(card);
		}
		for (String card : hand) {
			if (score < 22) {
				break;
			} else if (card.equals("A")) {
				score -= 10;
			}
		}
		return score;
	}
	
	/**
	 * Prints the board after a confirmation, in order to give players enough time to pass the keyboard around
	 * @param p	Chosen player
	 */
	void printBoardBeforeTurn(int p) {
		//TODO: Do something here as a confirmation that the correct player is at the keyboard
		printBoard(p);
	}
	
	/**
	 * Prints the board, displaying only the chosen player's hand, and one card from the dealer's hand
	 * @param p	Chosen player
	 */
	void printBoard(int p) {
		System.out.println("-" + Integer.toString(p) + "-");
		System.out.println(playerHands.get(0).get(0));
		System.out.println(playerHands.get(p));
		//TODO: Implement
		
	}
	
	void newGame() {
		playerHands = new ArrayList<ArrayList<String>>(nOfPlayers);
		for (int p = 0; p < nOfPlayers + 1; p++) {
			addHand(deck.getHand());
		}
	}
	
	/**
	 * Draws a card from the deck and adds it to chosen player's hand
	 * @param p
	 */
	void hitMe(int p) {
		addCard(deck.hitMe(), p);
	}
	
	/**
	 * Adds a new player hand to the playerHands ArrayList
	 * @param hand	New hand
	 */
	private void addHand(ArrayList<String> hand) {
		playerHands.add(hand);
		
	}
	
	/**
	 * Adds a new card to a chosen player's hand
	 * @param card	New card
	 * @param hand	Chosen player's hand
	 */
	private void addCard(String card, int hand) {
		playerHands.get(hand).add(card);
	}

}
