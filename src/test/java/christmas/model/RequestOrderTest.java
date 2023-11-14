package christmas.model;

import christmas.constant.ErrorDetail;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Java6Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RequestOrderTest {

    @DisplayName("유효한 입력 메뉴,수량 split 검사")
    @Test
    void createValidateOrders() {
        RequestOrder requestOrder = new RequestOrder("해산물파스타-2, 레드와인-1, 초코케이크-1, 타파스-1");
        Map<String, Integer> splitOrders = requestOrder.splitOrders("해산물파스타-2, 레드와인-1, 초코케이크-1, 타파스-1");

        assertEquals(2, splitOrders.get("해산물파스타"));
        assertEquals(1, splitOrders.get("레드와인"));
        assertEquals(1, splitOrders.get("초코케이크"));
        assertEquals(1, splitOrders.get("타파스"));
    }

    @DisplayName("형식이 잘못된 입력 예외 처리")
    @Test
    void createInvalidateOrders() {
        assertThatThrownBy(() -> new RequestOrder("2-해산물파스타, 레드와인-1, 초코케이크-1, 타파스-1"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new RequestOrder("해산물파스타-"))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("중복된 메뉴 입력 예외 처리")
    @Test
    void createDuplicateOrders() {
        assertThatThrownBy(() -> new RequestOrder("해산물파스타-2, 레드와인-1, 초코케이크-1, 타파스-1, 타파스-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorDetail.DUPLICATE_ERROR.getMessage());
    }
}
