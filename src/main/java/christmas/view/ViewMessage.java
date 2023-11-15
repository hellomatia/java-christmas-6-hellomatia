package christmas.view;

public enum ViewMessage {

    INPUT_DATE_OF_VISIT("%d월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    INPUT_ORDER_MENU("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),

    OUTPUT_START("안녕하세요! 우테코 식당 %d월 이벤트 플래너입니다."),
    OUTPUT_EVENT_INFORMATION("%d월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    OUTPUT_ORDER_MENU("<주문 메뉴>"),
    OUTPUT_MENU("%s %d개"),
    OUTPUT_ORDER_AMOUNT("<할인 전 총주문 금액>\n%s원"),
    OUTPUT_BONUS_GIFT("<증정 메뉴>"),
    OUTPUT_DISCOUNT_DETAIL_INFORMATION("<혜택 내역>"),
    OUTPUT_DISCOUNT_DETAIL("%s: -%s원"),
    OUTPUT_TOTAL_DISCOUNT_AMOUNT("<총혜택 금액>\n-%s원"),
    OUTPUT_TOTAL_DISCOUNT_AMOUNT_NOTHING("<총혜택 금액>\n0원"),
    OUTPUT_PAYMENT_AMOUNT("<할인 후 예상 결제 금액>\n%s원"),
    OUTPUT_EVENT_BADGE("<%d월 이벤트 배지>\n%s"),
    OUTPUT_NOTHING("없음");

    private final String message;

    ViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
