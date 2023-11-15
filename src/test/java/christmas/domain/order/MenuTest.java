package christmas.domain.order;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class MenuTest {

    @ParameterizedTest
    @ValueSource(strings = {"양송이수프", "크리스마스파스타", "크리스마스파스타", "제로콜라"})
    void 메뉴에_있는_메뉴로_선택할시_해당음식를_반환한다(String input) {
        assertThat(Menu.from(input).getName())
                .isEqualTo(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"물", "치약", "김치", "아무거나"})
    void 메뉴에_없는_메뉴를_선택할시_예외가_발생한다(String input) {
        assertThatThrownBy(() -> Menu.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }
}
