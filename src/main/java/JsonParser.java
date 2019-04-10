import org.apache.commons.io.FilenameUtils;

import javax.json.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class JsonParser implements IParser{

    /*private Map map;
    private String dirPath;

    public JsonParser(Map map, String dirPath){
        this.map = map;
        this.dirPath = dirPath;
    }*/

    @Override
    public void parseDir(Map map, String dirPath){
        File dir = new File(dirPath);
        File[] dirList = dir.listFiles();
        if (dirList != null){
            for (File child : dirList){
                if (child.isDirectory() ){
                    parseDir(map,child.getPath());
                }else if (FilenameUtils.getExtension(child.getName()).equals("json")){
                    parseOne(map, child.getAbsolutePath());
                }
            }
        }else {
            System.out.println("This is not directory or directory is empty\n");
        }

    }


    @Override
    public void parseOne(Map judgments, String filePath) {

        InputStream fis = null;
        try {
            fis = new FileInputStream(filePath);
            JsonReader jsonReader = Json.createReader(fis);
            JsonObject jsonObject = jsonReader.readObject();
            JsonArray items = jsonObject.getJsonArray("items");
            for(int i = 0; i < items.size(); i++){
                JsonObject item = items.getJsonObject(i);

                JsonArray courtCases = item.getJsonArray("courtCases");
                JsonObject firstCaseNumber = courtCases.getJsonObject(0);
                JsonString caseNumber = firstCaseNumber.getJsonString("caseNumber");
                String signature = caseNumber.getString();

                JsonValue value = item.getJsonString("judgmentDate");
                String date = ((JsonString) value).getString();

                value = item.getJsonString("courtType");
                String courtTypeStr = ((JsonString) value).getString();
                CourtType courtType = null;
                switch (courtTypeStr) {
                    case "COMMON":
                        courtType = CourtType.COMMON;
                        break;
                    case "SUPREME":
                        courtType = CourtType.SUPREME;
                        break;
                    case "ADMINISTRATIVE":
                        courtType = CourtType.ADMINISTRATIVE;
                        break;
                    case "CONSTITUTIONAL_TRIBUNAL":
                        courtType = CourtType.CONSTITUTIONAL_TRIBUNAL;
                        break;
                    case "NATIONAL_APPEAL_CHAMBER":
                        courtType = CourtType.NATIONAL_APPEAL_CHAMBER;
                        break;
                }

                value = item.getJsonString("textContent");
                String textContent = ((JsonString) value).getString();

                ArrayList<Judge> judges = new ArrayList<>();
                JsonArray jsonJudges = item.getJsonArray("judges");
                for (int j = 0; j < jsonJudges.size(); j++){
                    JsonObject jsonJudge = jsonJudges.getJsonObject(j);
                    Judge judge = new Judge();
                    value = jsonJudge.getJsonString("name");
                    judge.setName(((JsonString) value).getString());

                    JsonArray roles = jsonJudge.getJsonArray("specialRoles");
                    for (int k = 0; k < roles.size(); k++){
                        value = roles.getJsonString(k);
                        judge.addRole(((JsonString) value).getString());
                    }
                    judges.add(judge);
                }

                ArrayList<Regulation> referencedRegulations = new ArrayList<>();
                JsonArray jsonRefRegs = item.getJsonArray("referencedRegulations");
                for (int j = 0; j < jsonRefRegs.size(); j++){
                    JsonObject jsonRegulation = jsonRefRegs.getJsonObject(j);
                    Regulation regulation = new Regulation();
                    value = jsonRegulation.getJsonString("journalTitle");
                    regulation.setJournalTitle(((JsonString) value).getString());
                    referencedRegulations.add(regulation);
                }
                Judgment judgment = new Judgment(signature,date,courtType,textContent,judges,referencedRegulations);
                judgments.put(judgment.hashCode(),judgment);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
