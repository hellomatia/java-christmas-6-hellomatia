package christmas.view;

import camp.nextstep.edu.missionutils.Console;

import static christmas.view.ViewMessage.INPUT_DATE_OF_VISIT;
import static christmas.view.ViewMessage.INPUT_ORDER_MENU;

public class InputView {

    public String inputDateOfVisit(int month) {
        System.out.printf(INPUT_DATE_OF_VISIT.getMessage(), month);
        System.out.println();
        return Console.readLine();
    }

    public String inputOrders() {
        System.out.println(INPUT_ORDER_MENU.getMessage());
        return Console.readLine();
    }

    public void close() {
        Console.close();
    }
}
