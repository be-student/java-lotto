package lotto.domain;

import static lotto.config.LottoConstants.LOTTO_END_INCLUSIVE;
import static lotto.config.LottoConstants.LOTTO_START_INCLUSIVE;

public class LottoGenerator {
    private final LottoRandom random;

    private LottoGenerator(LottoRandom random) {
        this.random = random;
    }

    public static LottoGenerator getInstance(LottoRandom random) {
        return new LottoGenerator(random);
    }

    public Lotto generateLotto() {
        return new Lotto(random.pickUniqueNumbersInRange(LOTTO_START_INCLUSIVE, LOTTO_END_INCLUSIVE, 6));
    }
}
