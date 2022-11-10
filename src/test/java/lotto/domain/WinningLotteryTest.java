package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WinningLotteryTest {
    @DisplayName("중복값이 아닌 경우 값을 저장하고 있는다")
    @Test
    void case1() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertDoesNotThrow(() -> {
            WinningLottery winningLottery = WinningLottery.create(lotto);
            winningLottery.setBonusNumber(7);
            assertThat(winningLottery.getBonusNumber()).isEqualTo(7);
        });
    }

    @DisplayName("중복값인 경우 값을 IEA 예외를 발생시킨다")
    @Test
    void case2() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThrows(IllegalArgumentException.class, () -> {
            WinningLottery winningLottery = WinningLottery.create(lotto);
            winningLottery.setBonusNumber(6);
        });
    }

    @DisplayName("로또 값의 범위를 넘어간 경우 IEA 예외를 발생시킨다")
    @ParameterizedTest
    @ValueSource(ints = {0, 46, 33333})
    void case3(int givenInput) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThrows(IllegalArgumentException.class, () -> {
            WinningLottery winningLottery = WinningLottery.create(lotto);
            winningLottery.setBonusNumber(givenInput);
        });
    }
}
