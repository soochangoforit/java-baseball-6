package baseball.model;

public final class BaseBallResult {
    private final int strike;
    private final int ball;

    private BaseBallResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public static BaseBallResult of(int strike, int ball) {
        return new BaseBallResult(strike, ball);
    }

    public boolean isAllStrike() {
        return strike == 3;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
