package lotto;

import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoGameStarter lottoGameStarter = new LottoGameStarter(InputView.inputPurchaseAmount());
        lottoGameStarter.start();
    }
}
