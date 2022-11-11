package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static lotto.config.LottoConstants.LOTTO_END_INCLUSIVE;
import static lotto.config.LottoConstants.LOTTO_LENGTH;
import static lotto.config.LottoConstants.LOTTO_START_INCLUSIVE;

public class LottoGenerator {
    private final RandomNumbers randomNumbers;

    public LottoGenerator(RandomNumbers randomNumbers) {
        this.randomNumbers = randomNumbers;
    }

    public Lottos createLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        IntStream.range(0, count)
                .forEach(__ -> {
                    Lotto lotto = createLotto();
                    lottos.add(lotto);
                });
        return new Lottos(lottos);
    }

    private Lotto createLotto() {
        List<Integer> numbers = randomNumbers.pickUniqueNumbersInRange(
                LOTTO_START_INCLUSIVE.getValue(),
                LOTTO_END_INCLUSIVE.getValue(),
                LOTTO_LENGTH.getValue());
        return new Lotto(numbers);
    }
}
