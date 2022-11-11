package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {
    @DisplayName("길이만큼의 로또를 반환함")
    @Test
    void case1() {
        Lottos lottos = new LottoGenerator(new MissionRandom()).createLottos(100);
        assertThat(lottos.getLottos().size()).isEqualTo(100);
    }
}
