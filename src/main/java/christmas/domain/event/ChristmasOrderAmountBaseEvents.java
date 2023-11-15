package christmas.domain.event;

import christmas.domain.order.Orders;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public enum ChristmasOrderAmountBaseEvents {

    BONUS_GIFT_EVENT(ChristmasEvents.BONUS_GIFT_EVENT,
            orders -> !orders.getOrderDate().isBefore(ChristmasEvents.BONUS_GIFT_EVENT.getStartDate())
                    && orders.getOrderDate().isBefore(ChristmasEvents.BONUS_GIFT_EVENT.getEndDate())
                    && orders.getTotalOrderAmount() >= 120_000);

    private final ChristmasEvents event;
    private final Predicate<Orders> match;

    ChristmasOrderAmountBaseEvents(ChristmasEvents event, Predicate<Orders> match) {
        this.event = event;
        this.match = match;
    }

    public static List<ChristmasEvents> findRelevantEventsForOrder(Orders orders) {
        return Arrays.stream(values())
                .filter(it -> it.match.test(orders))
                .map(it -> it.event)
                .toList();
    }
}
