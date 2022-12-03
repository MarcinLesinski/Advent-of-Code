package adventOfCode.puzzles.year2022.day02

import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.domain.Year
import adventOfCode.domain.asLines
import adventOfCode.puzzles.year2022.day02.Result.Companion.of

@Year(2022)
@Day(2, 2)
internal class Day02Part2(input: RawInput): Puzzle<Int>(input)  {
    override fun solve(): Int {
        return input
            .asLines()
            .map {
                val predictedResult = of(it[2])
                val yourChoose = Choose.of(it[0])
                val mineChoose = predictedResult.suitingChoose(yourChoose)
                Match(mineChoose, yourChoose)
            }
            .map { it.points() }
            .sum()
    }
}
