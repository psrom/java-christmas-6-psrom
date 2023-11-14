package christmas.model;

import christmas.constant.ErrorDetail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Java6Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderValidatorTest {

    private Map<String, Integer> orders;

    @BeforeEach
    void SetUp() {
        orders = new HashMap<>();
        OrderValidator.resetTotalNumberOfMenu();
    }

    @DisplayName("올바른 입력에 대한 유효성 테스트")
    @Test
    void createValidOrder() {
        orders.put("해산물파스타", 2);
        orders.put("레드와인", 18);

        Map<String, Integer> result = OrderValidator.checkOrder(orders);

        assertEquals(2, result.get("해산물파스타"));
        assertEquals(18, result.get("레드와인"));

    }

    @DisplayName("메뉴판에 없는 메뉴 입력시 예외 처리")
    @Test
    void createUnknownMenu() {
        orders.put("해산물파스타", 2);
        orders.put("깜빠뉴", 1);

        assertThatThrownBy(() -> OrderValidator.checkOrder(orders))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("한 메뉴의 수량이 20개가 넘을 때 예외 처리")
    @Test
    void createSingleQuantityMaximumError() {
        orders.put("해산물파스타", 21);

        assertThrowsIllegalArgumentException(ErrorDetail.MAXIMUM_ORDER_ERROR.getMessage());

    }

    @DisplayName("전체 주문 수량의 합이 20개가 넘을 때 예외 처리")
    @Test
    void createTotalQuantityMaximumError() {
        orders.put("해산물파스타", 10);
        orders.put("레드와인", 10);
        orders.put("초코케이크", 1);

        assertThrowsIllegalArgumentException(ErrorDetail.MAXIMUM_ORDER_ERROR.getMessage());

    }

    @DisplayName("음료 품목만 여러 개 주문한 경우 예외 처리")
    @Test
    void createOnlySeveralBeverage() {
        orders.put("레드와인", 1);
        orders.put("샴페인", 2);

        assertThrowsIllegalArgumentException(ErrorDetail.ONLY_BEVERAGE_ERROR.getMessage());

    }

    @DisplayName("음료 품목만 하나 주문한 경우 예외 처리")
    @Test
    void createOnlyBeverage() {
        orders.put("레드와인", 3);

        assertThrowsIllegalArgumentException(ErrorDetail.ONLY_BEVERAGE_ERROR.getMessage());

    }

    private void assertThrowsIllegalArgumentException(String message) {
        assertThatThrownBy(() -> OrderValidator.checkOrder(orders))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

}
