import javax.json.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class JsonParser implements IParser{

    //Map<Integer,Judgment> judgments = new HashMap();
    private String path;

    public JsonParser(String path){
        this.path = path;
    }

    @Override
    public Map parse() {
        Map<Integer,Judgment> judgments = new HashMap<>();

        InputStream fis = null;
        try {
            fis = new FileInputStream(this.path);
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
                    JudgeWithRoles judgeWithRoles = new JudgeWithRoles();
                    value = jsonJudge.getJsonString("name");
                    judgeWithRoles.setName(((JsonString) value).getString());

                    JsonArray roles = jsonJudge.getJsonArray("specialRoles");
                    for (int k = 0; k < roles.size(); k++){
                        value = roles.getJsonString(k);
                        judgeWithRoles.addRole(((JsonString) value).getString());
                    }
                    judgment.addJudge(judgeWithRoles);
                }

                judgments.put(judgment.hashCode(),judgment);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return judgments;
    }
}
