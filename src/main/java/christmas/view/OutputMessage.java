package christmas.view;

public enum OutputMessage {
    START_MESSAGE("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    REQUEST_DATE("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    REQUEST_ORDER("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)\n만원 이상 주문시 다양한 이벤트 혜택이 적용됩니다."),
    PREVIEW_MESSAGE("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    RECIPE("<주문 메뉴>"),
    BEFORE_DISCOUNT("<할인 전 총주문 금액>"),
    GIFT("<증정 메뉴>"),
    PROMOTION_DETAIL("<혜택 내역>"),
    CHRISTMAS_EVENT("크리스마스 디데이 할인: -"),
    DAY_OF_WEEK_EVENT("평일 할인: -"),
    DAY_OF_WEEKEND_EVENT("주말 할인: -");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public final String getMessage() {
        return message;
    }
}