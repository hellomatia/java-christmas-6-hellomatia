package christmas.domain.calculator;

import christmas.domain.event.ChristmasEvents;
import christmas.domain.order.Menu;
import christmas.domain.order.MenuCategory;
import christmas.domain.order.Orders;

import java.util.Arrays;
import java.util.function.Function;

import static christmas.util.ChristmasEventException.NOT_FOUND;

public enum ChristmasEventDiscountCalculator {

    BONUS_GIFT_EVENT_CALCULATOR(
            ChristmasEvents.BONUS_GIFT_EVENT,
            orders -> Menu.CHAMPAGNE.getPrice()
    ),
    SPECIAL_EVENT_CALCULATOR(
            ChristmasEvents.SPECIAL_EVENT,
            orders -> 1_000
    ),
    CHRISTMAS_D_DAY_EVENT_CALCULATOR(
            ChristmasEvents.CHRISTMAS_D_DAY_EVENT,
            orders -> (orders.getOrderDate().getDayOfMonth() - 1) * 100 + 1_000
    ),
    WEEKDAY_EVENT_CALCULATOR(
            ChristmasEvents.WEEKDAY_EVENT,
            orders -> orders.getOrders()
                    .stream()
                    .filter(order -> order.getMenu().getCategory() == MenuCategory.DESSERT)
                    .mapToInt(order -> order.getMenuCount().getCount() * 2_023)
                    .sum()
    ),
    WEEKEND_EVENT_CALCULATOR(
            ChristmasEvents.WEEKEND_EVENT,
            orders -> orders.getOrders()
                    .stream()
                    .filter(order -> order.getMenu().getCategory() == MenuCategory.MAIN)
                    .mapToInt(order -> order.getMenuCount().getCount() * 2_023)
                    .sum()
    );

    private final ChristmasEvents event;
    private final Function<Orders, Integer> expression;

    ChristmasEventDiscountCalculator(ChristmasEvents event, Function<Orders, Integer> expression) {
        this.event = event;
        this.expression = expression;
    }

    public static ChristmasEventDiscountCalculator from(ChristmasEvents christmasEvent) {
        return Arrays.stream(values())
                .filter(it -> it.event == christmasEvent)
                .findFirst()
                .orElseThrow(NOT_FOUND::create);
    }

    public int calculate(Orders orders) {
        return expression.apply(orders);
    }
}
