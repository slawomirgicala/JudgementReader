public enum JudgeRole {
    PRESIDING_JUDGE,
    REPORTING_JUDGE,
    REASONS_FOR_JUDGMENT_AUTHOR;

    @Override
    public String toString(){
        switch (this){

            case PRESIDING_JUDGE:
                return "przewodniczacy skladu sedziowskiego";
            case REPORTING_JUDGE:
                return "sedzia sprawozdawca";
            case REASONS_FOR_JUDGMENT_AUTHOR:
                return "autor uzasadnienia";
        }
        return "";
    }
}
