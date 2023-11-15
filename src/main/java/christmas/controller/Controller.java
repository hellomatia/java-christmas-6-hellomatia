package christmas.controller;

import christmas.domain.eventPlanner.EventPlanner;
import christmas.domain.eventPlanner.ChristmasEventPlanner;
import christmas.domain.order.Order;
import christmas.domain.order.OrderDate;
import christmas.domain.order.Orders;
import christmas.dto.EventDetailDTO;
import christmas.dto.OrderDTO;
import christmas.util.Parser;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.time.LocalDate;
import java.util.List;


public class Controller {

    private final InputView inputView;
    private final OutputView outputView;
    private EventPlanner eventPlanner;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        printStartMessage(OrderDate.MONTH);
        OrderDate orderDate = askOrderDate();
        Orders orders = initOrders(orderDate);
        printEventInformationMessage(orders.getOrderDate());
        printOrders(orders.toDTO());
        printOrderAmount(orders.getTotalOrderAmount());
        eventPlanner = ChristmasEventPlanner.create(orders);
        printEventDetail(eventPlanner.calculateAllEvent());
        inputView.close();
    }

    private OrderDate askOrderDate() {
        try {
            String orderDate = inputView.inputDateOfVisit(OrderDate.MONTH);
            return OrderDate.create(orderDate);
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
            return askOrderDate();
        }
    }

    private Orders initOrders(OrderDate orderDate) {
        try {
            return Orders.create(orderDate, askOrders());
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
            return initOrders(orderDate);
        }
    }

    private List<Order> askOrders() {
        try {
            return Parser.stringToList(inputView.inputOrders())
                    .stream()
                    .map(Order::create)
                    .toList();
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
            return askOrders();
        }
    }

    private void printStartMessage(int month) {
        outputView.printStartMessage(month);
    }

    private void printErrorMessage(String message) {
        outputView.printErrorMessage(message);
    }

    private void printEventInformationMessage(LocalDate orderDate) {
        outputView.printEventInformationMessage(orderDate);
    }

    private void printOrders(List<OrderDTO> orderDTOS) {
        outputView.printOrders(orderDTOS);
    }

    private void printOrderAmount(int orderAmount) {
        outputView.printOrderAmount(orderAmount);
    }

    private void printEventDetail(EventDetailDTO eventDetailDTO) {
        outputView.printEventDetail(eventDetailDTO);
    }
}
