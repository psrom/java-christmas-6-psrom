package christmas.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BillCalculatorTest {

    private Map<String, Integer> orders;

    @DisplayName("할인 전 음식 금액 총액 테스트")
    @Test
    void createValidateCalculator() {
        orders = new HashMap<>();
        orders.put("양송이수프", 2);
        orders.put("티본스테이크", 1);
        orders.put("해산물파스타", 1);
        orders.put("아이스크림", 3);
        orders.put("제로콜라", 2);

        assertEquals(123_000, BillCalculator.totalAmount(orders));

    }

    @DisplayName("할인 후 예상 결제 금액 테스트")
    @Test
    void createExpectedAmountCalculator() {
        int result = BillCalculator.expectedAmount(120_000, 25_000);
        assertEquals(120_000, result);
    }
}