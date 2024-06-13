package adventOfCode.puzzles.year2023.day07

import adventOfCode.domain.*
import kotlin.text.split

@Year(2023)
@Day(7, 1)
internal class Part1(input: RawInput) : Puzzle<Int>(input) {
    override fun solve(): Int {
        val lines = input.lines().map { it.split(" ") }.map { Data(Hand(it[0]), it[1].toInt()) }



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

private data class Data(
    val hand: Hand,
    val points: Int,
    var rank: Int = 0
)

private class Hand(
    seed: String
) {
    private val _seed: CharArray = seed.toCharArray()

    fun score(): Int {
        val seq = _seed.groupBy { it }.map { it.value.size }

        return when {
            seq.max() == 5 -> 6
            seq.max() == 4 -> 5
            (seq.max() == 3) and (seq.min() == 2) -> 4
            seq.max() == 3 -> 3
            seq.count { it == 2 } == 2 -> 2
            seq.count { it == 2 } == 1 -> 1
            seq.max() == 1 -> 0

            else -> error("it shouldn't happened")
        }
    }

    private fun isGreaterWhenDraw(other: Hand): Boolean {
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
                'J' -> 11
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

    infix fun isGreater(other: Hand): Boolean {
        if (this.score() > other.score()) return true
        if (this.score() < other.score()) return false

        if (this.isGreaterWhenDraw(other)) return true

        return false
    }

}