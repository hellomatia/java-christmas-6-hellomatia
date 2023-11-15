package christmas.domain.calculator;

import christmas.domain.event.ChristmasEvents;
import christmas.domain.order.Order;
import christmas.domain.order.OrderDate;
import christmas.domain.order.Orders;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ChristmasEventDiscountCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"1, 1_000", "2, 1_000", "3, 1_000", "31, 1_000"})
    void 스페셜_이벤트_할인을_계산한다(String input, int expected) {
        Orders orders = Orders.create(OrderDate.create(input), List.of(Order.create("티본스테이크-1")));
        assertThat(ChristmasEventDiscountCalculator.from(ChristmasEvents.SPECIAL_EVENT)
                .calculate(orders))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1, 25_000", "2, 25_000", "3, 25_000", "31, 25_000"})
    void 증정_이벤트_할인을_계산한다(String input, int expected) {
        Orders orders = Orders.create(OrderDate.create(input), List.of(Order.create("티본스테이크-1")));
        assertThat(ChristmasEventDiscountCalculator.from(ChristmasEvents.BONUS_GIFT_EVENT)
                .calculate(orders))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1, 1_000", "2, 1_100", "25, 3_400", "31, 4_000"})
    void 크리스마스_디데이_이벤트_할인을_계산한다(String input, int expected) {
        Orders orders = Orders.create(OrderDate.create(input), List.of(Order.create("티본스테이크-1")));
        assertThat(ChristmasEventDiscountCalculator.from(ChristmasEvents.CHRISTMAS_D_DAY_EVENT)
                .calculate(orders))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"초코케이크-2, 4_046", "아이스크림-1, 2_023", "티본스테이크-10, 0", "양송이수프-5, 0"})
    void 평일_이벤트_할인을_계산한다(String input, int expected) {
        Orders orders = Orders.create(OrderDate.create("4"), List.of(Order.create(input)));
        assertThat(ChristmasEventDiscountCalculator.from(ChristmasEvents.WEEKDAY_EVENT)
                .calculate(orders))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"초코케이크-2, 0", "타파스-1, 0", "티본스테이크-10, 20_230", "바비큐립-1, 2_023"})
    void 주말_이벤트_할인을_계산한다(String input, int expected) {
        Orders orders = Orders.create(OrderDate.create("1"), List.of(Order.create(input)));
        assertThat(ChristmasEventDiscountCalculator.from(ChristmasEvents.WEEKEND_EVENT)
                .calculate(orders))
                .isEqualTo(expected);
    }
}
