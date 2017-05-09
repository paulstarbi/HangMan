package ps.start;

import java.util.Scanner;

/**
 * Created by Kasiula on 08.05.2017.
 */
public class Menu {
    public Answers answer = new Answers();
    private String loterryAnswer;


    public void choseDiffLevel() {
        System.out.println("Witaj w Hang Man!!!");
        System.out.printf("Wybierz poziom trudności: \n1: Easy\t2: Medium\t3: Hard\n You pick: ");

        Scanner scn = new Scanner(System.in);
        int dif = scn.nextInt();
        String tmp = answer.answerLottery(dif);
        this.loterryAnswer =tmp;

    }
    public void promptMenu(){
        System.out.println("HangMan!!!\n1:Start\n2.Exit");
        Scanner scn = new Scanner(System.in);
        int opt = scn.nextInt();

        if (opt==1){
            choseDiffLevel();
        Game game = new Game(this.loterryAnswer);
        Prompt prompter = new Prompt(game);

        while (game.getRemaingTries()>0 && !game.isWon()){
            prompter.displayProgress();
            prompter.promptForGuess();
        }
        prompter.displayOutcome();
            promptMenu();
        } else {
            System.out.println("Do zobaczenia");
        }

    }
    }
