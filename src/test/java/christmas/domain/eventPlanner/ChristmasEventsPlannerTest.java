package christmas.domain.eventPlanner;

import christmas.domain.order.Order;
import christmas.domain.order.OrderDate;
import christmas.domain.order.Orders;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ChristmasEventsPlannerTest {

    @ParameterizedTest
    @ValueSource(strings = {"양송이수프-1", "타파스-1", "시저샐러드-1", "아이스크림-1"})
    void 주문금액이_10000원미만_이면_할인적용하지_않는다(String input) {
        Orders orders = Orders.create(OrderDate.create("25"), List.of(Order.create(input)));
        assertThat(ChristmasEventPlanner.create(orders).calculateAllEvent().discountDetails())
                .isEqualTo(Collections.EMPTY_LIST);
    }

    @ParameterizedTest
    @ValueSource(strings = {"양송이수프-2", "타파스-2", "시저샐러드-2", "아이스크림-2"})
    void 주문금액이_10000원이상_이면_할인적용하지_않는다(String input) {
        Orders orders = Orders.create(OrderDate.create("25"), List.of(Order.create(input)));
        assertThat(ChristmasEventPlanner.create(orders).calculateAllEvent().discountDetails())
                .isNotEqualTo(Collections.EMPTY_LIST);
    }
}
