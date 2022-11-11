package lotto.domain;

import lotto.config.ErrorMessages;

public class LottoException {
    private LottoException() {
    }

    public static IllegalArgumentException create(ErrorMessages errorMessages) {
        return new IllegalArgumentException(errorMessages.getErrorMessage());
    }
}
