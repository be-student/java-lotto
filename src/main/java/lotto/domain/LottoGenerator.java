package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

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

    public List<Lotto> generateLotto(int count) {
        List<Lotto> lottos = new ArrayList<>();
        IntStream.range(0, count).forEach((__) -> {
            List<Integer> randoms = random.pickUniqueNumbersInRange(LOTTO_START_INCLUSIVE, LOTTO_END_INCLUSIVE, 6);
            Lotto lotto = new Lotto(randoms);
            lottos.add(lotto);
        });
        return lottos;
    }
}
