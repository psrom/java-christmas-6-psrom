package christmas.model;

public class PromotionHandler {
    private static final Integer CHAMPAGNE_GIFT_AMOUNT = 120_000;
    private static final String GIFT = "샴페인 %d개";
    private static final String NO_GIFT = "없음";
    private static final int CHRISTMAS_DATE = 25;
    public static String champagneEvent(int amountBeforeDiscount) {
        int champagneCount = amountBeforeDiscount / CHAMPAGNE_GIFT_AMOUNT;

        if (champagneCount == 0) {
            return NO_GIFT;
        }
        return String.format(GIFT, champagneCount);
    }

    public static int christmasEvent(int date) {
        if (date <= CHRISTMAS_DATE) {
            return 1_000 + 100 * (date - 1);
        } return 0;
    }

    public static String formatChristmasEvent(int amount) {
        return formatTotalPrice(amount);
    }

    private static String formatTotalPrice(int amount) {
        return String.format("%,d원", amount);
    }

}
