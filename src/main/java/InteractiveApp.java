import java.util.Scanner;

public class InteractiveApp {

    private boolean shouldRun = true;
    private JudgmentQueries queries;

    public InteractiveApp(JudgmentQueries judgmentQueries){
        this.queries = judgmentQueries;
    }

    public void run(){
        while(shouldRun){
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            String command = "";
            String[] arguments = null;
            if (!input.contains(" ")) command = input;
            else {
                command = input.substring(0,input.indexOf(" "));
                arguments = input.substring(input.indexOf(" ")).split(" ");
            }


            switch (command){
                case "exit":
                    shouldRun = false;
                case "rubrum":
                    if (arguments.length < 1){
                        System.out.println("podaj argumenty");
                    }else{
                        System.out.println(queries.getSentences(arguments));
                    }
                case "content":
                    System.out.println(queries.getReason(arguments[0]));
                case "judge":
                    String judge = "";
                    for (String arg : arguments) judge = judge + arg;
                    System.out.println(queries.getNumberOfSentences(judge));
                case "judges":
                    System.out.println(queries.getTop10());
                case "months":
                    System.out.println(queries.sentencesByMonth());
                case "courts":
                    System.out.println(queries.sentencesByCourt());
                case "regulations":
                    System.out.println(queries.popularRegulations());
                case "jury":
                    System.out.println(queries.numberOfJudges());
                case "help":
                    System.out.println("Dostepne komendy: rubrum, content, judge, judges, moths, courts, regulations, jury");
                    default:
                        System.out.println("nie ma takiej komendy, wpisz \"help\"");
            }
        }

    }
}
