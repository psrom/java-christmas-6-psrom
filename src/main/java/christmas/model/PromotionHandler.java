package christmas.model;

public class PromotionHandler {
    private static final Integer CHAMPAGNE_GIFT_AMOUNT = 120_000;
    private static final String GIFT = "샴페인 %d개";
    private static final String NO_GIFT = "없음";
    public static String champagneEvent(int amountBeforeDiscount) {
        int champagneCount = amountBeforeDiscount / CHAMPAGNE_GIFT_AMOUNT;

        if (champagneCount == 0) {
            return NO_GIFT;
        }
        return String.format(GIFT, champagneCount);
    }
}
