package ps.start;

public class HangMan {

	public static void main(String[] args) {

		Menu menu = new Menu();
		menu.promptMenu();
		Game game = new Game(menu.getLoterryAnswer());
		Prompt prompter = new Prompt(game);

		while (game.getRemaingTries()>0 && !game.isWon()){
			prompter.displayProgress();
			prompter.promptForGuess();
		}
		prompter.displayOutcome();
	}
	
}
