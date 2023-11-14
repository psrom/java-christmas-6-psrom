package christmas.view;

import christmas.constant.Menu;
import christmas.model.RequestOrder;

import java.util.Map;

import static christmas.model.BillCalculator.totalAmount;

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

    public void printEventPreviewMessage() {
        System.out.println(OutputMessage.PREVIEW_MESSAGE.getMessage());
        System.out.println();
    }

    public void printBeforeDiscount(Map<String, Integer> orders) {
        int totalAmount = totalAmount(orders);
        System.out.println(OutputMessage.BEFORE_DISCOUNT.getMessage());
        System.out.println(formatTotalPrice(totalAmount));
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
