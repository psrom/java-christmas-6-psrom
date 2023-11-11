package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.model.RequestReservation;

public class Input {
    private static final String errorPrefix = "[ERROR] ";
    private static boolean startMessage = false;

    private void printError(Exception e) {
        System.out.println(errorPrefix + e.getMessage());
    }


    public RequestReservation requestDate() {

        System.out.println(OutputMessage.REQUEST_DATE.getMessage());
        String date = Console.readLine();

        try {
            RequestReservation reservation = new RequestReservation(date);
            return reservation;
        } catch (IllegalArgumentException e) {
            printError(e);
            return requestDate();
        }
    }
}

