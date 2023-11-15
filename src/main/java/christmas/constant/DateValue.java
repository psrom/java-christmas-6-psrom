package christmas.constant;

public enum DateValue {
    PROMOTION_YEAR(2023),
    PROMOTION_MONTH(12),
    CHRISTMAS_DAY(25);

    private final int day;

    DateValue(int day) {
        this.day = day;
    }

    public int getDay() {
        return day;
    }
}
