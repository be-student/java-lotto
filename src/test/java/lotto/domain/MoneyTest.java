package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MoneyTest {
    @DisplayName("Money는 숫자가 1000으로 나누어 떨어지고, 0으로 되는 지를 검증하고 값객체로 만든다")
    @Test
    void case1() {
        assertThat(Money.from(1000)).isEqualTo(Money.from(1000));
    }

    @DisplayName("Money는 숫자가 올바르지 않다면 IEA 예외를 발생시킨다")
    @ValueSource(ints = {-1000, 234})
    @ParameterizedTest
    void case1(int givenInput) {
        assertThrows(IllegalArgumentException.class, () -> Money.from(givenInput));
    }
}
