package christmas.model.promotion;

import christmas.model.promotionHandler.Badge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BadgeTest {
    @DisplayName("배지 증정 이벤트")
    @ParameterizedTest
    @MethodSource("badgeTestCases")
    void testBadgeGift(int amount, String expectedBadge) {
        String actualBadge = Badge.badgePromotion(amount);
        assertEquals(expectedBadge, actualBadge);
    }

    static Stream<Arguments> badgeTestCases() {
        return Stream.of(
                Arguments.of(5_000, "별"),
                Arguments.of(10_000, "트리"),
                Arguments.of(20_000, "산타"),
                Arguments.of(2_000, "없음")
        );
    }
}
