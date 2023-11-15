package christmas.domain.order;

import christmas.dto.OrderDTO;
import christmas.util.Parser;

import java.util.StringTokenizer;

import static christmas.util.ChristmasEventException.NOT_VALID_ORDER;

public class Order {

    private final static String MENU_MENUCOUNT_DELIMITER = "-";
    private final static String EMPTY = "";

    private final Menu menu;
    private final MenuCount menuCount;

    private Order(Menu menu, MenuCount menuCount) {
        this.menu = menu;
        this.menuCount = menuCount;
    }

    public static Order create(String order) {
        validateNull(order);
        StringTokenizer st = new StringTokenizer(order, MENU_MENUCOUNT_DELIMITER);
        validate(st);
        Menu menu = Menu.from(st.nextToken());
        validate(st);
        String count = st.nextToken();
        validateNumber(count);
        MenuCount menuCount = MenuCount.create(Parser.stringToInt(count));
        return new Order(menu, menuCount);
    }

    private static void validate(StringTokenizer st) {
        if (!st.hasMoreTokens()) {
            throw NOT_VALID_ORDER.create();
        }
    }

    private static void validateNumber(String input) {
        validateNull(input);
        validateInteger(input);
    }

    private static void validateNull(String input) {
        if (input == null) {
            throw NOT_VALID_ORDER.create();
        }
    }

    private static void validateInteger(String input) {
        if (isNotInteger(input) || isEmpty(input)) {
            throw NOT_VALID_ORDER.create();
        }
    }

    private static boolean isNotInteger(String input) {
        return !input.matches("^[\\d]*$");
    }

    private static boolean isEmpty(String input) {
        return input.equals(EMPTY);
    }

    public Menu getMenu() {
        return menu;
    }

    public MenuCount getMenuCount() {
        return menuCount;
    }

    public int getOrderAmount() {
        return menu.getPrice() * menuCount.getCount();
    }

    public OrderDTO toDTO() {
        return new OrderDTO(menu.getName(), menuCount.getCount());
    }
}
