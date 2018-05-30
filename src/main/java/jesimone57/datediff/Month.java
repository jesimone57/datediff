package jesimone57.datediff;

public enum Month {

    JAN(31),
    FEB(28),
    MAR(31),
    APR(30),
    MAY(31),
    JUN(30),
    JUL(31),
    AUG(31),
    SEP(30),
    OCT(31),
    NOV(30),
    DEC(31);

    private int days;

    private Month(int days) {
        this.days = days;
    }

    // Helper method to return the number of days in any given month, accounting for leap year.
    public int getDays(boolean isLeapYear) {
        return this == Month.FEB && isLeapYear ? days + 1 : days;
    }

    // NOTE: index origin is 0 = JAN
    public static Month getMonth(int month) {
        Month[] months = Month.values();
        return months[month];
    }

}
