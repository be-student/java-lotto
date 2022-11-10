package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    @DisplayName("로또를 생성한다")
    @Test
    void case1() {
        Lottos lottos = Lottos.createLottos(5, new MissionRandom());
        assertThat(lottos.getLottos().size()).isEqualTo(5);
    }
}
