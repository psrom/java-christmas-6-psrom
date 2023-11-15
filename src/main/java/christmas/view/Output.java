package christmas.view;

import christmas.constant.Menu;
import christmas.model.promotionHandler.DayOfWeek;
import christmas.model.promotionHandler.TypeFormat;
import christmas.model.promotionHandler.Champagne;
import christmas.model.promotionHandler.Christmas;

import java.util.Map;

public class Output {
    public void printStartMessage() {
        System.out.println(OutputMessage.START_MESSAGE.getMessage());
    }

    public void printMenu() {
        printLine();
        printCategory("애피타이저", Menu.애피타이저.values());
        printCategory("메인", Menu.메인.values());
        printCategory("디저트", Menu.디저트.values());
        printCategory("음료", Menu.음료.values());
        printLine();
    }

    public void printRecipe(Map<String, Integer> orders) {
        System.out.println(OutputMessage.RECIPE.getMessage());
        for (Map.Entry<String, Integer> entry : orders.entrySet()) {
            String menu = entry.getKey();
            Integer quantity = entry.getValue();
            System.out.println(String.format("%s %d개", menu, quantity));
        }
        System.out.println();
    }

    public void printEventPreviewMessage(Integer date) {
        String previewMessage = String.format(OutputMessage.PREVIEW_MESSAGE.getMessage(), date);
        System.out.println(previewMessage);
        System.out.println();
    }

    public void printBeforeDiscount(int totalAmount) {
        System.out.println(OutputMessage.BEFORE_DISCOUNT.getMessage());
        System.out.println(formatTotalPrice(totalAmount));
        System.out.println();
    }

    public void printGift(int amountBeforeDiscount) {
        System.out.println(OutputMessage.GIFT.getMessage());
        System.out.println(Champagne.champagnePromotion(amountBeforeDiscount));
        System.out.println();
    }

    public void printChristmasEvent(int date) {
        System.out.println(OutputMessage.PROMOTION_DETAIL.getMessage());
        int amount = Christmas.christmasPromotion(date);
        String formattedAmount = TypeFormat.formatChristmasPromotion(amount);
        System.out.println(OutputMessage.CHRISTMAS_EVENT.getMessage() + formattedAmount);
    }

    public void printDayOfWeekPromotion(int date, Map<String, Integer> orders) {
        int amount = DayOfWeek.dayOfWeekPromotion(date, orders);
        if (amount > 0) {
            String formattedAmount = formatTotalPrice(amount);
            System.out.println(OutputMessage.DAY_OF_WEEK_EVENT.getMessage() + formattedAmount);
        }
    }

    private static void printCategory(String categoryName, Menu.MenuCategory[] menuItems) {
        System.out.println("<" + categoryName + ">");
        for (int i = 0; i <menuItems.length; i++) {
            System.out.print(menuItems[i] + formatPrice(menuItems[i].getPrice()));
            if (i < menuItems.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    private static String formatPrice(int price) {
        return String.format("(%,d)", price);
    }

    private static String formatTotalPrice(int price) {
        return String.format("%,d원", price);
    }

    private static void printLine() {
        for (int i = 0; i < 80; i++) {
            System.out.print("=");
        }
        System.out.println();
    }

}
