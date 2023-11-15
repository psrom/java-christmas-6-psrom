package christmas.model.promotionHandler;

import static christmas.constant.DateValue.CHRISTMAS_DAY;
import static christmas.constant.PromotionDiscount.NONE;
import static christmas.constant.PromotionDiscount.SPECIAL_DISCOUNT;

public class Christmas {
    // 할인 프로모션 - 크리스마스 디데이
    public static int christmasPromotion(int date) {
        if (date <= CHRISTMAS_DAY.getDay()) {
            return SPECIAL_DISCOUNT.getAmount() + 100 * (date - 1);
        }
        return NONE.getAmount();
    }
}
