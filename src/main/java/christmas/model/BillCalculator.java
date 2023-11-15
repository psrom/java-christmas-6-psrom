package christmas.model;

import christmas.constant.Menu;

import java.util.Map;

public class BillCalculator {
    private static final int MINIMUM_AMOUNT = 10_000;
    private static final String MINIMUM_ALERT_MESSAGE = "❗[주의사항] 만원 미만 주문시 상기 이벤트 혜택을 모두 받을 수 없습니다.";

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

    public static void alertMinimumBill(int totalAmount) {
        if (totalAmount < MINIMUM_AMOUNT) {
            System.out.println();
            System.out.println(MINIMUM_ALERT_MESSAGE);
        }
    }

}
