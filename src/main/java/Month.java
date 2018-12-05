public enum Month {
    JANUARY,
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER,
    DECEMBER;

    @Override
    public String toString(){
        switch (this){
            case JANUARY:
                return "styczen";
            case FEBRUARY:
                return "luty";
            case MARCH:
                return "marzec";
            case APRIL:
                return "kwiecien";
            case MAY:
                return "maj";
            case JUNE:
                return "czerwiec";
            case JULY:
                return "lipiec";
            case AUGUST:
                return "sierpien";
            case SEPTEMBER:
                return "wrzesien";
            case OCTOBER:
                return "pazdziernik";
            case NOVEMBER:
                return "listopad";
            case DECEMBER:
                return "grudzien";
        }
        return "";
    }

}
