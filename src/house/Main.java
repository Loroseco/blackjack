package house;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Blackjack game = new Blackjack();
		Scanner scan = new Scanner(System.in);
		Board board = new Board(1, 5);
		Bank bank = new Bank(1, 10);
		while (true) {
			game.play(board, bank, scan);
			System.out.print("PLAY AGAIN? (Y/N): ");
			String input = scan.next();
			if (!input.toLowerCase().equals("y")) {
				break;
			}
		}
		scan.close();
	}
}
