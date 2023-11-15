package christmas.model.promotionHandler;

import christmas.constant.Menu;

import java.time.LocalDate;
import java.util.Map;

import static christmas.constant.DateValue.PROMOTION_MONTH;
import static christmas.constant.DateValue.PROMOTION_YEAR;
import static christmas.constant.PromotionDiscount.WEEK_DISCOUNT;

public class DayOfWeek {
    // 평일 프로모션
    public static int dayOfWeekPromotion(int day, Map<String, Integer> orders) {
        if (validateDayOfWeek(day)) {
            return dayOfWeekDiscountAmount(orders);
        }
        return 0;
    }

    // 평일인지 확인
    private static boolean validateDayOfWeek(int day) {
        LocalDate date = LocalDate.of(PROMOTION_YEAR.getDay(), PROMOTION_MONTH.getDay(), day);
        java.time.DayOfWeek dayOfWeek = date.getDayOfWeek();

        return (dayOfWeek != java.time.DayOfWeek.FRIDAY) && (dayOfWeek != java.time.DayOfWeek.SATURDAY);
    }

    // 디저트에 해당하면 할인 적용
    private static int dayOfWeekDiscountAmount(Map<String, Integer> orders) {
        int discountAmount = 0;

        for (Map.Entry<String, Integer> order : orders.entrySet()) {
            String menuName = order.getKey();
            Integer quantity = order.getValue();

            discountAmount += checkDessertAndDiscount(menuName, quantity);

        }
        return discountAmount;
    }

    private static int checkDessertAndDiscount(String menuName, Integer quantity) {
        Menu.MenuCategory category = Menu.getCategory(menuName);

        if (category.isDessert()) {
            return quantity * WEEK_DISCOUNT.getAmount();
        }
        return 0;
    }

}
