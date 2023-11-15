package christmas.model.promotionHandler;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static christmas.constant.DateValue.PROMOTION_MONTH;
import static christmas.constant.DateValue.PROMOTION_YEAR;

public class DayOfWeekend {
    // 주말 프로모션
    public static boolean dayOfWeekendPromotion(int day) {
        LocalDate date = LocalDate.of(PROMOTION_YEAR.getDay(), PROMOTION_MONTH.getDay(), day);
        java.time.DayOfWeek dayOfWeekend = date.getDayOfWeek();

        return (dayOfWeekend == java.time.DayOfWeek.FRIDAY) || (dayOfWeekend == DayOfWeek.SATURDAY);
    }

}
