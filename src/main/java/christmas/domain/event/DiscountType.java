package christmas.domain.event;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum DiscountType {

    TOTAL_AMOUNT_DISCOUNT(
            List.of(ChristmasEvents.CHRISTMAS_D_DAY_EVENT, ChristmasEvents.SPECIAL_EVENT)
    ),
    BONUS_GIFT_DISCOUNT(
            List.of(ChristmasEvents.BONUS_GIFT_EVENT)
    ),
    PER_ITEM_DISCOUNT(
            List.of(ChristmasEvents.WEEKDAY_EVENT, ChristmasEvents.WEEKEND_EVENT)
    ),
    NOTHING(
            Collections.EMPTY_LIST
    );

    private final List<ChristmasEvents> events;

    DiscountType(List<ChristmasEvents> events) {
        this.events = events;
    }

    public static DiscountType from(ChristmasEvents christmasEvents) {
        return Arrays.stream(values())
                .filter(it -> it.events.contains(christmasEvents))
                .findFirst()
                .orElse(NOTHING);
    }
}
