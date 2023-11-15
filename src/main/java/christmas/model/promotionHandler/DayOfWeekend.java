package christmas.model.promotionHandler;

import christmas.constant.Menu;

import java.time.LocalDate;
import java.util.Map;

import static christmas.constant.DateValue.PROMOTION_MONTH;
import static christmas.constant.DateValue.PROMOTION_YEAR;
import static christmas.constant.PromotionDiscount.WEEK_DISCOUNT;

public class DayOfWeekend {
    // 주말 프로모션
    public static int dayOfWeekendPromotion(int day, Map<String, Integer> orders) {
        if (validateDayOfWeekend(day)) {
            return dayOfWeekendDiscountAmount(orders);
        }
        return 0;
    }

    // 주말인지 확인
    private static boolean validateDayOfWeekend(int day) {
        LocalDate date = LocalDate.of(PROMOTION_YEAR.getDay(), PROMOTION_MONTH.getDay(), day);
        java.time.DayOfWeek dayOfWeek = date.getDayOfWeek();

        return (dayOfWeek == java.time.DayOfWeek.FRIDAY) || (dayOfWeek == java.time.DayOfWeek.SATURDAY);
    }

    // 메인 메뉴에 해당하면 할인 적용
    private static int dayOfWeekendDiscountAmount(Map<String, Integer> orders) {
        int discountAmount = 0;

        for (Map.Entry<String, Integer> order : orders.entrySet()) {
            String menuName = order.getKey();
            Integer quantity = order.getValue();

            discountAmount += checkMainDishAndDiscount(menuName, quantity);

        }
        return discountAmount;
    }

    private static int checkMainDishAndDiscount(String menuName, Integer quantity) {
        Menu.MenuCategory category = Menu.getCategory(menuName);

        if (category.isMainDish()) {
            return quantity * WEEK_DISCOUNT.getAmount();
        }
        return 0;
    }

}
