package christmas.model;

import static christmas.constant.ErrorDetail.DATE_ERROR;

public class RequestReservation {
    private final Integer date;

    public RequestReservation(String date) {
        this.date = convertAndValidate(date);
    }

    private Integer convertAndValidate(String date) {
        Integer parsedDate = convertType(date);
        validate(parsedDate);
        return parsedDate;
    }

    private Integer convertType(String date) {
        try {
            return Integer.parseInt(date);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(DATE_ERROR);
        }
    }

    private void validate(Integer date) {
        if (date < 1 || date > 31) {
            throw new IllegalArgumentException(DATE_ERROR);
        }
    }

}
