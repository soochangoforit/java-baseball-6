package baseball.model;

public final class BaseBallNumber {
    private final int number;

    private BaseBallNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number < 1 || number > 9) {
            throw new IllegalArgumentException("1부터 9까지의 숫자만 가능합니다.");
        }
    }

    public static BaseBallNumber from(int number) {
        return new BaseBallNumber(number);
    }
}
