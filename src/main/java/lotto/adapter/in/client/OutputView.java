package lotto.adapter.in.client;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.LottoResultDto;
import lotto.domain.LottosDto;

public class OutputView {

    private static final String LOTTO_SEPARATOR = ", ";
    private static final String LOTTO_START = "[";
    private static final String LOTTO_END = "]";

    public void printAllLottos(LottosDto lottoResultDto) {
        System.out.printf("%d개를 구매했습니다.", lottoResultDto.getLottos().size());
        List<List<Integer>> lottos = lottoResultDto.getLottos();
        lottos.forEach(this::printOneLotto);
    }

    private void printOneLotto(List<Integer> lotto) {
        String printableLotto = lotto.stream()
                .sorted(Comparator.naturalOrder())
                .map(String::valueOf)
                .collect(Collectors.joining(LOTTO_SEPARATOR));
        System.out.printf(LOTTO_START + printableLotto + LOTTO_END);
    }

    public void printStatistics(LottoResultDto lottoResultDto) {

    }

}
