package christmas.domain.event;

import java.util.Arrays;
import java.util.function.Predicate;

public enum EventBadge {

    NOTHING("없음", discountAmount -> discountAmount < 5_000),
    STAR("별", discountAmount -> 5_000 <= discountAmount && discountAmount < 10_000),
    TREE("트리", discountAmount -> 10_000 <= discountAmount && discountAmount < 20_000),
    SANTA("산타", discountAmount -> 20_000 <= discountAmount);

    private final String name;
    private final Predicate<Integer> match;

    EventBadge(String badge, Predicate<Integer> match) {
        this.name = badge;
        this.match = match;
    }

    public static EventBadge from(int discountAmount) {
        return Arrays.stream(values())
                .filter(it -> it.match.test(discountAmount))
                .findFirst()
                .orElse(NOTHING);
    }

    public String getName() {
        return name;
    }
}
