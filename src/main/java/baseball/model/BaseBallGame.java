package baseball.model;

public class BaseBallGame {
    private final BaseBallNumbers randomNumbers;
    private boolean inProgress;

    private BaseBallGame(BaseBallNumbers randomNumbers, boolean inProgress) {
        this.randomNumbers = randomNumbers;
        this.inProgress = inProgress;
    }

    public static BaseBallGame of(BaseBallNumbers randomNumbers) {
        return new BaseBallGame(randomNumbers, true);
    }

    public BaseBallResult play(BaseBallNumbers userBaseBallNumbers) {
        BaseBallResult baseBallResult = randomNumbers.match(userBaseBallNumbers);
        if (baseBallResult.isAllStrike()) {
            inProgress = false;
        }
        return baseBallResult;
    }
}
