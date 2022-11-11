package lotto.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.config.LottoConstants.LOTTO_END_INCLUSIVE;
import static lotto.config.LottoConstants.LOTTO_LENGTH;
import static lotto.config.LottoConstants.LOTTO_START_INCLUSIVE;

public class Lotto {
    private static final String LOTTERY_COUNT_ERROR = "당첨 번호가 6개가 아닙니다";
    private static final String LOTTERY_SIZE_ERROR =
            "당첨 번호가 " + LOTTO_START_INCLUSIVE + "부터 " + LOTTO_END_INCLUSIVE + "가 아닙니다";
    private static final String LOTTERY_DUPLICATE_ERROR = "당첨 번호에 중복이 있습니다";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
    }

    private void validate(List<Integer> numbers) {
        isProperLength(numbers);
        numbers.forEach(this::isInRange);
    }

    private void isProperLength(List<Integer> numbers) {
        if (numbers.size() != LOTTO_LENGTH.getValue()) {
            throw new IllegalArgumentException(LOTTERY_COUNT_ERROR);
        }
        if (numbers.stream().distinct().count() != LOTTO_LENGTH.getValue()) {
            throw new IllegalArgumentException(LOTTERY_DUPLICATE_ERROR);
        }
    }

    private void isInRange(Integer value) {
        if (value < LOTTO_START_INCLUSIVE.getValue()) {
            throw new IllegalArgumentException(LOTTERY_SIZE_ERROR);
        }
        if (value > LOTTO_END_INCLUSIVE.getValue()) {
            throw new IllegalArgumentException(LOTTERY_SIZE_ERROR);
        }
    }
    // TODO: 추가 기능 구현

    public int get(int index) {
        return numbers.get(index);
    }
}
