package adventOfCode.puzzles.year2023.day07

import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.domain.Year

@Year(2023)
@Day(7, 2)
internal class Part2(input: RawInput) : Puzzle<Int>(input) {
    override fun solve(): Int {
        val lines = input.lines().map { it.split(" ") }.map { Data2(Hand2(it[0]), it[1].toInt()) }



        lines.forEachIndexed i@{ i, data1 ->
            lines.forEachIndexed j@{ j, data2 ->
                if (i == j) return@j
                if (data1.hand isGreater data2.hand) {
                    data1.rank += 1
                }
            }
        }

        return lines.map { it.points * (it.rank + 1) }.sum()
    }
}

private data class Data2(
    val hand: Hand2,
    val points: Int,
    var rank: Int = 0
)

private class Hand2(
    seed: String
) {
    private val _seed: CharArray = seed.toCharArray()

    fun score(): Int {
        val seq = _seed.groupBy { it }.toMutableMap()
        val jokers = seq['J']?.size ?: 0
        if (jokers == 5) return 6
        seq.remove('J')

        val seq2 = seq.map { it.value.size }.toMutableList()

        val max = seq2.max()
        val maxIndex = seq2.indexOfFirst { it == max }

        seq2[maxIndex] = seq2[maxIndex] + jokers

        return when {

            seq2.max() == 5 -> 6
            seq2.max() == 4 -> 5
            (seq2.max() == 3) and (seq2.min() == 2) -> 4
            seq2.max() == 3 -> 3
            seq2.count { it == 2 } == 1 -> 1
            seq2.count { it == 2 } == 2 -> 2
            seq2.max() == 1 -> 0

            else -> error("it shouldn't happened")
        }
    }

    private fun isGreaterWhenDraw(other: Hand2): Boolean {
        val base = { item: Char ->
            when (item) {
                '2' -> 2
                '3' -> 3
                '4' -> 4
                '5' -> 5
                '6' -> 6
                '7' -> 7
                '8' -> 8
                '9' -> 9
                'T' -> 10
                'J' -> 1
                'Q' -> 12
                'K' -> 13
                'A' -> 14
                else -> error("should not happen")

            }
        }

        val zip = this._seed.zip(other._seed)
        zip.forEach {
            if (base(it.first) > base(it.second)) return true
            if (base(it.first) < base(it.second)) return false
        }
        return false
    }

    infix fun isGreater(other: Hand2): Boolean {
        if (this.score() > other.score()) return true
        if (this.score() < other.score()) return false

        if (this.isGreaterWhenDraw(other)) return true

        return false
    }

}