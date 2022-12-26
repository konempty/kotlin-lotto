package lotto.model

import lotto.model.LottoPrize.FIFTH
import lotto.model.LottoPrize.FIRST
import lotto.model.LottoPrize.NONE
import lotto.model.WinningNumbers.Companion.of
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class LottosTest {
    @Test
    internal fun `당첨번호 갯수에 맞는 결과를 가져온다`() {
        val first = Lotto.of(1, 2, 3, 4, 5, 6)
        val fourth = Lotto.of(1, 2, 3, 7, 8, 9)
        val none = Lotto.of(7, 8, 9, 10, 11, 12)
        val lottos = Lottos(listOf(first, fourth, fourth, fourth, none, none))

        val dummyNumber = 46
        val winningNumbers = of(Lotto.of(1, 2, 3, 4, 5, 6), dummyNumber)

        val winningResult = WinningResult.of(lottos, winningNumbers)

        assertThat(winningResult.getCountOf(FIRST)).isEqualTo(1)
        assertThat(winningResult.getCountOf(FIFTH)).isEqualTo(3)
        assertThat(winningResult.getCountOf(NONE)).isEqualTo(2)
        assertThat(winningResult.getTotalWinningAmount()).isEqualTo(BigDecimal(2_000_015_000))
        assertThat(winningResult.getReturnRatio()).isEqualTo(BigDecimal("333335.83"))
    }
}