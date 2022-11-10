package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Lottos {
    private final LottoRandom lottoGenerator;
    private List<Lotto> lottos = new ArrayList<>();

    private Lottos(int count, LottoRandom lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
        IntStream.range(0, count).forEach((index) -> {
            Lotto generated = LottoGenerator.getInstance(lottoGenerator).generateLotto();
            lottos.add(generated);
        });
    }

    public static Lottos createLottos(int number, LottoRandom randomGenerator) {
        return new Lottos(number, randomGenerator);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
