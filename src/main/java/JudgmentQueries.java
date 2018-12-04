import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JudgmentQueries implements IJudgmentQueries{

    private Map<Integer,Judgment> judgmentMap;


    public JudgmentQueries(Map<Integer,Judgment> judgmentMap){
        this.judgmentMap = judgmentMap;
    }

    @Override
    public String getSentence(String signature){
        return judgmentMap.get(Integer.parseInt(signature)).toString();
    }

    @Override
    public String getReason(String signature) {
        return null;
    }

    @Override
    public String getSentences(String[] signatures) {
        String result = "";
        StringBuilder stringBuilder = new StringBuilder(result);
        for (String signature : signatures){
            stringBuilder.append(getSentence(signature));
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public int getNumberOfSentences(String judge) {
        int counter = 0;
        for (Judgment value : judgmentMap.values()){
            for (JudgeWithRoles judgesInSentence : value.getJudgeWithRoles()){
                if (judgesInSentence.getName().equals(judge)) counter++;
            }
        }
        return counter;
    }

    @Override
    public String getTop10(String top) {
        return null;
    }

    @Override
    public String sentencesByMonth(String monthly) {
        Map<Month,Integer> hm = new HashMap<>();
        for (Judgment judgment : judgmentMap.values()){
            Integer j = hm.get(judgment.getMonth());
            hm.put(judgment.getMonth(), (j == null) ? 1 : j + 1);
        }
        /*Stream<Map.Entry<Month,Integer>> sorted =
                hm.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue());*/
        String result = "";
        StringBuilder stringBuilder = new StringBuilder(result);
        for (Map.Entry<Month,Integer> val : hm.entrySet()){
            stringBuilder.append(val.getValue());
            stringBuilder.append("-liczba orzeczen: ");
            stringBuilder.append(val.getKey());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public String sentencesByCourt() {
        Map<CourtType,Integer> hm = new HashMap<>();
        for (Judgment judgment : judgmentMap.values()){
            Integer j = hm.get(judgment.getCourtType());
            hm.put(judgment.getCourtType(), (j == null) ? 1 : j + 1);
        }
        String result = "";
        StringBuilder stringBuilder = new StringBuilder(result);
        for (Map.Entry<CourtType,Integer> val : hm.entrySet()){
            stringBuilder.append(val.getValue());
            stringBuilder.append(" orzeczen ");
            stringBuilder.append(val.getKey());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public String popularRegulations(String regulations) {
        return null;
    }

    @Override
    public String numberOfJudges() {
        Map<Integer,Integer> hm = new HashMap<>();
        for (Judgment judgment : judgmentMap.values()){
            Integer j = hm.get(judgment.getJudgeWithRoles().size());
            hm.put(judgment.getJudgeWithRoles().size(), (j == null) ? 1 : j + 1);
        }
        String result = "";
        StringBuilder stringBuilder = new StringBuilder(result);
        for (Map.Entry<Integer,Integer> val : hm.entrySet()){
            stringBuilder.append(val.getValue());
            stringBuilder.append(" orzeczen, dla ktorych liczba sedziow wynosi: ");
            stringBuilder.append(val.getKey());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
