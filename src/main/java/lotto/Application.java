package lotto;

import lotto.adapter.in.client.InputView;
import lotto.adapter.in.client.LottoClient;
import lotto.adapter.in.client.OutputView;
import lotto.application.service.LottoApplication;
import lotto.domain.LottoGenerator;
import lotto.domain.RandomLottoNumbersGenerator;

public class Application {

    public static void main(String[] args) {
        new LottoClient(new InputView(), new OutputView(),
                new LottoApplication(new LottoGenerator(new RandomLottoNumbersGenerator()))).run();

    }
}
