package baseball.controller;

import java.util.List;
import baseball.model.BaseBallGame;
import baseball.model.BaseBallNumbers;
import baseball.model.BaseBallResult;
import baseball.model.NumberGenerator;
import baseball.model.RestartCommand;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseBallGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final NumberGenerator numberGenerator;

    public BaseBallGameController(InputView inputView, OutputView outputView, NumberGenerator numberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.numberGenerator = numberGenerator;
    }

    public void run() {
        outputView.printStartMessage();
        playingGame();
    }

    private void playingGame() {
        BaseBallNumbers randomBaseBallNumbers = BaseBallNumbers.create(numberGenerator);
        BaseBallGame baseBallGame = BaseBallGame.of(randomBaseBallNumbers);
        while (baseBallGame.isInProgress()) {
            BaseBallNumbers userBaseBallNumbers = readBaseBallNumbers();
            BaseBallResult result = baseBallGame.play(userBaseBallNumbers);
            outputView.printResult(result);
        }
        if (readRestart().isRestart()) {
            playingGame();
        }
    }

    private RestartCommand readRestart() {
        int rawRestartCommand = inputView.readRestart();
        return RestartCommand.from(rawRestartCommand);
    }

    private BaseBallNumbers readBaseBallNumbers() {
        List<Integer> baseBallNumbers = inputView.readBaseBallNumbers();
        return BaseBallNumbers.from(baseBallNumbers);
    }

}
