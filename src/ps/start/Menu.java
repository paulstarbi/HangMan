package ps.start;

import java.util.Scanner;

/**
 * Created by Kasiula on 08.05.2017.
 */
public class Menu {
    public Answers answer = new Answers();
    private String loterryAnswer;

    public void promptMenu() {
        System.out.println("Witaj w Hang Man!!!");
        System.out.printf("Wybierz poziom trudności: \n1: Easy\t2: Medium\t3: Hard\n You pick: ");

        Scanner scn = new Scanner(System.in);
        int dif = scn.nextInt();
        String tmp = answer.answerLottery(dif);
        this.loterryAnswer =tmp;

    }

    public String getLoterryAnswer() {
        return loterryAnswer;
    }
}
