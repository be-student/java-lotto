package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {
    private static final List<Integer> temp = List.of(1, 2, 3, 4, 5, 6);
    private LottoRandom random;

    @BeforeEach
    void setUp() {
        random = new LottoRandom() {

            @Override
            public List<Integer> pickUniqueNumbersInRange(int startInclusive, int endInclusive, int count) {
                return IntStream.range(startInclusive, startInclusive + 6).boxed().collect(Collectors.toList());
            }
        };
    }

    @DisplayName("로또 값을 생성한다")
    @Test
    void case1() {
        Lotto lotto = LottoGenerator.getInstance(random).generateLotto();
        assertThat(lotto.printableString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}
