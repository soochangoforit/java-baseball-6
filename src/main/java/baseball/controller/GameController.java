package baseball.controller;

import baseball.dto.request.GameRestartDto;
import baseball.dto.request.PlayerNumbersDto;
import baseball.dto.response.GameResultDto;
import baseball.model.BaseBallGame;
import baseball.model.BaseBallGameResult;
import baseball.model.BaseBallNumbers;
import baseball.model.GameRestartStatus;
import baseball.model.NumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

    private final OutputView outputView;
    private final InputView inputView;
    private final NumberGenerator numberGenerator;

    public GameController(OutputView outputView, InputView inputView, NumberGenerator numberGenerator) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.numberGenerator = numberGenerator;
    }

    public void run() {
        printGameStartMessage();
        playingGame();
    }

    private void printGameStartMessage() {
        outputView.printGameStart();
    }

    private void playingGame() {
        do {
            BaseBallGame game = initBaseBallGame();
            playSingleGameUntilEnd(game);
        } while (isRestartGame());
    }

    private void playSingleGameUntilEnd(BaseBallGame game) {
        while (game.isNotEnd()) {
            BaseBallNumbers playerNumbers = scanPlayerBaseBallNumbers();
            printGameResult(game, playerNumbers);
        }
    }

    private BaseBallNumbers scanPlayerBaseBallNumbers() {
        PlayerNumbersDto playerNumbersDto = inputView.scanPlayerNumbers();
        return BaseBallNumbers.generateNumbers(playerNumbersDto.getNumbers());
    }

    private void printGameResult(BaseBallGame game, BaseBallNumbers playerNumbers) {
        BaseBallGameResult baseBallGameResult = game.calculateResult(playerNumbers);
        outputView.printGameResult(new GameResultDto(baseBallGameResult));
    }

    private BaseBallGame initBaseBallGame() {
        BaseBallNumbers computerNumbers = BaseBallNumbers.generateRandomNumbers(numberGenerator);
        return BaseBallGame.init(computerNumbers);
    }

    private boolean isRestartGame() {
        GameRestartStatus gameRestartStatus = scanGameReStartStatus();
        return gameRestartStatus.isRestart();
    }

    private GameRestartStatus scanGameReStartStatus() {
        GameRestartDto gameRestartDto = inputView.scanGameRestart();
        return GameRestartStatus.from(gameRestartDto.getGameRestartNumber());
    }

}
