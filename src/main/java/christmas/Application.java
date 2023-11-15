package christmas;

import christmas.controller.Controller;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Application {
    public static void main(String[] args) {
        new Controller(initInputView(), initOutputView()).run();
    }

    private static InputView initInputView() {
        return new InputView();
    }

    private static OutputView initOutputView() {
        return new OutputView();
    }
}
