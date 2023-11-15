package christmas.util;

public enum ChristmasEventException {

    NOT_VALID_DATE("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    NOT_VALID_ORDER("유효하지 않은 주문입니다. 다시 입력해 주세요."),
    INPUT_ONLY_NUMBER("유효하지 않은 숫자입니다. 다시 입력해주세요"),
    NOT_FOUND("값을 찾을 수 없습니다.");

    private final static String ERROR = "[ERROR] ";
    private final String message;

    ChristmasEventException(String message) {
        this.message = message;
    }

    public IllegalArgumentException create() {
        return new IllegalArgumentException(ERROR + message);
    }
}
