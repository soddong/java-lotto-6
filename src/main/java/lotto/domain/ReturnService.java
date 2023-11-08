package lotto.domain;

public class ReturnService {
    public String evaluateLottoReturn(int payment, int winningAmount) {
        float returns = ((float) winningAmount / payment) * 100;
        return String.format("%.1f%%", returns);
    }
}