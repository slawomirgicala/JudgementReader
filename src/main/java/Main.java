import java.util.HashMap;
import java.util.Map;

public class Main {


    public static void main(String[] args){
        Map judgments = new HashMap<Integer,Judgment>();
        new JsonParser().parseDir(judgments, "/home/slawomir/judgments-sample");
        new HtmlParser().parseDir(judgments, "/home/slawomir/cbosa");
        JudgmentQueries queries = new JudgmentQueries(judgments);
        new AppGUI(queries).buildGUI();
    }
}
