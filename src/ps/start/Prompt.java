package ps.start;
import java.util.Scanner;

public class Prompt {

	private Game game;
	
	public Prompt(Game game){
		this.game=game;
	}

	//1. Silnik rozgrywki
	public boolean promptForGuess(){
		boolean isHint=false;
		Scanner scanner = new Scanner(System.in);
		boolean isAccepteble = false;

		do {
			System.out.println("Enter a letter: ");
			String guessInput = scanner.nextLine();
			

			try {
				isHint = game.applayGuess(guessInput); //czy litera ?
				isAccepteble =true;
			} catch (IllegalArgumentException iae) {
				System.out.printf("Please try again " + iae.getMessage());
			}
		} while (!isAccepteble);
		return isHint;
		
	}


	public void displayProgress(){
		System.out.printf("You have %d tries left to solve : %s%n",game.getRemaingTries(), game.getCurrentProgress());

}
	public void displayOutcome() {
		
		if(game.isWon()) System.out.printf("You Won !! Tries remain %d", game.getRemaingTries());
		else System.out.println("Upps mayby next time. The Answer was "+game.getAnswer());
		
	}
}
