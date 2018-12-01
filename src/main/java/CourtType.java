public enum CourtType {
    COMMON,
    SUPREME,
    ADMINISTRATIVE,
    CONSTITUTIONAL_TRIBUNAL,
    NATIONAL_APPEAL_CHAMBER;

    private static int numberOfCommon;
    public void increaseCommon(){
        numberOfCommon++;
    }

    private static int numberOfSupreme;
    public void increaseSupreme(){
        numberOfSupreme++;
    }

    private static int numberOfAdministrative;
    public void increaseAdministrative(){
        numberOfAdministrative++;
    }

    private static int numberOfConstitutional;
    public void increaseConstitutional(){
        numberOfConstitutional++;
    }

    private static int numberOfNational;
    public void increaseNational(){
        numberOfCommon++;
    }
}
