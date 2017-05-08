package ps.start;

public class HangMan {

	public static void main(String[] args) {

		Answers a = new Answers();
		Game game = new Game(a.answerLottery());
		Prompt prompter = new Prompt(game);
		
		while (game.getRemaingTries()>0 && !game.isWon()){
			prompter.displayProgress();
			prompter.promptForGuess();
		}
		prompter.displayOutcome();
	}
	
}
