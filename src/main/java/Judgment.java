import java.util.ArrayList;

public class Judgment {
    private int signature;
    private String date;
    private CourtType courtType;
    private String reason;
    private ArrayList<JudgeWithRoles> judgeWithRoles = new ArrayList<>();


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
            //CourtType.COMMON.increaseCommon();
        }else if (courtType.equals("SUPREME")){
            this.courtType = CourtType.SUPREME;
            //CourtType.SUPREME.increaseSupreme();
        }else if (courtType.equals("ADMINISTRATIVE")){
            this.courtType = CourtType.ADMINISTRATIVE;
            //CourtType.ADMINISTRATIVE.increaseAdministrative();
        }else if (courtType.equals("CONSTITUTIONAL_TRIBUNAL")){
            this.courtType = CourtType.CONSTITUTIONAL_TRIBUNAL;
            //CourtType.CONSTITUTIONAL_TRIBUNAL.increaseConstitutional();
        }else if (courtType.equals("NATIONAL_APPEAL_CHAMBER")){
            this.courtType = CourtType.NATIONAL_APPEAL_CHAMBER;
            //CourtType.NATIONAL_APPEAL_CHAMBER.increaseNational();
        }
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ArrayList<JudgeWithRoles> getJudgeWithRoles() {
        return judgeWithRoles;
    }

    public void addJudge(JudgeWithRoles judgeWithRoles) {
        this.judgeWithRoles.add(judgeWithRoles);
    }

    public Month getMonth(){
        int numberOfMonth = Integer.parseInt(getDate().substring(5,6));
        switch (numberOfMonth){
            case 1:
                return Month.JANUARY;
            case 2:
                return Month.FEBRUARY;
            case 3:
                return Month.MARCH;
            case 4:
                return Month.APRIL;
            case 5:
                return Month.MAY;
            case 6:
                return Month.JUNE;
            case 7:
                return Month.JULY;
            case 8:
                return Month.AUGUST;
            case 9:
                return Month.SEPTEMBER;
            case 10:
                return Month.OCTOBER;
            case 11:
                return Month.NOVEMBER;
            case 12:
                return Month.DECEMBER;
        }
        return Month.JANUARY;
    }


    @Override
    public String toString(){
        return "dziala";
    }
}
