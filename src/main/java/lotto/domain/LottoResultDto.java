package lotto.domain;

import java.util.List;

public class LottoResultDto {

    private final List<List<Integer>> lottos;

    public LottoResultDto(List<List<Integer>> lottos) {
        this.lottos = lottos;
    }

    public List<List<Integer>> getLottos() {
        return lottos;
    }
}
