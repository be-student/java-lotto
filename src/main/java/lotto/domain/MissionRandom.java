package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class MissionRandom implements RandomNumbers {
    @Override
    public List<Integer> pickUniqueNumbersInRange(int startInclusive, int endInclusive, int count) {
        return Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count);
    }
}
