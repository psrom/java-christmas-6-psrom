package christmas.controller;

import christmas.model.BillCalculator;
import christmas.model.RequestOrder;
import christmas.model.RequestReservation;
import christmas.view.Input;
import christmas.view.Output;
import christmas.view.PromotionDetail;

import java.util.Map;

public class PromotionController {
    private RequestReservation requestReservation;
    private PromotionDetail promotionView;
    private Output outputView;
    private Input inputView;
    private int totalAmount;


    public PromotionController() {
        outputView = new Output();
        inputView = new Input();
        promotionView = new PromotionDetail();
    }

    public void start() {

        outputView.printStartMessage();
        requestReservation = inputView.requestDate();
        int chosenDate = requestReservation.getDate();

        outputView.printMenu();
        Map<String, Integer> validatedOrder = inputView.requestOrder().getValidatedOrder();

        outputView.printEventPreviewMessage(chosenDate);
        outputView.printRecipe(validatedOrder);

        totalAmount = BillCalculator.totalAmount(validatedOrder);
        outputView.printBeforeDiscount(totalAmount);

        promotionView.printPromotions(chosenDate, validatedOrder, totalAmount);

        BillCalculator.alertMinimumBill(totalAmount);

    }
}
