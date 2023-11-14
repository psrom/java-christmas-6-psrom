package christmas.model;

import christmas.constant.Menu;

import java.util.Map;

public class BillCalculator {
    public static int totalAmount(Map<String, Integer> orders) {
        int totalAmount = 0;

        for (Map.Entry<String, Integer> order : orders.entrySet()) {
            String menuName = order.getKey();
            int quantity = order.getValue();
            Menu.MenuCategory category = Menu.getCategory(menuName);

            int totalPrice = category.getPrice() * quantity;
            totalAmount += totalPrice;

        }

        return totalAmount;
    }
}
