package lotto.domain;

import java.util.List;

public interface LottoRandom {
    List<Integer> pickUniqueNumbersInRange(int startInclusive, int endInclusive, int count);
}
