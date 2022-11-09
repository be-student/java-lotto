package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoScoreDtoTest {
    @DisplayName("LottoScoreDto 클래스")
    @Test
    void LottoScoreDto_클래스는_정보를_잘_저장한다() {
        LottoScoreDto lottoScoreDto = new LottoScoreDto(3, 4, 5, 1, 2, 3.543);
        assertThat(lottoScoreDto.getThree()).isEqualTo(3);
        assertThat(lottoScoreDto.getFour()).isEqualTo(4);
        assertThat(lottoScoreDto.getFive()).isEqualTo(5);
        assertThat(lottoScoreDto.getFiveBonus()).isEqualTo(1);
        assertThat(lottoScoreDto.getSix()).isEqualTo(2);
        assertThat(lottoScoreDto.getRate()).isEqualTo(3.543);
    }
}
