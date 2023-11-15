package christmas.domain.order;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class MenuCountTest {

    @ParameterizedTest
    @CsvSource(value = {"1, 1", "5, 5", "10, 10", "20, 20"})
    void 메뉴개수를_허용된_범위내로_생성한다(int input, int expected) {
        assertThat(MenuCount.create(input).getCount())
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 21, 22, 23, 100})
    void 메뉴개수를_허용된_범위를_벗어나면_예외를_발생한다(int input) {
        assertThatThrownBy(() -> MenuCount.create(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }
}
