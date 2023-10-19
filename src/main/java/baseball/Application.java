package baseball;

import baseball.controller.GameController;
import baseball.domain.NumberGenerator;
import baseball.domain.RandomNumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = InputView.getInstance();
        OutputView outputView = OutputView.getInstance();
        NumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        GameController baseBallGameController = new GameController(outputView, inputView, randomNumberGenerator);
        baseBallGameController.run();
    }

}
