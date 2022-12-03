package lotto.adapter.in.client;

import lotto.application.port.in.LottoUseCase;

public class LottoClient {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoUseCase lottoUseCase;

    public LottoClient(InputView inputView, OutputView outputView, LottoUseCase lottoUseCase) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoUseCase = lottoUseCase;
    }

    public void run() {
        buyLotto();
        getAllLottos();
        changeWinningNumbers();
        changeBonusNumber();
        printStatistic();
    }

    private void buyLotto() {
    }

    private void getAllLottos() {
    }

    private void changeWinningNumbers() {
    }


    private void changeBonusNumber() {
    }

    private void printStatistic() {
    }
}
