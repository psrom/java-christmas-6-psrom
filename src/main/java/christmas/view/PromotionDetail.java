package christmas.view;

import christmas.constant.Menu;
import christmas.model.promotionHandler.*;

import java.util.Map;

import static christmas.constant.PromotionDiscount.*;

public class PromotionDetail {
    private static final String NO_PROMOTION = "없음";

    public int printPromotions(int date, Map<String, Integer> orders, int amountBeforeDiscount) {
        int totalDiscount = 0;
        int champagneNumber = printChampagne(amountBeforeDiscount);

        boolean checkOrder = checkOrderAmount(amountBeforeDiscount);
        totalDiscount += printChristmasEvent(date, checkOrder);
        totalDiscount += printDayOfWeekPromotion(date, orders, checkOrder);
        totalDiscount += printDayOfWeekendPromotion(date, orders, checkOrder);
        totalDiscount += printSpecialPromotion(date, checkOrder);
        totalDiscount += printChampagnePrice(champagneNumber, checkOrder);
        printTotalPromotion(totalDiscount, checkOrder);

        return totalDiscount;
    }

    public void printBadgePromotion(int totalDiscountAmount) {
        System.out.println();
        System.out.println(OutputMessage.BADGE_EVENT.getMessage());
        System.out.println(Badge.badgePromotion(totalDiscountAmount));
    }

    private boolean checkOrderAmount(int orderAmount) {
        System.out.println(OutputMessage.PROMOTION_DETAIL.getMessage());
        if (orderAmount < MINIMUM_AMOUNT.getAmount()) {
            System.out.println(NO_PROMOTION);
            return false;
        }
        return true;
    }

    private int printChampagne(int amountBeforeDiscount) {
        System.out.println(OutputMessage.GIFT.getMessage());
        int champagne = Champagne.champagnePromotion(amountBeforeDiscount);
        if (champagne == NONE.getAmount()) {
            System.out.println(NO_PROMOTION);
            System.out.println();
            return NONE.getAmount();
        }
        System.out.println(formatChampagne(champagne));
        System.out.println();
        return champagne;
    }

    private int printChristmasEvent(int date, boolean checkOrder) {
        if (checkOrder) {
            int amount = Christmas.christmasPromotion(date);
            String formattedAmount = formatChristmasPromotion(amount);
            System.out.println(OutputMessage.CHRISTMAS_EVENT.getMessage() + formattedAmount);
            return amount;
        }
        return NONE.getAmount();
    }

    private int printDayOfWeekPromotion(int date, Map<String, Integer> orders, boolean checkOrder) {
        int amount = DayOfWeek.dayOfWeekPromotion(date, orders);
        if (amount > NONE.getAmount() && checkOrder) {
            String formattedAmount = formatTotalPrice(amount);
            System.out.println(OutputMessage.DAY_OF_WEEK_EVENT.getMessage() + formattedAmount);
            return amount;
        }
        return NONE.getAmount();
    }

    private int printDayOfWeekendPromotion(int date, Map<String, Integer> orders, boolean checkOrder) {
        int amount = DayOfWeekend.dayOfWeekendPromotion(date, orders);
        if (amount > NONE.getAmount() && checkOrder) {
            String formattedAmount = formatTotalPrice(amount);
            System.out.println(OutputMessage.DAY_OF_WEEKEND_EVENT.getMessage() + formattedAmount);
            return amount;
        }
        return NONE.getAmount();
    }

    private int printSpecialPromotion(int date, boolean checkOrder) {
        if (SpecialDay.specialPromotion(date) && checkOrder) {
            System.out.println(OutputMessage.SPECIAL_EVENT.getMessage());
            return SPECIAL_DISCOUNT.getAmount();
        }
        return NONE.getAmount();
    }

    private int printChampagnePrice(int countOfChampagne, boolean checkOrder) {
        if (checkOrder) {
            int price = countOfChampagne * Menu.음료.샴페인.getPrice();
            System.out.println(OutputMessage.GIFT_EVENT.getMessage() + formatTotalPrice(price));
            return price;
        }
        return NONE.getAmount();
    }

    private void printTotalPromotion(int totalAmount, boolean checkOrder) {
        System.out.println();
        System.out.println(OutputMessage.TOTAL_DISCOUNT_AMOUNT.getMessage());
        if (checkOrder && totalAmount != NONE.getAmount()) {
            System.out.print("-");
        } System.out.println(formatTotalPrice(totalAmount));
    }

    private static String formatTotalPrice(int price) {
        return String.format("%,d원", price);
    }

    private static String formatChampagne(int count) {
        return String.format("샴페인 %d개", count);
    }

    public static String formatChristmasPromotion(int amount) {
        return formatTotalPrice(amount);
    }

}
