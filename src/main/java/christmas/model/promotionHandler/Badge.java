package christmas.model.promotionHandler;

public class Badge {
    public enum Badges {
        STAR(5_000, "별"),
        TREE(10_000, "트리"),
        SANTA(20_000, "산타"),
        NONE(0, "없음");


        private final int discountAmount;
        private final String badgeName;

        Badges(int discountAmount, String badgeName) {
            this.discountAmount = discountAmount;
            this.badgeName = badgeName;
        }

        public int getDiscountAmount() {
            return discountAmount;
        }

        public String getBadgeName() {
            return badgeName;
        }
    }

    public static String badgePromotion(int totalDiscountAmount) {
        if (totalDiscountAmount >= Badges.SANTA.getDiscountAmount()) {
            return Badges.SANTA.getBadgeName();
        } else if (totalDiscountAmount >= Badges.TREE.getDiscountAmount()) {
            return Badges.TREE.getBadgeName();
        } else if (totalDiscountAmount >= Badges.STAR.getDiscountAmount()) {
            return Badges.STAR.getBadgeName();
        }
        return Badges.NONE.getBadgeName();
    }

}
