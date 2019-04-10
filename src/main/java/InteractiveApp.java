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
                arguments = input.substring(input.indexOf(" ")+1).split(" ");
            }


            switch (command){
                case "exit":
                    shouldRun = false;
                    break;
                case "rubrum":
                    if (arguments == null){
                        System.out.println("podaj argumenty");
                    }else{
                        String joinSignatures = String.join(" ",arguments);
                        String[] signatures = joinSignatures.split(",");
                        System.out.println(queries.getSentences(signatures));
                    }
                    break;
                case "content":
                    if (arguments != null){
                        String signature = String.join(" ",arguments);//poprawic reason, wypisuje sie jakies gowno
                        System.out.println(queries.getReason(signature));
                    }else {
                        System.out.println("Komenda wymaga argumentow");
                    }
                    break;
                case "judge":
                    if (arguments != null){
                        String judge = String.join(" ",arguments);
                        System.out.println(queries.getNumberOfSentences(judge));
                    }else{
                        System.out.println("Podaj imie i nazwisko sedziego\n");
                    }
                    break;
                case "judges":
                    System.out.println(queries.getTop10());
                    break;
                case "months":
                    System.out.println(queries.sentencesByMonth());
                    break;
                case "courts":
                    System.out.println(queries.sentencesByCourt());
                    break;
                case "regulations":
                    System.out.println(queries.popularRegulations());
                    break;
                case "jury":
                    System.out.println(queries.numberOfJudges());
                    break;
                case "help":
                    System.out.println("Dostepne komendy: rubrum, content, judge, judges, months, courts, regulations, jury");
                    break;
                default:
                    System.out.println("nie ma takiej komendy, wpisz \"help\"");
                    break;
            }
        }

    }
}
