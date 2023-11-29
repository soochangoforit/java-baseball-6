package baseball.view;

import baseball.model.BaseBallResult;

public class OutputView {
    private static final String EXCEPTION_FORMAT = "[ERROR] %s";

    public void printExceptionMessage(String message) {
        println(String.format(EXCEPTION_FORMAT, message));
    }

    private void println(String message) {
        System.out.println(message);
    }

    /**
     * 3스트라이크 3개의 숫자를 모두 맞히셨습니다! 게임 종료
     *
     * @param result
     */
    public void printResult(BaseBallResult result) {
        int ballCount = result.getBall();
        int strikeCount = result.getStrike();

        StringBuilder sb = new StringBuilder();
        if (ballCount > 0) {
            sb.append(ballCount).append("볼 ");
        }
        if (strikeCount > 0) {
            sb.append(strikeCount).append("스트라이크");
        }
        if (ballCount == 0 && strikeCount == 0) {
            sb.append("낫싱");
        }
        if (result.isAllStrike()) {
            sb.append("\n").append("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
        println(sb.toString());
    }

    public void printStartMessage() {
        println("숫자 야구 게임을 시작합니다.");
    }

    private void printEmptyLine() {
        System.out.println();
    }

}
