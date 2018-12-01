import javax.json.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Main {

    public static void main(String[] args){

        InputStream fis = null;
        try {
            fis = new FileInputStream("C:\\Users\\sgica\\Desktop\\GoodbyeWorld\\semestr3\\obiektowe\\json\\judgments-348.json");
            JsonReader jsonReader = Json.createReader(fis);
            JsonObject jsonObject = jsonReader.readObject();
            JsonArray items = jsonObject.getJsonArray("items");
            for(int i = 0; i < items.size(); i++){
                JsonObject court = items.getJsonObject(i);
                court.getJsonString("decision");
                court.getJsonObject("source");
                System.out.println(obj.toString());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
