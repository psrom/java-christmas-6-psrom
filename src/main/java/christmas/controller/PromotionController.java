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


    public void start() {
        setupViews();
        printInitialMessages();
        processReservation();
    }

    private void setupViews() {
        outputView = new Output();
        inputView = new Input();
        promotionView = new PromotionDetail();
    }

    private void printInitialMessages() {
        outputView.printStartMessage();
        requestReservation = inputView.requestDate();
    }

    private void processReservation() {
        int chosenDate = requestReservation.getDate();
        Map<String, Integer> validatedOrder = getValidatedOrder();
        printEventPreview(chosenDate, validatedOrder);
        calculateAndPrintTotal(chosenDate, validatedOrder);
    }

    private Map<String, Integer> getValidatedOrder() {
        outputView.printMenu();
        return inputView.requestOrder().getValidatedOrder();
    }

    private void printEventPreview(int chosenDate, Map<String, Integer> validatedOrder) {
        outputView.printEventPreviewMessage(chosenDate);
        outputView.printRecipe(validatedOrder);
    }

    private void calculateAndPrintTotal(int chosenDate, Map<String, Integer> validatedOrder) {

        totalAmount = BillCalculator.totalAmount(validatedOrder);
        outputView.printBeforeDiscount(totalAmount);

        int totalDiscount = promotionView.printPromotions(chosenDate, validatedOrder, totalAmount);
        int totalBill = BillCalculator.expectedAmount(totalAmount, totalDiscount);
        outputView.printAfterDiscount(totalBill);
        promotionView.printBadgePromotion(totalDiscount);

        outputView.alertMinimumBill(totalAmount);

    }

}
