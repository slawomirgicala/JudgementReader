import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.commons.io.FilenameUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

public class HtmlParser implements IParser {

    @Override
    public void parseDir(Map map, String dirPath){
        File dir = new File(dirPath);
        File[] dirList = dir.listFiles();
        if (dirList != null){
            for (File child : dirList){
                if (child.isDirectory() ){
                    parseDir(map,child.getPath());
                }else if (FilenameUtils.getExtension(child.getName()).equals("html")){
                    parseOne(map, child.getAbsolutePath());
                }
            }
        }else {
            System.out.println("This is not directory or directory is empty\n");
        }

    }


    @Override
    public void parseOne(Map judgments,String filePath) {

        File input = new File(filePath);
        try{

            Document doc = Jsoup.parse(input, "UTF-8");

            String title = doc.title();

            String signature = title.substring(0,title.indexOf(" - "));

            String date = title.substring(title.length() - 10);

            CourtType courtType;
            if (title.contains("WSA")) courtType = CourtType.WOJEWODZKI_SAD_ADMINISTRACYJNY;
            else courtType = CourtType.NACZELNY_SAD_ADMINISTRACYJNY;

            Elements content = doc.getElementsByClass("info-list-value-uzasadnienie");
            String textContent = content.text();

            Elements infoValues = doc.getElementsByClass("info-list-value");
            String judgesInfo = infoValues.get(3).toString().substring(29);
            judgesInfo = judgesInfo.substring(0,judgesInfo.length() - 6);
            String[] judgesSplit = judgesInfo.split("<br>");
            ArrayList<Judge> judges = new ArrayList<>();
            for (String oneJudge : judgesSplit){
                Judge judge = new Judge();
                if (!oneJudge.contains("/")){
                    judge.setName(oneJudge);
                    judges.add(judge);
                }else{
                    judge.setName(oneJudge.substring(0 ,oneJudge.indexOf("/") - 1));
                    oneJudge = oneJudge.substring(oneJudge.indexOf("/") + 1, oneJudge.length() - 1);
                    String[] tmpRoles = oneJudge.split(" ");
                    for (String tmpRole : tmpRoles){
                        switch (tmpRole){
                            case "przewodniczący":
                                judge.addRole("PRESIDING_JUDGE");
                            case "sprawozdawca":
                                judge.addRole("REPORTING_JUDGE");
                        }
                    }
                    judges.add(judge);
                }
            }

            ArrayList<Regulation> referencedRegulations = new ArrayList<>();
            Elements regElements = doc.getElementsByClass("nakt");
            if (!regElements.text().equals("")){
                String tmpReg = regElements.text().substring(20);
                tmpReg = tmpReg.substring(0,tmpReg.length() - 7);
                String[] refRegs = tmpReg.split("<br>");
                for (String reg : refRegs){
                    Regulation regulation = new Regulation();
                    regulation.setJournalTitle(reg);
                    referencedRegulations.add(regulation);
                }
            }

            Judgment judgment = new Judgment(signature,date,courtType,textContent,judges,referencedRegulations);
            judgments.put(judgment.hashCode(),judgment);

        }catch (IOException ex){
            System.out.println(ex.toString());
        }
    }
}
