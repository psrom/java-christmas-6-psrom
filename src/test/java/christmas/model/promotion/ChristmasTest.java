package christmas.model.promotion;

import christmas.model.promotionHandler.Christmas;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChristmasTest {
    @DisplayName("1 ~ 25일 크리스마스 이벤트")
    @Test
    void testChristmasEvent_inRange() {
        for (int i = 1; i <= 25; i++) {
            int expectedResult = 1000 + 100 * (i - 1);
            assertEquals(expectedResult, Christmas.christmasPromotion(i));
        }
    }
}
