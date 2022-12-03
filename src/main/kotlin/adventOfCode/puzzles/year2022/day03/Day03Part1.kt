package adventOfCode.puzzles.year2022.day03

import adventOfCode.common.commonItems
import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.domain.Year
import adventOfCode.domain.asLines
import adventOfCode.domain.asNumbers

@Year(2022)
@Day(3, 1)
internal class Day03Part1(input: RawInput) : Puzzle<Int>(input) {
        override fun solve(): Int {
            return input
                .asLines()
                .map{ it.toList() }
                .map{ listOf(it.take(it.size/2), it.takeLast(it.size/2)  )  }
                .map{ commonItems(it[0], it[1])[0] }
                .map{points(it) }
                .sum()
    }
}


