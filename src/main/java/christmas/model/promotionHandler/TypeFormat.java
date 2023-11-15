package christmas.model.promotionHandler;

public class TypeFormat {

    public static String formatChristmasPromotion(int amount) {
        return formatTotalPrice(amount);
    }

    private static String formatTotalPrice(int amount) {
        return String.format("%,d원", amount);
    }

}
