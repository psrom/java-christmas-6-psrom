package christmas.controller;

import christmas.constant.MenuPrinter;
import christmas.model.RequestReservation;
import christmas.view.Input;
import christmas.view.Output;

public class PromotionController {
    private RequestReservation requestReservation;
    private RequestReservation requestOrder;
    private Output outputView;
    private Input inputView;


    public PromotionController() {
        outputView = new Output();
        inputView = new Input();
    }

    public void start() {

        outputView.printStartMessage();
        requestReservation = inputView.requestDate();
        MenuPrinter.printMenu();
        requestOrder = inputView.requestReservation();

    }
}
