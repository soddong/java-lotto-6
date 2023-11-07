package lotto.domain;

import java.util.Arrays;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import lotto.validator.CSVNumbersValidator;

public class InputView {
    private InputView() {
    }

    public static List<Integer> inputWinningNumbers() {
        return Arrays.stream(Console.readLine().split(","))
                    .map(Integer::parseInt)
                    .toList();
    }

    public static int inputBonusNumber() {
        return Integer.parseInt(Console.readLine());
    }
}
