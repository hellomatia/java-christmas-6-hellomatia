package christmas.domain.event;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class EventBadgeTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1_000, 2_000, 3_000, 4_999})
    void 혜택금액이_5000원미만이면_NOTHING을_반환받는다(int input) {
        assertThat(EventBadge.from(input))
                .isEqualTo(EventBadge.NOTHING);
    }

    @ParameterizedTest
    @ValueSource(ints = {5_000, 6_000, 7_000, 8_000, 9_999})
    void 혜택금액이_5000원이상_10000원미만이면_STAR를_반환받는다(int input) {
        assertThat(EventBadge.from(input))
                .isEqualTo(EventBadge.STAR);
    }

    @ParameterizedTest
    @ValueSource(ints = {10_000, 11_000, 13_000, 18_000, 19_999})
    void 혜택금액이_10000원이상_20000원미만이면_TREE를_반환받는다(int input) {
        assertThat(EventBadge.from(input))
                .isEqualTo(EventBadge.TREE);
    }

    @ParameterizedTest
    @ValueSource(ints = {20_000, 30_000, 40_000, 380_000, 999_999})
    void 혜택금액이_20000원이상이면_SANTA를_반환받는다(int input) {
        assertThat(EventBadge.from(input))
                .isEqualTo(EventBadge.SANTA);
    }
}
