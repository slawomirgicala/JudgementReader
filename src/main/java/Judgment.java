import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

public class Judgment {
    private final String signature;
    private final String date;
    private final CourtType courtType;
    private final String textContent;
    private final ArrayList<Judge> judges;
    private final ArrayList<Regulation> referencedRegulations;

    public Judgment(String signature,String date, CourtType courtType, String textContent, ArrayList<Judge> judges, ArrayList<Regulation> referencedRegulations){
        this.signature = signature;
        this.date = date;
        this.courtType = courtType;
        this.textContent = textContent;
        this.judges = judges;
        this.referencedRegulations = referencedRegulations;
    }

    @Override
    public int hashCode(){
        return Objects.hash(signature);
    }

    public String getSignature() {
        return signature;
    }

    public String getDate() {
        return date;
    }

    public CourtType getCourtType() {
        return courtType;
    }

    public String getTextContent() {
        return textContent;
    }

    public ArrayList<Judge> getJudges() {
        return judges;
    }

    public ArrayList<Regulation> getRegulations() {
        return referencedRegulations;
    }

    public Integer getMonth(){
        return Integer.parseInt(getDate().substring(5,7));
    }


    @Override
    public String toString(){

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Sygnatura: ");
        stringBuilder.append(getSignature());
        stringBuilder.append("\n");
        stringBuilder.append("Data: ");
        stringBuilder.append(getDate());
        stringBuilder.append("\n");
        stringBuilder.append("Rodzaj sadu: ");
        stringBuilder.append(getCourtType());
        stringBuilder.append("\n");
        stringBuilder.append("Sedziowie: ");

        for (Judge judge : getJudges()){
            stringBuilder.append(judge.getName());
            stringBuilder.append("(");
            stringBuilder.append(judge.getRole().stream().map(Object::toString)
                    .collect(Collectors.joining(", ")));
            stringBuilder.append(")");
            stringBuilder.append(", ");
        }
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
