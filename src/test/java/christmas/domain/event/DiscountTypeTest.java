package christmas.domain.event;

import christmas.dto.BonusGiftDTO;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DiscountTypeTest {

    @Test
    void 크리스마스_디데이_이벤트는_TOTAL_AMOUNT_DISCOUNT로_반환받는다() {
        assertThat(DiscountType.from(ChristmasEvents.CHRISTMAS_D_DAY_EVENT))
                .isEqualTo(DiscountType.TOTAL_AMOUNT_DISCOUNT);
    }

    @Test
    void 스페셜_이벤트는_TOTAL_AMOUNT_DISCOUNT로_반환받는다() {
        assertThat(DiscountType.from(ChristmasEvents.SPECIAL_EVENT))
                .isEqualTo(DiscountType.TOTAL_AMOUNT_DISCOUNT);
    }

    @Test
    void 증정_이벤트는_BONUS_GIFT_DISCOUNT로_반환받는다() {
        assertThat(DiscountType.from(ChristmasEvents.BONUS_GIFT_EVENT))
                .isEqualTo(DiscountType.BONUS_GIFT_DISCOUNT);
    }

    @Test
    void 평일_이벤트는_PER_ITEM_DISCOUNT로_반환받는다() {
        assertThat(DiscountType.from(ChristmasEvents.WEEKDAY_EVENT))
                .isEqualTo(DiscountType.PER_ITEM_DISCOUNT);
    }

    @Test
    void 주말_이벤트는_PER_ITEM_DISCOUNT로_반환받는다() {
        assertThat(DiscountType.from(ChristmasEvents.WEEKEND_EVENT))
                .isEqualTo(DiscountType.PER_ITEM_DISCOUNT);
    }
}
