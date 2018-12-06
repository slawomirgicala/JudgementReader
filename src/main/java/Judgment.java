import java.util.ArrayList;
import java.util.stream.Collectors;

public class Judgment {
    private int signature;
    private JudgmentType judgmentType;
    private String date;
    private CourtType courtType;
    private String textContent;
    private ArrayList<Judge> judges = new ArrayList<>();
    private ArrayList<Regulation> referencedRegulations = new ArrayList<>();


    @Override
    public int hashCode(){
        return signature;
    }

    public int getSignature() {
        return signature;
    }

    public void setSignature(int signature) {
        this.signature = signature;
    }

    public JudgmentType getJudgmentType() {
        return judgmentType;
    }

    public void setJudgmentType(String judgmentType) {
        switch (judgmentType){
            case "DECISION":
                this.judgmentType = JudgmentType.DECISION;
                break;
            case "RESOLUTION":
                this.judgmentType = JudgmentType.RESOLUTION;
                break;
            case "SENTENCE":
                this.judgmentType = JudgmentType.SENTENCE;
            case "REGULATION":
                this.judgmentType = JudgmentType.REGULATION;
            case "REASONS":
                this.judgmentType = JudgmentType.REASONS;
                break;
        }
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public CourtType getCourtType() {
        return courtType;
    }

    public void setCourtType(String courtType) {
        switch (courtType){
            case "COMMON":
                this.courtType = CourtType.COMMON;
                break;
            case "SUPREME":
                this.courtType = CourtType.SUPREME;
                break;
            case "ADMINISTRATIVE":
                this.courtType = CourtType.ADMINISTRATIVE;
                break;
            case "CONSTITUTIONAL_TRIBUNAL":
                this.courtType = CourtType.CONSTITUTIONAL_TRIBUNAL;
                break;
            case "NATIONAL_APPEAL_CHAMBER":
                this.courtType = CourtType.NATIONAL_APPEAL_CHAMBER;
                break;
        }
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public ArrayList<Judge> getJudges() {
        return judges;
    }

    public void addJudge(Judge judge) {
        judges.add(judge);
    }

    public ArrayList<Regulation> getRegulations() {
        return referencedRegulations;
    }

    public void addRegulation(Regulation regulation) {
        this.referencedRegulations.add(regulation);
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
