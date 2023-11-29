package baseball.model;

import java.util.List;

public class BaseBallNumbers {
    private final List<BaseBallNumber> numbers;

    private BaseBallNumbers(List<BaseBallNumber> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<BaseBallNumber> numbers) {
        if (numbers.size() != 3) {
            throw new IllegalArgumentException("숫자는 3개만 가능합니다.");
        }
        if (numbers.stream().distinct().count() != 3) {
            throw new IllegalArgumentException("숫자는 중복되지 않아야 합니다.");
        }
    }

    public static BaseBallNumbers from(List<Integer> numbers) {
        List<BaseBallNumber> baseBallNumbers = numbers.stream()
                .map(BaseBallNumber::from)
                .toList();

        return new BaseBallNumbers(baseBallNumbers);
    }
}
