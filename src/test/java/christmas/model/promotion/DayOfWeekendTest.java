package christmas.model.promotion;

import christmas.model.promotionHandler.DayOfWeek;
import christmas.model.promotionHandler.DayOfWeekend;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static christmas.constant.PromotionDiscount.WEEK_DISCOUNT;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DayOfWeekendTest {

    private Map<String, Integer> orders;

    @DisplayName("주말 이벤트 - 금요일, 토요일")
    @Test
    void testDayOfWeekendEvent() {
        orders = new HashMap<>();
        orders.put("티본스테이크", 1);

        for (int i = 1; i < 3; i++) {
            int result = DayOfWeekend.dayOfWeekendPromotion(i, orders);
            assertEquals(WEEK_DISCOUNT.getAmount(), result);
        }
    }
}
