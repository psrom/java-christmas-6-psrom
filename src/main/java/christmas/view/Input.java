package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.model.RequestOrder;
import christmas.model.RequestReservation;

import static christmas.constant.ErrorDetail.ERROR_PREFIX;

public class Input {

    public RequestReservation requestDate() {

        System.out.println(OutputMessage.REQUEST_DATE.getMessage());
        String date = Console.readLine();

        try {
            RequestReservation reservation = new RequestReservation(date);
            System.out.println();
            return reservation;
        } catch (IllegalArgumentException e) {
            printError(e);
            return requestDate();
        }
    }

    public RequestOrder requestOrder() {

        System.out.println(OutputMessage.REQUEST_ORDER.getMessage());
        String order = Console.readLine();

        try {
            RequestOrder requestOrder = new RequestOrder(order);
            System.out.println();
            return requestOrder;
        } catch (IllegalArgumentException e) {
            printError(e);
            return requestOrder();
        }
    }

    private void printError(Exception e) {
        System.out.println("\n" + ERROR_PREFIX + e.getMessage());
    }
}

