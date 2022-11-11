package lotto.view;

import lotto.domain.LottoScoreDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoScoreDtoTest {
    @DisplayName("score 를 그대로 반환할 수 있다")
    @Test
    void case1() {
        LottoScoreDto lottoScoreDto = new LottoScoreDto(3, 4,
                5, 6, 7, 0.36);
        assertThat(lottoScoreDto.getThreeCorrect()).isEqualTo(3);
        assertThat(lottoScoreDto.getFourCorrect()).isEqualTo(4);
        assertThat(lottoScoreDto.getFiveCorrect()).isEqualTo(5);
        assertThat(lottoScoreDto.getFiveBonusCorrect()).isEqualTo(6);
        assertThat(lottoScoreDto.getSixCorrect()).isEqualTo(7);
        assertThat(lottoScoreDto.getRate()).isEqualTo(0.36);
    }
}
