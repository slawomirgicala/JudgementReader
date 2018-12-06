import java.util.Objects;

public class Regulation {
    private String journalTitle;
    private int journalNo;
    private int journalYear;
    private int journalEntry;

    @Override
    public int hashCode(){
        return Objects.hash(journalTitle,journalNo, journalYear, journalEntry);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Regulation)) return false;
        Regulation that = (Regulation) o;
        return journalNo == that.journalNo && journalYear == that.journalYear && journalEntry == that.journalEntry;
    }

    public String getJournalTitle() {
        return journalTitle;
    }

    public void setJournalTitle(String journalTitle) {
        this.journalTitle = journalTitle;
    }

    public int getJournalNo() {
        return journalNo;
    }

    public void setJournalNo(int journalNo) {
        this.journalNo = journalNo;
    }

    public int getJournalYear() {
        return journalYear;
    }

    public void setJournalYear(int journalYear) {
        this.journalYear = journalYear;
    }

    public int getJournalEntry() {
        return journalEntry;
    }

    public void setJournalEntry(int journalEntry) {
        this.journalEntry = journalEntry;
    }

    @Override
    public String toString(){
        return journalTitle;
    }
}
