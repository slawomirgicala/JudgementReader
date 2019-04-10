import java.util.*;

import static java.util.stream.Collectors.toMap;

public class JudgmentQueries implements IJudgmentQueries{

    private Map<Integer,Judgment> judgmentMap;


    public JudgmentQueries(Map<Integer,Judgment> judgmentMap){
        this.judgmentMap = judgmentMap;
    }


    @Override
    public String getSentence(String signature){
        //Integer sig = Integer.parseInt(signature);// do debbugowania
        Judgment judgment = judgmentMap.get(Objects.hash(signature));
        if (judgment == null){
            return "No corresponding sentence for signature: " + signature;
        }
        return judgment.toString();
    }

    @Override
    public String getReason(String signature) {
        Judgment judgment = judgmentMap.get(Objects.hash(signature));
        if (judgment == null){
            return "No corresponding sentence for signature: " + signature;
        }
        return judgment.getTextContent();
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
            for (Judge judgesInSentence : value.getJudges()){
                if (judgesInSentence.getName().equals(judge)) counter++;
            }
        }
        return counter;
    }

    @Override
    public String getTop10() {

        Map<String,Integer> hm = new HashMap<>();
        for (Judgment judgment : judgmentMap.values()){
            for (Judge judge : judgment.getJudges()){
                Integer j = hm.get(judge.getName());
                hm.put(judge.getName(), (j == null) ? 1 : j + 1);
            }
        }
        Map<String,Integer> sorted = hm.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .limit(10)
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,LinkedHashMap::new));
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String,Integer> val : sorted.entrySet()){
            stringBuilder.append(val.getKey());
            stringBuilder.append(": ");
            stringBuilder.append(val.getValue());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public String sentencesByMonth() {
        Map<Integer,Integer> hm = new HashMap<>();
        for (Judgment judgment : judgmentMap.values()){
            Integer j = hm.get(judgment.getMonth());
            hm.put(judgment.getMonth(), (j == null) ? 1 : j + 1);
        }
        String result = "";
        StringBuilder stringBuilder = new StringBuilder(result);
        for (Map.Entry<Integer,Integer> val : hm.entrySet()){
            stringBuilder.append(Month.values()[val.getKey()-1]);
            stringBuilder.append("-liczba orzeczen: ");
            stringBuilder.append(val.getValue());
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
    public String popularRegulations() {

        Map<Regulation,Integer> hm = new HashMap<>();
        for (Judgment judgment : judgmentMap.values()){
            for (Regulation regulation : judgment.getRegulations()){
                Integer j = hm.get(regulation);
                hm.put(regulation, (j == null) ? 1 : j + 1);
            }
        }
        Map<Regulation,Integer> sorted = hm.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .limit(10)
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,LinkedHashMap::new));
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Regulation,Integer> val : sorted.entrySet()){
            stringBuilder.append(val.getKey());
            stringBuilder.append(": ");
            stringBuilder.append(val.getValue());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();

    }

    @Override
    public String numberOfJudges() {
        Map<Integer,Integer> hm = new HashMap<>();
        for (Judgment judgment : judgmentMap.values()){
            Integer j = hm.get(judgment.getJudges().size());
            hm.put(judgment.getJudges().size(), (j == null) ? 1 : j + 1);
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
