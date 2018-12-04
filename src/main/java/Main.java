import javax.json.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args){

        /*Map<Integer,Judgment> judgments = new HashMap();

        InputStream fis = null;
        try {
            fis = new FileInputStream("C:\\Users\\sgica\\Desktop\\GoodbyeWorld\\semestr3\\obiektowe\\json\\judgments-348.json");
            JsonReader jsonReader = Json.createReader(fis);
            JsonObject jsonObject = jsonReader.readObject();
            JsonArray items = jsonObject.getJsonArray("items");
            for(int i = 0; i < items.size(); i++){
                JsonObject item = items.getJsonObject(i);

                Judgment judgment = new Judgment();

                JsonValue value = item.getJsonNumber("id");
                judgment.setSignature(((JsonNumber) value).intValue());

                value = item.getJsonString("judgmentDate");
                judgment.setDate(((JsonString) value).getString());

                value = item.getJsonString("courtType");
                judgment.setCourtType(((JsonString) value).getString());

                JsonArray judges = item.getJsonArray("judges");
                for (int j = 0; j < judges.size(); j++){
                    JsonObject jsonJudge = judges.getJsonObject(j);
                    JudgeWithRoles judge = new JudgeWithRoles();
                    value = jsonJudge.getJsonString("name");
                    judge.setName(((JsonString) value).getString());

                    JsonArray roles = jsonJudge.getJsonArray("specialRoles");
                    for (int k = 0; k < roles.size(); k++){
                        value = roles.getJsonString(k);
                        judge.addRole(((JsonString) value).getString());
                    }
                    judgment.addJudge(judge);
                }

                judgments.put(judgment.hashCode(),judgment);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Judgment tester = judgments.get(13408);
        System.out.println(tester.getSignature() +  " " + tester.getDate());
        */
        JsonParser parser = new JsonParser(args[0]);
        JudgmentQueries queries = new JudgmentQueries(parser.parse());
        System.out.println(queries.getSentence("283463"));
    }
}
