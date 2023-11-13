package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.model.RequestReservation;

import static christmas.constant.ErrorDetail.errorPrefix;
import static christmas.constant.MenuPrinter.printMenu;

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

    public RequestReservation requestReservation() {

        System.out.println(OutputMessage.REQUEST_ORDER.getMessage());
        return null;
    }

    private void printError(Exception e) {
        System.out.println(errorPrefix + e.getMessage());
    }
}

