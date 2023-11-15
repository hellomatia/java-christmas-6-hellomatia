package christmas.domain.event;

import christmas.domain.order.Order;
import christmas.domain.order.OrderDate;
import christmas.domain.order.Orders;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ChristmasOrderAmountBaseEventsTest {

    @ParameterizedTest
    @ValueSource(strings = {"티본스테이크-3", "크리스마스파스타-10", "초코케이크-10", "시저샐러드-20"})
    void 주문금액이_12만원을_넘기면_증정_이벤트를_반환받는다(String input) {
        Orders orders = Orders.create(OrderDate.create("1"), List.of(Order.create(input)));
        assertThat(ChristmasOrderAmountBaseEvents.findRelevantEventsForOrder(orders)
                .contains(ChristmasEvents.BONUS_GIFT_EVENT))
                .isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"티본스테이크-1", "크리스마스파스타-4", "타파스-20", "시저샐러드-10"})
    void 주문금액이_12만원을_못_넘기면_증정_이벤트를_반환받지_못한다(String input) {
        Orders orders = Orders.create(OrderDate.create("1"), List.of(Order.create(input)));
        assertThat(ChristmasOrderAmountBaseEvents.findRelevantEventsForOrder(orders)
                .contains(ChristmasEvents.BONUS_GIFT_EVENT))
                .isFalse();
    }
}
