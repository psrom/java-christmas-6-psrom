package christmas.model;

import christmas.constant.ErrorDetail;

public class RequestReservation {
    private final Integer date;

    public RequestReservation(String date) {
        this.date = convertAndValidate(date);
    }

    public Integer getDate() {
        return date;
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
            throw new IllegalArgumentException(ErrorDetail.DATE_ERROR.getMessage());
        }
    }

    private void validate(Integer date) {
        if (date < 1 || date > 31) {
            throw new IllegalArgumentException(ErrorDetail.DATE_ERROR.getMessage());
        }
    }

}
