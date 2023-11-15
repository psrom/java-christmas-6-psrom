package christmas.model;

import christmas.constant.Menu;

import java.util.Map;

import static christmas.constant.ErrorDetail.*;

public class OrderValidator {
    private static Integer totalNumberOfMenu = 0;

    public static void resetTotalNumberOfMenu() {
        totalNumberOfMenu = 0;
    }

    public static Map<String, Integer> checkOrder(Map<String, Integer> splitOrders) {
        int numberOfBeverage = 0;

        for (Map.Entry<String, Integer> entry : splitOrders.entrySet()) {
            String menu = entry.getKey();
            Integer quantity = entry.getValue();

            checkMenuInConstant(menu);
            validateQuantity(quantity);

            totalNumberOfMenu += quantity;

            numberOfBeverage = countBeverage(menu, numberOfBeverage);

        }
        checkBeverageValidation(splitOrders, numberOfBeverage);
        return splitOrders;
    }

    // 입력 받은 값이 메뉴판에 있는지 확인
    private static void checkMenuInConstant(String menuName) {
        boolean isInAppetizer = containsInEnum(menuName, Menu.애피타이저.values());
        boolean isInMainMenu = containsInEnum(menuName, Menu.메인.values());
        boolean isInDessert = containsInEnum(menuName, Menu.디저트.values());
        boolean isInBeverage = containsInEnum(menuName, Menu.음료.values());

        boolean isInConstant = isInAppetizer || isInMainMenu || isInDessert || isInBeverage;

        if (!isInConstant) {
            throw new IllegalArgumentException(ORDER_ERROR.getMessage());
        }
    }

    // 주문 수량 확인
    private static void validateQuantity(Integer quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException(ORDER_ERROR.getMessage());
        }

        if (quantity > 20 || (totalNumberOfMenu + quantity) > 20) {
            throw new IllegalArgumentException(MAXIMUM_ORDER_ERROR.getMessage());
        }

    }

    private static int countBeverage(String menuName, int numberOfBeverage) {
        if (containsInEnum(menuName, Menu.음료.values())) {
            numberOfBeverage++;
        }
        return numberOfBeverage;
    }

    // 음료만 있는 경우 체크(입력 받은 메뉴 개수와 음료수에 포함되는 항목 개수 비교)
    private static void checkBeverageValidation(Map<String, Integer> splitOrders, int numberOfBeverage) {
        if (numberOfBeverage == splitOrders.size()) {
            throw new IllegalArgumentException(ONLY_BEVERAGE_ERROR.getMessage());
        }
    }

    private static boolean containsInEnum(String menuName, Enum<?>[] enumConstants) {
        for (Enum<?> constant : enumConstants) {
            if (constant.name().equals(menuName)) {
                return true;
            }
        }
        return false;
    }

}
