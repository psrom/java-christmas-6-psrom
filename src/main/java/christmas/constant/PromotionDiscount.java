package christmas.constant;

public enum PromotionDiscount {
    WEEK_DISCOUNT(2_023),
    SPECIAL_DISCOUNT(1_000),
    NONE(0);

    private final int amount;

    PromotionDiscount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

}
