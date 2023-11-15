package christmas.domain.order;

import christmas.dto.OrderDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class OrderTest {

    @ParameterizedTest
    @ValueSource(strings = {"타파스-1", "제로콜라-1", "양송이수프-10", "티본스테이크-1"})
    void 유효한_주문시_객체를_생성한다(String input) {
        assertThat(Order.create(input))
                .isInstanceOf(Order.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "타파스_1", "타파스1개", "티본스테이크-한개"})
    void 잘못된_주문시_예외가_발생한다(String input) {
        assertThatThrownBy(() -> Order.create(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @ParameterizedTest
    @NullAndEmptySource
    void null값이_들어올시_예외가_발생한다(String input) {
        assertThatThrownBy(() -> Order.create(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @Test
    void toDTO를_통해_OrderDTO를_생성한다() {
        assertThat(Order.create("티본스테이크-10").toDTO())
                .isEqualTo(new OrderDTO("티본스테이크", 10));
    }
}
