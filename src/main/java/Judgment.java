import java.util.ArrayList;

public class Judgment {
    private int signature;
    private String date;
    private CourtType courtType;
    private String uzasadnienie;
    private ArrayList<Judge> judges = new ArrayList<Judge>();


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
        if (courtType.equals("COMMON")){
            this.courtType = CourtType.COMMON;
        }else if (courtType.equals("SUPREME")){
            this.courtType = CourtType.SUPREME;
        }else if (courtType.equals("ADMINISTRATIVE")){
            this.courtType = CourtType.ADMINISTRATIVE;
        }else if (courtType.equals("CONSTITUTIONAL_TRIBUNAL")){
            this.courtType = CourtType.CONSTITUTIONAL_TRIBUNAL;
        }else if (courtType.equals("NATIONAL_APPEAL_CHAMBER")){
            this.courtType = CourtType.NATIONAL_APPEAL_CHAMBER;
        }
    }

    public String getUzasadnienie() {
        return uzasadnienie;
    }

    public void setUzasadnienie(String uzasadnienie) {
        this.uzasadnienie = uzasadnienie;
    }

    public ArrayList<Judge> getJudges() {
        return judges;
    }

    public void addJudge(Judge judge) {
        this.judges.add(judge);
    }
}
