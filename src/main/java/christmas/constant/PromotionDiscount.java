package christmas.constant;

public enum PromotionDiscount {
    WEEK_DISCOUNT(2023),
    SPECIAL_DISCOUNT(1000);

    private final int amount;

    PromotionDiscount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

}
