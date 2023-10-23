package baseball.view;

import static baseball.model.ExceptionMessage.NUMBER_FORMAT_EXCEPTION_MESSAGE;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.Stream;
import baseball.dto.request.GameRestartDto;
import baseball.dto.request.PlayerNumbersDto;
import baseball.util.BlankValidator;
import baseball.util.DigitsOnlyValidator;
import baseball.util.SingleDigitValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_PLAYER_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String PLAYER_NUMBER_DELIMITER = "";
    private static final String INPUT_GAME_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private InputView() {
    }

    public static InputView getInstance() {
        return LazyHolder.INSTANCE;
    }

    public PlayerNumbersDto scanPlayerNumbers() {
        System.out.print(INPUT_PLAYER_NUMBER_MESSAGE);
        String rawPlayerNumbers = Console.readLine();
        validatePlayerNumbers(rawPlayerNumbers);
        List<Integer> playerNumbers = splitToInt(PLAYER_NUMBER_DELIMITER, rawPlayerNumbers);
        return new PlayerNumbersDto(playerNumbers);
    }

    private List<Integer> splitToInt(String format, String input) {
        return Stream.of(input.split(format))
                .map(Integer::parseInt)
                .collect(toList());
    }

    private static void validatePlayerNumbers(String rawPlayerNumbers) {
        BlankValidator.validate(rawPlayerNumbers);
        DigitsOnlyValidator.validate(rawPlayerNumbers);
    }

    public GameRestartDto scanGameRestart() {
        System.out.println(INPUT_GAME_RESTART_MESSAGE);
        String rawGameRestart = Console.readLine();
        validateGameRestart(rawGameRestart);
        int gameRestartNumber = convertToInt(rawGameRestart);
        return new GameRestartDto(gameRestartNumber);
    }

    private int convertToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_EXCEPTION_MESSAGE);
        }
    }

    private void validateGameRestart(String rawGameRestart) {
        BlankValidator.validate(rawGameRestart);
        SingleDigitValidator.validate(rawGameRestart);
    }

    private static class LazyHolder {

        private static final InputView INSTANCE = new InputView();

    }

}
