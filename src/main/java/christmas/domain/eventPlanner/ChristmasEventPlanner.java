package christmas.domain.eventPlanner;

import christmas.domain.event.*;
import christmas.domain.calculator.ChristmasEventDiscountCalculator;
import christmas.domain.order.Orders;
import christmas.dto.DiscountDetailDTO;
import christmas.dto.EventBadgeDTO;
import christmas.dto.EventDetailDTO;
import christmas.dto.BonusGiftDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChristmasEventPlanner implements EventPlanner {

    private final static int MIN_APPLY_EVENT_ORDER_AMOUNT = 10_000;
    private final static int NOTHING = 0;

    private final Orders orders;
    private List<ChristmasEvents> christmasEvents;
    private int totalDiscountAmount;
    private int paymentAmount;

    private ChristmasEventPlanner(Orders orders) {
        this.orders = orders;
        this.paymentAmount = orders.getTotalOrderAmount();
        findEvent();
    }

    public static ChristmasEventPlanner create(Orders orders) {
        return new ChristmasEventPlanner(orders);
    }

    private void findEvent() {
        if (canNotApplyEvent()) {
            christmasEvents = Collections.emptyList();
            return;
        }
        christmasEvents = new ArrayList<>();
        findDateBaseEvents();
        findOrderAmountBaseEvents();
    }

    private boolean canNotApplyEvent() {
        return orders.getTotalOrderAmount() < MIN_APPLY_EVENT_ORDER_AMOUNT;
    }

    private void findDateBaseEvents() {
        christmasEvents.addAll(ChristmasDateBaseEvents.findRelevantEventsForOrder(orders));
    }

    private void findOrderAmountBaseEvents() {
        christmasEvents.addAll(ChristmasOrderAmountBaseEvents.findRelevantEventsForOrder(orders));
    }

    @Override
    public EventDetailDTO calculateAllEvent() {
        return new EventDetailDTO(
                calculateBonusGift(),
                calculateAmountDiscount(),
                totalDiscountAmount,
                paymentAmount,
                calculateEventBadge()
        );
    }

    private List<BonusGiftDTO> calculateBonusGift() {
        List<BonusGiftDTO> bonusGiftDTOS = new ArrayList<>();
        christmasEvents.stream()
                .map(ChristmasBonusGiftEvents::getBonusGiftsForEvent)
                .forEach(bonusGiftDTOS::addAll);
        return bonusGiftDTOS;
    }

    private List<DiscountDetailDTO> calculateAmountDiscount() {
        return christmasEvents.stream()
                .map(this::calculateOneAmountDiscountEvent)
                .toList();
    }

    private DiscountDetailDTO calculateOneAmountDiscountEvent(ChristmasEvents christmasEvent) {
        int discountAmount = ChristmasEventDiscountCalculator.from(christmasEvent).calculate(orders);
        if (discountAmount == NOTHING) {
            return null;
        }
        updateTotalDiscountAmount(discountAmount);
        updatePaymentAmount(christmasEvent, discountAmount);
        return new DiscountDetailDTO(christmasEvent.getName(), discountAmount);
    }

    private void updateTotalDiscountAmount(int discountAmount) {
        totalDiscountAmount += discountAmount;
    }

    private void updatePaymentAmount(ChristmasEvents christmasEvents, int discountAmount) {
        if (DiscountType.from(christmasEvents) == DiscountType.BONUS_GIFT_DISCOUNT) {
            return;
        }
        paymentAmount -= discountAmount;
    }

    private EventBadgeDTO calculateEventBadge() {
        return new EventBadgeDTO(orders.getOrderDate().getMonthValue(), EventBadge.from(totalDiscountAmount).getName());
    }
}
