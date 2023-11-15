package christmas.domain.event;

import christmas.domain.order.Orders;

import java.time.LocalDate;
import java.util.List;
import java.util.Arrays;
import java.util.function.Predicate;

public enum ChristmasDateBaseEvents {

    CHRISTMAS_D_DAY_EVENT(ChristmasEvents.CHRISTMAS_D_DAY_EVENT,
            date -> !date.isBefore(ChristmasEvents.CHRISTMAS_D_DAY_EVENT.getStartDate())
                    && date.isBefore(ChristmasEvents.CHRISTMAS_D_DAY_EVENT.getEndDate())
    ),
    WEEKDAY_EVENT(ChristmasEvents.WEEKDAY_EVENT,
            date -> !date.isBefore(ChristmasEvents.WEEKDAY_EVENT.getStartDate())
                    && date.isBefore(ChristmasEvents.WEEKDAY_EVENT.getEndDate())
                    && List.of(1, 2, 3, 4, 7).contains(date.getDayOfWeek().getValue())
    ),
    WEEKEND_EVENT(ChristmasEvents.WEEKEND_EVENT,
            date -> !date.isBefore(ChristmasEvents.WEEKEND_EVENT.getStartDate())
                    && date.isBefore(ChristmasEvents.WEEKEND_EVENT.getEndDate())
                    && List.of(5, 6).contains(date.getDayOfWeek().getValue())
    ),
    SPECIAL_EVENT(ChristmasEvents.SPECIAL_EVENT,
            date -> !date.isBefore(ChristmasEvents.SPECIAL_EVENT.getStartDate())
                    && date.isBefore(ChristmasEvents.SPECIAL_EVENT.getEndDate())
                    && List.of(3, 10, 17, 24, 25, 31).contains(date.getDayOfMonth())
    );

    private final ChristmasEvents event;
    private final Predicate<LocalDate> match;

    ChristmasDateBaseEvents(ChristmasEvents event, Predicate<LocalDate> match) {
        this.event = event;
        this.match = match;
    }

    public static List<ChristmasEvents> findRelevantEventsForOrder(Orders orders) {
        return Arrays.stream(values())
                .filter(it -> it.match.test(orders.getOrderDate()))
                .map(it -> it.event)
                .toList();
    }
}
