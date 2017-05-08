package ps.start;

public class HangMan {

	public static void main(String[] args) {

		Game game = new Game(new Answers());
		Prompt prompter = new Prompt(game);

		while (game.getRemaingTries()>0 && !game.isWon()){
			prompter.displayProgress();
			prompter.promptForGuess();
		}
		prompter.displayOutcome();
	}
	
}
