package lotto.view;

import handler.MockInputHandler;
import lotto.domain.Lotto;
import lotto.domain.Money;
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

    @DisplayName("isAmountValidate 메서드는 입력으로 받은 문자열이 0같거나 크고 1000으로 떨어지는지 검증하고 숫자를 반환한다.")
    @Test
    void case1() {
        mockInputHandler.setExpected("1000");
        assertThat(new InputView(mockInputHandler).inputAmount()).isEqualTo(Money.from(1000));
    }

    @DisplayName("isAmountValidate 메서드는 입력으로 받은 문자열이 올바른 금액이 아니라면 IEA예외를 발생시킨다")
    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", "asdf", "-1000", "234"})
    void case2(String givenInput) {
        mockInputHandler.setExpected(givenInput);
        assertThrows(IllegalArgumentException.class, () -> new InputView(mockInputHandler).inputAmount());
    }

    @DisplayName("inputLotto 메서드는 로또가 될 수 있는지를 검증하고 Lotto를 반환함")
    @Test
    void case3() {
        mockInputHandler.setExpected("1,2,3,4,5,6");
        assertThat(new InputView(mockInputHandler).inputLotto()).isExactlyInstanceOf(Lotto.class);
    }


    @DisplayName("isLottoNumberValid 메서드는 입력으로 받은 문자열이 Lotto가 될 수 없다면 IEA 예외를 만듦")
    @NullSource
    @ValueSource(strings = {"", "asdf", "234,23", "55,1,2,3,4,5", "1,2,3,4,5,5"})
    @ParameterizedTest
    void case4(String givenInput) {
        mockInputHandler.setExpected(givenInput);
        assertThrows(IllegalArgumentException.class, () -> new InputView(mockInputHandler).inputLotto());
    }

    @DisplayName("isBonusNumberValid 메서드는 입력으로 받은 문자열이 숫자인지를 검증한다")
    @Test
    void case5() {
        mockInputHandler.setExpected("234");
        assertThat(new InputView(mockInputHandler).inputBonus()).isEqualTo(234);
    }

    @DisplayName("isBonusNumberValid 메서드는 입력으로 받은 문자열이 숫자가 아니라면 IEA 예외를 만듦")
    @NullSource
    @ValueSource(strings = {"", "asdf", "q2sdf"})
    @ParameterizedTest
    void case5(String givenInput) {
        mockInputHandler.setExpected(givenInput);
        assertThrows(IllegalArgumentException.class, () -> new InputView(mockInputHandler).inputBonus());
    }
}
