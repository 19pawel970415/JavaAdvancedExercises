package enums.ex1;

public enum Weekday {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;

    public boolean isWeekday() {
        return !(this == Weekday.SATURDAY || this == Weekday.SUNDAY);
    }

    public boolean isHoliday() {
        return !this.isWeekday() ? true : false;
    }

    public void whichIsGreater(Weekday weekday) {
        if (this.compareTo(weekday) < 0) {
            System.out.println("It is before " + weekday);
        } else if (this.compareTo(weekday) > 0) {
            System.out.println("It is after " + weekday);
        } else {
            System.out.println("It is the same day as " + weekday);
        }
    }
}
