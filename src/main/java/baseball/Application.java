package baseball;

import baseball.controller.BaseBallGameController;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BaseBallGameController controller = new BaseBallGameController(inputView, outputView);
        controller.run();
    }
}
