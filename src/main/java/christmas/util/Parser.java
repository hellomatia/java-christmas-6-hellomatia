package christmas.util;

import java.util.Arrays;
import java.util.List;

import static christmas.util.ChristmasEventException.INPUT_ONLY_NUMBER;

public class Parser {

    private final static String EMPTY = "";
    private final static String LIST_DELIMITER = ",";

    private Parser() {
    }

    public static List<String> stringToList(String input) {
        return Arrays.stream(input.split(LIST_DELIMITER))
                .toList();
    }

    public static int stringToInt(String input) {
        validateNull(input);
        validateInteger(input);
        return Integer.parseInt(input);
    }

    private static void validateNull(String input) {
        if (input == null) {
            throw INPUT_ONLY_NUMBER.create();
        }
    }

    private static void validateInteger(final String input) {
        if (isNotInteger(input) || isEmpty(input)) {
            throw INPUT_ONLY_NUMBER.create();
        }
    }

    private static boolean isNotInteger(final String input) {
        return !input.matches("^[\\d]*$");
    }

    private static boolean isEmpty(final String input) {
        return input.equals(EMPTY);
    }
}
