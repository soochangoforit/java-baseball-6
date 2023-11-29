package baseball.model;

import java.util.stream.Stream;

public enum RestartCommand {
    RESTART(1),
    EXIT(2);

    private final int command;

    RestartCommand(int command) {
        this.command = command;
    }

    public static RestartCommand from(int rawRestartCommand) {
        return Stream.of(values())
                .filter(restartCommand -> restartCommand.command == rawRestartCommand)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("1 또는 2만 입력 가능합니다."));
    }

    public boolean isRestart() {
        return this == RESTART;
    }
}
