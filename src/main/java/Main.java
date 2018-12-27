import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.helper.*;
import org.jsoup.internal.*;
import org.jsoup.nodes.*;
import org.jsoup.safety.*;
import org.jsoup.select.*;

import java.io.File;
import java.io.IOException;


public class Main {

    public static void main(String[] args){

        /*JsonParser parser = new JsonParser(args[0]);
        JudgmentQueries queries = new JudgmentQueries(parser.parse());
        //String[] tester = {"94832","34544"};
        System.out.println(queries.getTop10());
        System.out.println(queries.getNumberOfSentences("Zbigniew Myszka"));
        System.out.println(queries.popularRegulations());*/

        File input = new File("C:\\Users\\sgica\\Desktop\\GoodbyeWorld\\semestr3\\obiektowe\\html\\09\\02\\2B471727BF.html");
        try{
            Document doc = Jsoup.parse(input, "UTF-8");
            //Element test = doc.getElementById("header");
            String title = doc.title();
            //String tester = test.text();
            //System.out.println(title.indexOf(" - "));
            String signature = title.substring(0,title.indexOf(" - "));

            String date = title.substring(title.length() - 10);

            //Elements infoValues = doc.getElementsByClass("info-list-value");
            if (title.contains("WSA")) System.out.println("Wojewódzki");
            else System.out.println("naczelny");

            Elements textContent = doc.getElementsByClass("info-list-value-uzasadnienie");  //.text()

            Elements infoValues = doc.getElementsByClass("info-list-value");
            //String[] judges = infoValues.get(3).toString().substring(29).split("<br>");
            String judgesInfo = infoValues.get(3).toString().substring(29);
            judgesInfo = judgesInfo.substring(0,judgesInfo.length() - 6);
            String[] judges = judgesInfo.split("<br>");




            for (String str : judges){
                System.out.println(str);
            }

            System.out.println(judges);
        }catch (IOException ex){
            System.out.println(ex.toString());
        }


    }
}
