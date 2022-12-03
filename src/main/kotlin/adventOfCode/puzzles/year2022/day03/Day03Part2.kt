package adventOfCode.puzzles.year2022.day03

import adventOfCode.common.commonItems
import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.domain.Year
import adventOfCode.domain.asLines
import adventOfCode.domain.asNumbers
import adventOfCode.domain.forEachPair
import adventOfCode.puzzles.year2022.day02.Result.Companion.of

@Year(2022)
@Day(3, 2)
internal class Day03Part2(input: RawInput): Puzzle<Int>(input)  {
    override fun solve(): Int {
        return input
            .asLines()
            .map{ it.toList() }
            .windowed(3, 3)
            .map{ commonItems(it[0], it[1], it[2])[0] }
            .map{points(it) }
            .sum()
    }
}

