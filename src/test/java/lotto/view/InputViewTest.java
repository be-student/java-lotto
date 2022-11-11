package lotto.view;

import handler.MockInputHandler;
import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputViewTest {
    private MockInputHandler mockInputHandler;

    @BeforeEach
    void setUp() {
        mockInputHandler = new MockInputHandler();
    }

    @DisplayName("getPlayerAmount 메서드는 구입 금액이 1000의 배수가 아니라면 않으면 예외를 발생시킨다")
    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", "-234", "234", "a1000"})
    void case1(String givenInput) {
        mockInputHandler.setExpected(givenInput);
        assertThrows(IllegalArgumentException.class,
                () -> InputView.createWithHandler(mockInputHandler)
                        .getPlayerAmount());
    }

    @DisplayName("getPlayerAmount 메서드는 구입 금액이 올바르다면 숫자를 반환한다")
    @Test
    void case2() {
        mockInputHandler.setExpected("1000");
        assertThat(InputView.createWithHandler(mockInputHandler)
                .getPlayerAmount())
                .isEqualTo(1000);
    }

    @DisplayName("getPlayerLottery 메서드는 로또 번호로 변환할 수 있는 형식이 아니면 예외를 발생시킨다")
    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", "-234", "1,2,3,4,5,6,", "1,1,2,3,4,5"})
    void case3(String givenInput) {
        mockInputHandler.setExpected(givenInput);
        assertThrows(IllegalArgumentException.class,
                () -> InputView.createWithHandler(mockInputHandler)
                        .getPlayerLottery());
    }

    @DisplayName("getPlayerLottery 메서드는 로또 번호로 변환할 수 있는 형식이라면 로또 객체를 반환한다")
    @Test
    void case4() {
        mockInputHandler.setExpected("6,2,3,4,5,1");
        Lotto lotto = InputView.createWithHandler(mockInputHandler).getPlayerLottery();
        assertThat(lotto).isExactlyInstanceOf(Lotto.class);
        assertThat(lotto.contains(0)).isEqualTo(false);
    }
}
