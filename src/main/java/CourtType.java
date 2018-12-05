public enum CourtType {
    COMMON,
    SUPREME,
    ADMINISTRATIVE,
    CONSTITUTIONAL_TRIBUNAL,
    NATIONAL_APPEAL_CHAMBER;

    @Override
    public String toString(){
        switch (this){
            case COMMON:
                return "Sad powszechny";
            case SUPREME:
                return "Sad Najwyzszy";
            case ADMINISTRATIVE:
                return "Sad administracyjny";
            case CONSTITUTIONAL_TRIBUNAL:
                return "Trybunal Konstytucyjny";
            case NATIONAL_APPEAL_CHAMBER:
                return "Krajowa Izba Odwolawcza";
        }
        return "";
    }
}
