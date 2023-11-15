package christmas.model.promotionHandler;

import java.time.LocalDate;

import static christmas.constant.Promotion.PROMOTION_MONTH;
import static christmas.constant.Promotion.PROMOTION_YEAR;

public class DayOfWeek {
    public static boolean dayOfWeekPromotion(int day) {
        LocalDate date = LocalDate.of(PROMOTION_YEAR.getDay(), PROMOTION_MONTH.getDay(), day);
        java.time.DayOfWeek dayOfWeek = date.getDayOfWeek();

        return (dayOfWeek != java.time.DayOfWeek.FRIDAY) && (dayOfWeek != java.time.DayOfWeek.SATURDAY);
    }
}
