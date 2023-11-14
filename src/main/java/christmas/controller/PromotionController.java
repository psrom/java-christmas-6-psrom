package christmas.controller;

import christmas.model.BillCalculator;
import christmas.model.RequestOrder;
import christmas.model.RequestReservation;
import christmas.view.Input;
import christmas.view.Output;

import java.util.Map;

public class PromotionController {
    private RequestReservation requestReservation;
    private RequestOrder requestOrder;
    private Output outputView;
    private Input inputView;
    private int totalAmount;


    public PromotionController() {
        outputView = new Output();
        inputView = new Input();
    }

    public void start() {

        outputView.printStartMessage();
        requestReservation = inputView.requestDate();
        outputView.printMenu();
        Map<String, Integer> validatedOrder = inputView.requestOrder().getValidatedOrder();

        outputView.printEventPreviewMessage();
        outputView.printRecipe(validatedOrder);

        totalAmount = BillCalculator.totalAmount(validatedOrder);
        outputView.printBeforeDiscount(validatedOrder, totalAmount);

        outputView.printGift(totalAmount);

    }
}
