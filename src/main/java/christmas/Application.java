package christmas;

import christmas.constant.Menu;
import christmas.controller.PromotionController;

public class Application {
    public static void main(String[] args) {
        PromotionController promotionController = new PromotionController();

        promotionController.start();
    }
}
