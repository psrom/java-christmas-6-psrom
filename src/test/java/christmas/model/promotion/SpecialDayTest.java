package christmas.model.promotion;

import christmas.model.promotionHandler.SpecialDay;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpecialDayTest {
    @DisplayName("매주 일요일, 크리스마스 당일 이벤트")
    @ValueSource(ints = {3, 10, 17, 24, 25, 31})
    @ParameterizedTest
    void testSpecialDays(int day) {
        assertEquals(true, SpecialDay.specialPromotion(day));
    }
}
