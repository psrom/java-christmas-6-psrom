package christmas.model.promotionHandler;

public class Champagne {
    private static final Integer CHAMPAGNE_GIFT_AMOUNT = 120_000;

    // 증정 프로모션 - 샴페인
    public static int champagnePromotion(int amountBeforeDiscount) {
        return amountBeforeDiscount / CHAMPAGNE_GIFT_AMOUNT;
    }
}
