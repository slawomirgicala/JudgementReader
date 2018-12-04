public interface IJudgmentQueries {

    String getSentence(String signature);

    String getReason(String signature);

    String getSentences(String[] signatures);

    int getNumberOfSentences(String judge);

    String getTop10(String top);

    String sentencesByMonth(String monthly);

    String sentencesByCourt();

    String popularRegulations(String regulations);

    String numberOfJudges();

}
