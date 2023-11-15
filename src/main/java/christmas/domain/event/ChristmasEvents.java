package christmas.domain.event;

import java.time.LocalDate;

public enum ChristmasEvents {

    CHRISTMAS_D_DAY_EVENT(LocalDate.of(2023, 12, 1),
            LocalDate.of(2023, 12, 25).plusDays(1),
            "크리스마스 디데이 할인"),
    WEEKDAY_EVENT(LocalDate.of(2023, 12, 1),
            LocalDate.of(2023, 12, 31).plusDays(1),
            "평일 할인"),
    WEEKEND_EVENT(LocalDate.of(2023, 12, 1),
            LocalDate.of(2023, 12, 31).plusDays(1),
            "주말 할인"),
    SPECIAL_EVENT(LocalDate.of(2023, 12, 1),
            LocalDate.of(2023, 12, 31).plusDays(1),
            "특별 할인"),
    BONUS_GIFT_EVENT(
            LocalDate.of(2023, 12, 1),
            LocalDate.of(2023, 12, 31).plusDays(1),
            "증정 이벤트");

    private final LocalDate startDate;
    private final LocalDate endDate;
    private final String name;

    ChristmasEvents(LocalDate startDate, LocalDate endDate, String name) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getName() {
        return name;
    }
}
