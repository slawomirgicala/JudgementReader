import java.util.ArrayList;

public class Judge {
    private String name;
    private ArrayList<JudgeRole> roles = new ArrayList<>();

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
