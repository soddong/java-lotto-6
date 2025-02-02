package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import lotto.constants.RankConstants;
import lotto.domain.Lotto;
import lotto.domain.LottoRankEvaluator;
import lotto.dto.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoRankEvaluatorTest {
    @DisplayName("1등부터 5등까지 당첨번호와 비교하여 추첨할 수 있다.")
    @ParameterizedTest
    @MethodSource("provideLottoNumbersAndRanks")
    void isHasBonusNumber(Lotto userLotto, RankConstants expectedRank) {
        //given
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(2, 5, 6, 7, 14, 31)), 8);
        LottoRankEvaluator lottoRankEvaluator = new LottoRankEvaluator(winningLotto);

        //when
        RankConstants lottoRank = lottoRankEvaluator.compareWithWinningLotto(userLotto);

        //then
        assertThat(lottoRank).isEqualTo(expectedRank);
    }

    private static Stream<Arguments> provideLottoNumbersAndRanks() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(2, 5, 6, 32, 33, 34)), RankConstants.FIFTH),
                Arguments.of(new Lotto(List.of(2, 5, 6, 7, 33, 34)), RankConstants.FOURTH),
                Arguments.of(new Lotto(List.of(2, 5, 6, 7, 14, 34)), RankConstants.THIRD),
                Arguments.of(new Lotto(List.of(2, 5, 6, 7, 14, 8)), RankConstants.SECOND),
                Arguments.of(new Lotto(List.of(2, 5, 6, 7, 14, 31)), RankConstants.FIRST)
        );
    }

}