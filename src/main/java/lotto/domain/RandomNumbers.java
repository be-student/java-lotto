package lotto.domain;

import java.util.List;

public interface RandomNumbers {
    List<Integer> pickUniqueNumbersInRange(int startInclusive, int endInclusive, int count);
}
