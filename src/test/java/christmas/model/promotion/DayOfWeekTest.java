package christmas.model.promotion;

import christmas.model.promotionHandler.DayOfWeek;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static christmas.constant.PromotionDiscount.WEEK_DISCOUNT;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DayOfWeekTest {
    private Map<String, Integer> orders;

    @BeforeEach
    void SetUp() {
        orders = new HashMap<>();
    }

    @DisplayName("주중 이벤트 - 일요일부터 목요일까지")
    @Test
    void testDayOfWeekEvent_SundayToThursday() {
        orders.put("초코케이크", 1);

        for (int i = 3; i < 8; i++) {
            int result = DayOfWeek.dayOfWeekPromotion(i, orders);
            assertEquals(WEEK_DISCOUNT.getAmount(), result);
        }

    }

}
