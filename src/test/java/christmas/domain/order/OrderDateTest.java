package christmas.domain.order;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class OrderDateTest {

    @ParameterizedTest
    @CsvSource(value = {"1, 1", "5, 5", "10, 10", "20, 20", "31, 31"})
    void 허용된_주문날짜로_객체를_생성한다(String input, int expected) {
        assertThat(OrderDate.create(input).getDate().getDayOfMonth())
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "32", "35", "50", "100"})
    void 허용된_주문날짜를_벗어날_경우_예외가_발생한다(String input) {
        assertThatThrownBy(() -> OrderDate.create(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"ㅇㄹ", "ㅎㄷㅁ", "ㄱ ", "ㅁ5ㅇ", "apple"})
    void 숫자가_아닌값으로_생성할시_예외가_발생한다(String input) {
        assertThatThrownBy(() -> OrderDate.create(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }

    @ParameterizedTest
    @NullAndEmptySource
    void null값으로_생성할시_예외가_발생한다(String input) {
        assertThatThrownBy(() -> OrderDate.create(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }
}
