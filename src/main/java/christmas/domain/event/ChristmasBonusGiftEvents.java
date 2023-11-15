package christmas.domain.event;

import christmas.domain.order.Menu;
import christmas.dto.BonusGiftDTO;

import java.util.Arrays;
import java.util.List;

public enum ChristmasBonusGiftEvents {

    BONUS_GIFT(ChristmasEvents.BONUS_GIFT_EVENT, Menu.CHAMPAGNE.getName(), 1);

    private final ChristmasEvents event;
    private final String bonusGiftName;
    private final int bonusGiftCount;

    ChristmasBonusGiftEvents(ChristmasEvents event, String bonusGiftName, int bonusGiftCount) {
        this.event = event;
        this.bonusGiftName = bonusGiftName;
        this.bonusGiftCount = bonusGiftCount;
    }

    public static List<BonusGiftDTO> getBonusGiftsForEvent(ChristmasEvents event) {
        return Arrays.stream(values())
                .filter(it -> it.event == event)
                .map(it -> new BonusGiftDTO(it.bonusGiftName, it.bonusGiftCount))
                .toList();
    }
}
