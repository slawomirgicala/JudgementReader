import java.util.Objects;

public class Regulation {
    private String journalTitle;

    @Override
    public int hashCode(){
        return Objects.hash(journalTitle);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Regulation)) return false;
        Regulation that = (Regulation) o;
        return journalTitle.equals(that.journalTitle);
    }

    public String getJournalTitle() {
        return journalTitle;
    }

    public void setJournalTitle(String journalTitle) {
        this.journalTitle = journalTitle;
    }


    @Override
    public String toString(){
        return journalTitle;
    }
}
