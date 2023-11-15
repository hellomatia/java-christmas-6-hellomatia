package christmas.view;

import christmas.dto.*;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.List;

import static christmas.view.ViewMessage.*;

public class OutputView {

    public void printStartMessage(int month) {
        System.out.printf(OUTPUT_START.getMessage(), month);
        System.out.println();
    }

    public void printEventInformationMessage(LocalDate orderDate) {
        System.out.printf(OUTPUT_EVENT_INFORMATION.getMessage(), orderDate.getMonthValue(), orderDate.getDayOfMonth());
        System.out.println();
        System.out.println();
    }

    public void printOrderAmount(int orderAmount) {
        System.out.printf(OUTPUT_ORDER_AMOUNT.getMessage(), makeAmount(orderAmount));
        System.out.println();
        System.out.println();
    }

    public void printOrders(List<OrderDTO> ordersDTOS) {
        System.out.println(OUTPUT_ORDER_MENU.getMessage());
        ordersDTOS.forEach(this::printOrder);
        System.out.println();
    }

    private void printOrder(OrderDTO order) {
        System.out.printf(OUTPUT_MENU.getMessage(), order.menuName(), order.menuCount());
        System.out.println();
    }

    public void printEventDetail(EventDetailDTO eventDetailDTO) {
        printBonusGift(eventDetailDTO.bonusGifts());
        printTotalDiscountDetails(eventDetailDTO.discountDetails());
        printTotalDiscountAmount(eventDetailDTO.discountAmount());
        printPaymentAmount(eventDetailDTO.paymentAmount());
        printEventBadge(eventDetailDTO.eventBadgeDTO());
    }

    private void printBonusGift(List<BonusGiftDTO> bonusGifts) {
        System.out.println(OUTPUT_BONUS_GIFT.getMessage());
        if (bonusGifts.isEmpty()) {
            System.out.println(OUTPUT_NOTHING.getMessage());
            System.out.println();
            return;
        }
        bonusGifts.forEach(this::printBonusGift);
        System.out.println();
    }

    private void printBonusGift(BonusGiftDTO bonusGiftDTO) {
        System.out.printf(OUTPUT_MENU.getMessage(), bonusGiftDTO.name(), bonusGiftDTO.count());
        System.out.println();
    }

    private void printTotalDiscountDetails(List<DiscountDetailDTO> discountDetailDTOS) {
        System.out.println(OUTPUT_DISCOUNT_DETAIL_INFORMATION.getMessage());
        if (discountDetailDTOS.isEmpty()) {
            System.out.println(OUTPUT_NOTHING.getMessage());
            System.out.println();
            return;
        }
        discountDetailDTOS.forEach(this::printDiscountDetail);
        System.out.println();
    }

    private void printDiscountDetail(DiscountDetailDTO discountDetailDTO) {
        System.out.printf(OUTPUT_DISCOUNT_DETAIL.getMessage(),
                discountDetailDTO.eventName(), makeAmount(discountDetailDTO.discountAmount()));
        System.out.println();
    }

    private void printTotalDiscountAmount(int discountAmount) {
        if (discountAmount == 0) {
            System.out.println(OUTPUT_TOTAL_DISCOUNT_AMOUNT_NOTHING.getMessage());
            System.out.println();
            return;
        }
        System.out.printf(OUTPUT_TOTAL_DISCOUNT_AMOUNT.getMessage(), makeAmount(discountAmount));
        System.out.println();
        System.out.println();
    }

    private void printPaymentAmount(int paymentAmount) {
        System.out.printf(OUTPUT_PAYMENT_AMOUNT.getMessage(), makeAmount(paymentAmount));
        System.out.println();
        System.out.println();
    }

    private void printEventBadge(EventBadgeDTO eventBadgeDTO) {
        System.out.printf(OUTPUT_EVENT_BADGE.getMessage(), eventBadgeDTO.month(), eventBadgeDTO.badge());
        System.out.println();
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    private String makeAmount(int amount) {
        DecimalFormat makeComma = new DecimalFormat("#,###");
        return makeComma.format(amount);
    }
}
