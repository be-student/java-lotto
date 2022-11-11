package lotto.view;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputValidatorTest {
    @DisplayName("validateAmount 메서드는 구입 금액이 1000의 배수가 아니라면 않으면 예외를 발생시킨다")
    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", "-234", "234", "a1000"})
    void case1(String givenInput) {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateAmount(givenInput));
    }

    @DisplayName("validateAmount 메서드는 구입 금액이 올바르다면 숫자를 반환한다")
    @Test
    void case2() {
        assertThat(InputValidator.validateAmount("1000")).isEqualTo(1000);
    }

    @DisplayName("validateLotteryNumbers 메서드는 로또 번호로 변환할 수 있는 형식이 아니면 예외를 발생시킨다")
    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", "-234", "1,2,3,4,5,6,", "1,1,2,3,4,5"})
    void case3(String givenInput) {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateLotteryNumbers(givenInput));
    }

    @DisplayName("validateLotteryNumbers 메서드는 로또 번호로 변환할 수 있는 형식이라면 로또 객체를 반환한다")
    @Test
    void case4() {
        Lotto lotto = InputValidator.validateLotteryNumbers("6,2,3,4,5,1");
        assertThat(lotto).isExactlyInstanceOf(Lotto.class);
        assertThat(lotto.contains(0)).isEqualTo(false);
    }
}
