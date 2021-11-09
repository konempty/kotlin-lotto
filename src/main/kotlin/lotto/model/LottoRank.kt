package lotto.model

/**
 * 로또 등수와 상금 정리한 클래스
 * */
enum class LottoRank(
    val countOfMatch: Int,
    val winningMoney: Int,
    val moneyUnion: String = "원",
) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    companion object {
        private const val BONUS_NUMBER_MATCH_COUNT = 5

        private fun isBonusRank(isBonusNumber: Boolean): LottoRank =
            if (isBonusNumber) SECOND else THIRD

        fun getRankListByMoneyExceptValue(exceptMoney: Int): List<LottoRank> {
            return values()
                .filter { it.winningMoney != exceptMoney }
                .sortedBy { it.winningMoney }
        }
        fun getRankCount(list: HashMap<LottoRank, Int>, rank: LottoRank): Int = list[rank] ?: 0
        fun getRankProfit(list: HashMap<LottoRank, Int>, rank: LottoRank): Int = (getRankCount(list, rank) * rank.winningMoney)

        fun findMatchRank(number: Int, isBonusNumber: Boolean = false): LottoRank {
            return values()
                .find {
                    when (number) {
                        BONUS_NUMBER_MATCH_COUNT -> it == isBonusRank(isBonusNumber)
                        else -> it.countOfMatch == number
                    }
                } ?: MISS
        }
    }
}