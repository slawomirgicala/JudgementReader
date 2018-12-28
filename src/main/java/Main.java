import java.util.HashMap;
import java.util.Map;

public class Main {


    public static void main(String[] args){
        Map judgments = new HashMap<Integer,Judgment>();
        new JsonParser("C:\\Users\\sgica\\Desktop\\GoodbyeWorld\\semestr3\\obiektowe\\json\\judgments-348.json").parse(judgments);
        new HtmlParser("C:\\Users\\sgica\\Desktop\\GoodbyeWorld\\semestr3\\obiektowe\\html\\04\\01\\70D462EECA.html").parse(judgments);
        JudgmentQueries queries = new JudgmentQueries(judgments);
        InteractiveApp app = new InteractiveApp(queries);
        app.run();
    }
}
