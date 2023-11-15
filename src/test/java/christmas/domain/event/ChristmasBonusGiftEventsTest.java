package christmas.domain.event;

import christmas.dto.BonusGiftDTO;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ChristmasBonusGiftEventsTest {

    @Test
    void 증정_이벤트가_있을시_보너스_선물을_반환한다() {
        var input = List.of(ChristmasEvents.BONUS_GIFT_EVENT, ChristmasEvents.CHRISTMAS_D_DAY_EVENT);
        var output = new ArrayList<BonusGiftDTO>();
        var expected = List.of(new BonusGiftDTO("샴페인", 1));
        input.stream()
                .map(ChristmasBonusGiftEvents::getBonusGiftsForEvent)
                .forEach(output::addAll);
        assertThat(output)
                .isEqualTo(expected);
    }

    @Test
    void 증정_이벤트가_없을시_보너스_선물을_반환하지_않는다() {
        var input = List.of(ChristmasEvents.SPECIAL_EVENT, ChristmasEvents.CHRISTMAS_D_DAY_EVENT);
        var output = new ArrayList<BonusGiftDTO>();
        var expected = Collections.EMPTY_LIST;
        input.stream()
                .map(ChristmasBonusGiftEvents::getBonusGiftsForEvent)
                .forEach(output::addAll);
        assertThat(output)
                .isEqualTo(expected);
    }
}
