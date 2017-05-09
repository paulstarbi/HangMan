package ps.start;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by Kasiula on 06.05.2017.
 */
public class Answers {
    private String answer;
    public List <String> aArray;
    private String level;

    public String answerLottery (int dif){
        StringTokenizer word = new StringTokenizer(WordList, ", "); //pozwala na latwe wydzielanie tokenow z ciagu
        //stringa
        aArray = new ArrayList<>();
        while (word.hasMoreTokens()){//dodaje wszystkie tokeny
            aArray.add(word.nextToken());
        }
        return losowanie(aArray,dif);
    }

        // chossing the word according to the difficult level;
    public String losowanie(List<String> listOfWords, int dif){
        int n;
        String word="";
        boolean flag = true;
        while(flag){
        n=(int)(Math.random()*listOfWords.size());
        word = listOfWords.get(n);
            if (dif == 1){
                this.level = "Easy";
                if (word.length()<10)
                    flag=false;
            } else if (dif ==2){
                this.level = "Medium";
                if (word.length()<20 && word.length()>10)
                    flag=false;
            }else if (dif == 3){
                this.level = "Hard";
                if (word.length()>20)
                    flag = false;
            }
        }
        this.answer = word;
        System.out.println("Your chosen is "+ this.level + ". Good Luck !!!");
        return this.answer;
    }


    String WordList = "Polska, niemcy, francja, kasia, polak, pawel, dyskryminacja, zobaczymy, nowoczesnosc, " +
            "anglia, zoBaczymy, nieWierm, brakPomyslu, muszeDodacLadowanieZPliku";

}
