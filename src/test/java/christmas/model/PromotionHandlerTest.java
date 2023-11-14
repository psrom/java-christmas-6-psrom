package christmas.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PromotionHandlerTest {

    @DisplayName("12만원 이하일 때 샴페인 없음")
    @Test
    void testChampagneEvent_NoGift() {

        int amount = 100_000;
        String result = PromotionHandler.champagneEvent(amount);
        assertEquals("없음", result);

    }

    @DisplayName("12만원 이상일 때 샴페인 1개 증정")
    @Test
    void testChampagneEvent_WithGift() {

        int amount = 120_000;
        String result = PromotionHandler.champagneEvent(amount);
        assertEquals("샴페인 1개", result);

    }

    @DisplayName("24만원 이상일 때 샴페인 2개 증정")
    @Test
    void testChampagneEvent_WithTwoGifts() {

        int amount = 240_000;
        String result = PromotionHandler.champagneEvent(amount);
        assertEquals("샴페인 2개", result);

    }

}
