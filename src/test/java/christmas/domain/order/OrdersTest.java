package christmas.domain.order;

import christmas.dto.OrderDTO;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class OrdersTest {

    @Test
    void Orders객체를_생성한다() {
        var orderDate = OrderDate.create("10");
        var orders = List.of(Order.create("타파스-1"), Order.create("제로콜라-1"));
        assertThat(Orders.create(orderDate, orders))
                .isInstanceOf(Orders.class);
    }

    @Test
    void 음료만_주문할_시_예외가_발생한다() {
        var orderDate = OrderDate.create("10");
        var orders = List.of(Order.create("제로콜라-1"), Order.create("레드와인-1"));
        assertThatThrownBy(() -> Orders.create(orderDate, orders))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");

    }

    @Test
    void 중복된_메뉴를_주문할_시_예외가_발생한다() {
        var orderDate = OrderDate.create("10");
        var orders = List.of(Order.create("타파스-1"), Order.create("타파스-1"));
        assertThatThrownBy(() -> Orders.create(orderDate, orders))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @Test
    void 총_주문_개수가_20개가_넘어가면_예외가_발생한다() {
        var orderDate = OrderDate.create("10");
        var orders = List.of(Order.create("타파스-10"), Order.create("티본스테이크-11"));
        assertThatThrownBy(() -> Orders.create(orderDate, orders))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @Test
    void toDTO를_통해_OrderDTO_List를_생성한다() {
        var orderDate = OrderDate.create("10");
        var orders = List.of(Order.create("타파스-1"), Order.create("제로콜라-1"));
        var expected = List.of(new OrderDTO("타파스", 1),
                new OrderDTO("제로콜라", 1));
        assertThat(Orders.create(orderDate, orders).toDTO())
                .isEqualTo(expected);
    }

    @Test
    void 총_주문금액을_반환한다() {
        var orderDate = OrderDate.create("10");
        var orders = List.of(Order.create("타파스-1"), Order.create("제로콜라-1"));
        var expected = 8_500;
        assertThat(Orders.create(orderDate, orders).getTotalOrderAmount())
                .isEqualTo(expected);
    }
}
