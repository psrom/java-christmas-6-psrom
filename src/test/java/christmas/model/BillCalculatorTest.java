package christmas.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BillCalculatorTest {

    private Map<String, Integer> orders;

    @DisplayName("할인 전 음식 금액 총액 확인")
    @Test
    void createValidateCalculator() {
        orders = new HashMap<>();
        orders.put("양송이수프", 2);
        orders.put("티본스테이크", 1);
        orders.put("해산물파스타", 1);
        orders.put("아이스크림", 3);
        orders.put("제로콜라", 2);


        assertEquals(123000, BillCalculator.totalAmount(orders));

    }
}