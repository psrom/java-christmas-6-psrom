package christmas.model;

import christmas.constant.Menu;

import java.util.Map;

import static christmas.constant.PromotionDiscount.MINIMUM_AMOUNT;
import static christmas.model.promotionHandler.Champagne.champagnePromotion;

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

    public static int expectedAmount(int totalAmount, int discountAmount) {
        int champagne = champagnePromotion(totalAmount);
        return totalAmount - discountAmount + Menu.음료.샴페인.getPrice() * champagne;
    }

}
