import java.util.ArrayList;

public class Judge {
    private String name;
    //private int numberOfJudgments;
    private ArrayList<JudgeRole> roles = new ArrayList<JudgeRole>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<JudgeRole> getRole() {
        return roles;
    }

    public void addRole(String role) {
        if (role.equals("PRESIDING_JUDGE")){
            this.roles.add(JudgeRole.PRESIDING_JUDGE);
        }else if (role.equals("REPORTING_JUDGE")){
            this.roles.add(JudgeRole.REPORTING_JUDGE);
        }else if (role.equals("REASONS_FOR_JUDGMENT_AUTHOR")){
            this.roles.add(JudgeRole.REASONS_FOR_JUDGMENT_AUTHOR);
        }
    }
}
