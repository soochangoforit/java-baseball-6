package baseball;

import baseball.controller.BaseBallGameController;
import baseball.model.NumberGenerator;
import baseball.model.RandomNumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        BaseBallGameController controller = new BaseBallGameController(inputView, outputView, numberGenerator);
        controller.run();
    }
}
