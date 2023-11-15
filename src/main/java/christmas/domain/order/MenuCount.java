package christmas.domain.order;

import static christmas.util.ChristmasEventException.NOT_VALID_ORDER;

public class MenuCount {

    private final static int MIN_MENU_COUNT = 1;
    private final static int MAX_MENU_COUNT = 20;

    private final int count;

    private MenuCount(int count) {
        this.count = count;
        validate();
    }

    public static MenuCount create(int count) {
        return new MenuCount(count);
    }

    private void validate() {
        if (isNotValidCount()) {
            throw NOT_VALID_ORDER.create();
        }
    }

    private boolean isNotValidCount() {
        return !(MIN_MENU_COUNT <= count && count <= MAX_MENU_COUNT);
    }

    public int getCount() {
        return count;
    }
}
