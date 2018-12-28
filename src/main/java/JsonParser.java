import javax.json.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class JsonParser implements IParser{

    private String path;

    public JsonParser(String path){
        this.path = path;
    }

    @Override
    public void parse(Map judgments) {
        //Map<Integer,Judgment> judgments = new HashMap<>();

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

                value = item.getJsonString("judgmentType");
                judgment.setJudgmentType(((JsonString) value).getString());

                value = item.getJsonString("judgmentDate");
                judgment.setDate(((JsonString) value).getString());

                value = item.getJsonString("courtType");
                judgment.setCourtType(((JsonString) value).getString());

                value = item.getJsonString("textContent");
                judgment.setTextContent(((JsonString) value).getString());

                JsonArray judges = item.getJsonArray("judges");
                for (int j = 0; j < judges.size(); j++){
                    JsonObject jsonJudge = judges.getJsonObject(j);
                    Judge judge = new Judge();
                    value = jsonJudge.getJsonString("name");
                    judge.setName(((JsonString) value).getString());

                    JsonArray roles = jsonJudge.getJsonArray("specialRoles");
                    for (int k = 0; k < roles.size(); k++){
                        value = roles.getJsonString(k);
                        judge.addRole(((JsonString) value).getString());
                    }
                    judgment.addJudge(judge);
                }

                JsonArray referencedRegulations = item.getJsonArray("referencedRegulations");
                for (int j = 0; j < referencedRegulations.size(); j++){
                    JsonObject jsonRegulation = referencedRegulations.getJsonObject(j);
                    Regulation regulation = new Regulation();
                    value = jsonRegulation.getJsonString("journalTitle");
                    regulation.setJournalTitle(((JsonString) value).getString());
                    value = jsonRegulation.getJsonNumber("journalNo");
                    regulation.setJournalNo(((JsonNumber) value).intValue());
                    value = jsonRegulation.getJsonNumber("journalYear");
                    regulation.setJournalYear(((JsonNumber) value).intValue());
                    value = jsonRegulation.getJsonNumber("journalEntry");
                    regulation.setJournalEntry(((JsonNumber) value).intValue());
                    judgment.addRegulation(regulation);
                }

                judgments.put(judgment.hashCode(),judgment);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //return judgments;
    }
}
