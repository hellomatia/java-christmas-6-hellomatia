package christmas.dto;

import java.util.List;

public record EventDetailDTO(
        List<BonusGiftDTO> bonusGifts,
        List<DiscountDetailDTO> discountDetails,
        int discountAmount,
        int paymentAmount,
        EventBadgeDTO eventBadgeDTO
) {
}
