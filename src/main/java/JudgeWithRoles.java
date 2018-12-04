import java.util.ArrayList;

public class JudgeWithRoles extends Judge{
    //private int numberOfJudgments;
    private ArrayList<JudgeRole> roles = new ArrayList<>();

    public ArrayList<JudgeRole> getRole() {
        return roles;
    }

    public void addRole(String role) {

        switch (role){
            case "PRESIDING_JUDGE":
                this.roles.add(JudgeRole.PRESIDING_JUDGE);
                break;
            case "REPORTING_JUDGE":
                this.roles.add(JudgeRole.REPORTING_JUDGE);
                break;
            case "REASONS_FOR_JUDGMENT_AUTHOR":
                this.roles.add(JudgeRole.REASONS_FOR_JUDGMENT_AUTHOR);
                break;
        }
    }
}
