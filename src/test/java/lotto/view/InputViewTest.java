package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputViewTest {
    @DisplayName("InputView 는 생성시에 null이 들어오면 예외가 발생한다")
    @Test
    void case1() {
        assertThrows(IllegalArgumentException.class, () -> new InputView(null));
    }
}