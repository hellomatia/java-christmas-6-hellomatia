package christmas.domain.event;

import christmas.domain.order.Order;
import christmas.domain.order.OrderDate;
import christmas.domain.order.Orders;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ChristmasDateBaseEventsTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "10", "15", "20", "24", "25"})
    void 크리스마스_디데이_이벤트_기간내_이면_이벤트를_반환받는다(String input) {
        Orders orders = Orders.create(OrderDate.create(input), List.of(Order.create("티본스테이크-1")));
        assertThat(ChristmasDateBaseEvents.findRelevantEventsForOrder(orders)
                .contains(ChristmasEvents.CHRISTMAS_D_DAY_EVENT))
                .isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"3", "4", "5", "6", "11", "28"})
    void 일_월_화_수_목_은_평일_이벤트를_반환받는다(String input) {
        Orders orders = Orders.create(OrderDate.create(input), List.of(Order.create("티본스테이크-1")));
        assertThat(ChristmasDateBaseEvents.findRelevantEventsForOrder(orders)
                .contains(ChristmasEvents.WEEKDAY_EVENT))
                .isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "8", "23", "29", "30"})
    void 금_토_는_평일_이벤트를_반환받지_못한다(String input) {
        Orders orders = Orders.create(OrderDate.create(input), List.of(Order.create("티본스테이크-1")));
        assertThat(ChristmasDateBaseEvents.findRelevantEventsForOrder(orders)
                .contains(ChristmasEvents.WEEKDAY_EVENT))
                .isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "8", "23", "29", "30"})
    void 금_토_는_주말_이벤트를_반환받는다(String input) {
        Orders orders = Orders.create(OrderDate.create(input), List.of(Order.create("티본스테이크-1")));
        assertThat(ChristmasDateBaseEvents.findRelevantEventsForOrder(orders)
                .contains(ChristmasEvents.WEEKEND_EVENT))
                .isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"3", "4", "5", "6", "11", "28"})
    void 일_월_화_수_목_은_주말_이벤트를_반환받지_못한다(String input) {
        Orders orders = Orders.create(OrderDate.create(input), List.of(Order.create("티본스테이크-1")));
        assertThat(ChristmasDateBaseEvents.findRelevantEventsForOrder(orders)
                .contains(ChristmasEvents.WEEKEND_EVENT))
                .isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"3", "10", "17", "24", "25", "31"})
    void 별이_있는날은_스페셜_이벤트를_반환받는다(String input) {
        Orders orders = Orders.create(OrderDate.create(input), List.of(Order.create("티본스테이크-1")));
        assertThat(ChristmasDateBaseEvents.findRelevantEventsForOrder(orders)
                .contains(ChristmasEvents.SPECIAL_EVENT))
                .isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "4", "11", "26", "30"})
    void 별이_없는날은_스페셜_이벤트를_반환받지_못한다(String input) {
        Orders orders = Orders.create(OrderDate.create(input), List.of(Order.create("티본스테이크-1")));
        assertThat(ChristmasDateBaseEvents.findRelevantEventsForOrder(orders)
                .contains(ChristmasEvents.SPECIAL_EVENT))
                .isFalse();
    }
}
