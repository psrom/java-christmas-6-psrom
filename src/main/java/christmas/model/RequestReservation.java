package christmas.model;

public class RequestReservation {
    private final String ERROR_MESSAGE = "유효하지 않은 날짜입니다. 다시 입력해 주세요.\n";
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
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    private void validate(Integer date) {
        if (date < 1 || date > 31) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

}
