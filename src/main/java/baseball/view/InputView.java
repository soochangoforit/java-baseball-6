package baseball.view;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.Stream;
import baseball.view.validator.BlankValidator;
import baseball.view.validator.DigitsOnlyValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public List<Integer> readBaseBallNumbers() {
        print("숫자를 입력해주세요 : ");
        String rawBaseBallNumbers = readLine();
        validateBaseBallNumbers(rawBaseBallNumbers);
        return splitToInt("", rawBaseBallNumbers);
    }

    private void validateBaseBallNumbers(String rawBaseBallNumbers) {
        BlankValidator.validate(rawBaseBallNumbers);
        DigitsOnlyValidator.validate(rawBaseBallNumbers);
    }

    private String readLine() {
        return Console.readLine().trim();
    }

    private void print(String message) {
        System.out.print(message);
    }

    private List<Integer> splitToInt(String delimiter, String input) {
        return Stream.of(input.split(delimiter))
                .map(Integer::parseInt)
                .collect(toList());
    }

    private int convertToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자로 변환할 수 없는 문자입니다.");
        }
    }

    private void println(String message) {
        System.out.println(message);
    }

    private void printEmptyLine() {
        System.out.println();
    }

    private List<String> split(String format, String input) {
        return List.of(input.split(format));
    }

}
