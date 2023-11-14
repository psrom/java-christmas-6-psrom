package christmas.constant;

public enum ErrorDetail {
    DATE_ERROR("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    ORDER_ERROR("유효하지 않은 주문입니다. 다시 입력해 주세요."),
    MAXIMUM_ORDER_ERROR("메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다. (e.g. 시저샐러드-1, 티본스테이크-1, 크리스마스파스타-1, 제로콜라-3, 아이스크림-1의 총개수는 7개)"),
    ONLY_BEVERAGE_ERROR("음료만 주문 시, 주문할 수 없습니다."),
    DUPLICATE_ERROR("중복된 메뉴가 있습니다. 메뉴는 한 번씩만 입력해 주세요.");

    public static final String ERROR_PREFIX = "[ERROR] ";
    private final String errorMessage;

    ErrorDetail(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public final String getMessage() {
        return errorMessage;
    }
}
