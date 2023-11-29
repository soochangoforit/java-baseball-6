package baseball.model;

import java.util.Objects;

public final class BaseBallNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    private final int number;

    private BaseBallNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("1부터 9까지의 숫자만 가능합니다.");
        }
    }

    public static BaseBallNumber create(NumberGenerator numberGenerator) {
        return new BaseBallNumber(numberGenerator.generate(MIN_NUMBER, MAX_NUMBER));
    }

    public static BaseBallNumber from(int number) {
        return new BaseBallNumber(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BaseBallNumber that = (BaseBallNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "BaseBallNumber{" +
                "number=" + number +
                '}';
    }
}
