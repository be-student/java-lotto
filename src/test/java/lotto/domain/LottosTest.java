package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    @DisplayName("로또를 생성한다")
    @Test
    void case1() {
        List<Lotto> lottoArgument = LottoGenerator.getInstance(new MissionRandom()).generateLotto(5);
        Lottos lottos = Lottos.from(lottoArgument);
        assertThat(lottos.getLottos().size()).isEqualTo(5);
    }
}
