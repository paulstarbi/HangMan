package ps.start;

public class Game {
	public static final int MAX_MISSES=5;
	private String answer;
	private String hits;
	private String misses;

	public Game(String answer){
		this.answer=answer.toLowerCase();  // wazne czy dobra litera nie czy dobry Case
		hits = "";
		misses="";
	}

	// 1.letter ze scanner, normalizacja znaku,
	// 2.sprawdzenie czy jest w odpowiedzi,
	// 3.jak tak lo litera do trafionych, jak nie to literka do misses

	public boolean applayGuess(char letter){
		letter = normalizeGuess(letter);
		boolean isHit = answer.indexOf(letter)!=-1;
		if(isHit){
			hits+=letter;
		}else {
			misses+=letter;
		}
		return isHit;
	}
	//Sprawdza czy cos podane jak tak to zwraca pierwszy podany znak

	public boolean applayGuess(String letters){
		if(letters.length()==0){
			throw new IllegalArgumentException("No letter found\n");
		}
		return applayGuess(letters.charAt(0));
	}


	//1.sprawdzenie czy podana zostala litera, jak nie to rzuca wyjatkiem, dodatkowo noramlizuje Case literki
	//2.sprawdzenie czy litera nie byla juz wczesniej podana - sprawdza i w hits i w misses

	private char normalizeGuess(char letter){
		if (!Character.isLetter(letter)){
			throw new IllegalArgumentException("A letter is required");
		}
		letter = Character.toLowerCase(letter);

		if (misses.indexOf(letter)!=-1 || hits.indexOf(letter)!=-1){
			throw new IllegalArgumentException("Letter has alredy been guess!");
		}
		return letter;
	}
		//1. Przy wykorzystaniu stalej MaxMisses oblicza ile zostalo prob
	public int getRemaingTries(){
		return MAX_MISSES-misses.length();
	}

	//1.Odswierzanie naszego stringa z odpoweirdziami - zastepowanie - trafiona literka

	public String getCurrentProgress(){
		String progress = "";
		for(char letter:answer.toCharArray()){ //wypisuje tyle ile trzeba -----
			char display='-';
			if(hits.indexOf(letter)!=-1){ //sprawdza czy nie trafiona  i jak tak to zastepuje litera
				display=letter;
			}
			progress +=display;
		}
		return progress;
	}

	/* ssprawdzenie czy zawodnik juz trafil wszystkie litery z answer
	z wykorzystaniem metody getCurrentProgress jak nie ma juz "-" to zwroci -1*/

	public boolean isWon(){
				return getCurrentProgress().indexOf('-') == -1;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
