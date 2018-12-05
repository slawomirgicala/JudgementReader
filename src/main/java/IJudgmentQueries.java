public interface IJudgmentQueries {

    String getSentence(String signature);

    String getReason(String signature);

    String getSentences(String[] signatures);

    int getNumberOfSentences(String judge);

    String getTop10();

    String sentencesByMonth();

    String sentencesByCourt();

    String popularRegulations();

    String numberOfJudges();

}
