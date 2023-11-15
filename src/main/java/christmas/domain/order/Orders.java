package christmas.domain.order;

import christmas.dto.OrderDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static christmas.util.ChristmasEventException.NOT_VALID_ORDER;

public class Orders {

    private final static int MAX_TOTAL_MENUCOUNT = 20;

    private final LocalDate orderDate;
    private final List<Order> orders;
    private final int totalOrderAmount;

    private Orders(LocalDate orderDate, List<Order> orders) {
        this.orderDate = orderDate;
        this.orders = orders;
        this.totalOrderAmount = calculateTotalOrderAmount();
        validate();
    }

    public static Orders create(OrderDate orderDate, List<Order> orders) {
        return new Orders(orderDate.getDate(), orders);
    }

    private void validate() {
        if (isOnlyOrderDrink() || isNotUniqueMenu() || isNotValidTotalMenuCount()) {
            throw NOT_VALID_ORDER.create();
        }
    }

    private boolean isOnlyOrderDrink() {
        return orders.stream()
                .map(order -> order.getMenu().getCategory())
                .filter(menuCategory -> menuCategory != MenuCategory.DRINK)
                .toList()
                .isEmpty();
    }

    private boolean isNotUniqueMenu() {
        return orders.stream()
                .map(order -> order.getMenu().getName())
                .collect(Collectors.toSet())
                .size() != orders.size();
    }

    private boolean isNotValidTotalMenuCount() {
        return orders.stream()
                .mapToInt(order -> order.getMenuCount().getCount())
                .sum() > MAX_TOTAL_MENUCOUNT;
    }

    private int calculateTotalOrderAmount() {
        return orders.stream()
                .mapToInt(Order::getOrderAmount)
                .sum();
    }

    public List<OrderDTO> toDTO() {
        return orders.stream()
                .map(Order::toDTO)
                .toList();
    }

    public List<Order> getOrders() {
        return List.copyOf(orders);
    }

    public int getTotalOrderAmount() {
        return totalOrderAmount;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }
}
