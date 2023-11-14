package christmas.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Java6Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RequestReservationTest {
    @DisplayName("식당 예상 방문 날짜 유효성 검사")
    @Test
    void validateReservation() {
        for (int i = 1; i <= 31; i++) {
            assertEquals(i, new RequestReservation(String.valueOf(i)).getDate());
        }
    }

    @DisplayName("1 ~ 31 범위의 숫자가 아닌 숫자 예외 처리")
    @ValueSource(strings = {"0", "-1", "100"})
    @ParameterizedTest
    void createOutOfRangeReservation(String input) {
        assertThatThrownBy(() -> new RequestReservation(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("기타 문자 입력 예외 처리")
    @ValueSource(strings = {" ", "abc", "1ab"})
    @ParameterizedTest
    void createInvalidateReservation(String input) {
        assertThatThrownBy(() -> new RequestReservation(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
