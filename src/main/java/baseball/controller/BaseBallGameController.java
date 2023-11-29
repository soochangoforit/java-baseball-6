package baseball.controller;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseBallGameController {
    private final InputView inputView;
    private final OutputView outputView;

    public BaseBallGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printStartMessage();

    }

    /**
     * 매개변수 X, 반환값 O
     * <p>
     * [예시] 1. view부터 dto을 받을때 2. dto을 domain으로 변환할때
     */
    private <T> T fetch(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
            return fetch(supplier);
        }
    }

    /**
     * 매개변수 T, 반환값 R
     */
    private <T, R> R fetch(Function<T, R> function, T input) {
        try {
            return function.apply(input);
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
            return fetch(function, input);
        }
    }

    /**
     * 매개변수 T U, 반환값 R
     */
    private <T, U, R> R fetch(BiFunction<T, U, R> function, T t, U u) {
        try {
            return function.apply(t, u);
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
            return fetch(function, t, u);
        }
    }

    /**
     * 매개변수 T U, 반환값 X
     */
    private <T, U> void fetch(BiConsumer<T, U> function, T t, U u) {
        try {
            function.accept(t, u);
        } catch (IllegalArgumentException e) {
            outputView.printExceptionMessage(e.getMessage());
            fetch(function, t, u);
        }
    }
}
