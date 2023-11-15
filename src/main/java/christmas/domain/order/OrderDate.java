package christmas.domain.order;

import christmas.util.Parser;

import java.time.LocalDate;

import static christmas.util.ChristmasEventException.NOT_VALID_DATE;

public class OrderDate {

    public final static int YEAR = 2023;
    public final static int MONTH = 12;
    private final static int MIN_VALID_DATE = 1;
    private final static int MAX_VALID_DATE = 31;
    private final static String EMPTY = "";

    private final LocalDate date;

    private OrderDate(String date) {
        validate(date);
        this.date = LocalDate.of(YEAR, MONTH, Parser.stringToInt(date));
    }

    public static OrderDate create(String date) {
        return new OrderDate(date);
    }

    private void validate(String date) {
        validateNull(date);
        validateInteger(date);
        if (isNotValidDate(Parser.stringToInt(date))) {
            throw NOT_VALID_DATE.create();
        }
    }

    private void validateNull(String input) {
        if (input == null) {
            throw NOT_VALID_DATE.create();
        }
    }

    private void validateInteger(String input) {
        if (isNotInteger(input) || isEmpty(input)) {
            throw NOT_VALID_DATE.create();
        }
    }

    private boolean isNotInteger(String input) {
        return !input.matches("^[\\d]*$");
    }

    private boolean isEmpty(String input) {
        return input.equals(EMPTY);
    }

    private boolean isNotValidDate(int date) {
        return !(MIN_VALID_DATE <= date && date <= MAX_VALID_DATE);
    }

    public LocalDate getDate() {
        return date;
    }
}
