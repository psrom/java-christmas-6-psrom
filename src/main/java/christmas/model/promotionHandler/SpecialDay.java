package christmas.model.promotionHandler;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static christmas.constant.DateValue.*;

public class SpecialDay {
    // 특별 프로모션
    public static boolean specialPromotion(int day) {
        LocalDate date = LocalDate.of(PROMOTION_YEAR.getDay(), PROMOTION_MONTH.getDay(), day);
        java.time.DayOfWeek dayOfWeek = date.getDayOfWeek();

        return (dayOfWeek == DayOfWeek.SUNDAY) || (day == CHRISTMAS_DAY.getDay());
    }
}
