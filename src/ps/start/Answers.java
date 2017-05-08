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


    public String answerLottery (){
        StringTokenizer word = new StringTokenizer(WordList, ", "); //pozwala na latwe wydzielanie tokenow z ciagu
        //stringa
        aArray = new ArrayList<>();
        while (word.hasMoreTokens()){//dodaje wszystkie tokeny
            aArray.add(word.nextToken());
        }
        System.out.println("There are "+aArray.size()+" words in our database try to guess correct");
        return losowanie(aArray);

    }

    public String losowanie(List<String> listOfWords){
        int n;
        n=(int)(Math.random()*listOfWords.size());
        this.answer = listOfWords.get(n);
        return this.answer;
    }

    public String difLevel(){
        String level = "";
        int i = this.answer.length();
        if (i>0 && i<=5){
            return level="Easy";
        } else if (i<=10){
            return level="Medium";
        } else {
            return level = "Hard";
        }
    }

    String WordList = "Polska, niemcy, francja, kasia, polak, pawel, dyskryminacja, zobaczymy, nowoczesnosc, " +
            "anglia, zoBaczymy, nieWierm, brakPomyslu, muszeDodacLadowanieZPliku";

}
