package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = Collections.unmodifiableList(lottos);
    }

    /**
     * 불변의 리스트에 담아서 줌
     *
     * @return 불변의 리스트
     */
    public List<Lotto> getLottos() {
        return lottos;
    }
}
