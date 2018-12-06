
public class Main {

    public static void main(String[] args){

        JsonParser parser = new JsonParser(args[0]);
        JudgmentQueries queries = new JudgmentQueries(parser.parse());
        //String[] tester = {"94832","34544"};
        System.out.println(queries.getTop10());
        System.out.println(queries.getNumberOfSentences("Zbigniew Myszka"));
        System.out.println(queries.popularRegulations());
    }
}
