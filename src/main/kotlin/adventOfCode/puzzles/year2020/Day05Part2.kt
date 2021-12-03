package adventOfCode.puzzles.year2020

import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.domain.Year
import adventOfCode.puzzles.year2020.day5.common.SeatDecoder
import adventOfCode.puzzles.year2020.day5.common.parseInput
import adventOfCode.puzzles.year2020.day5.part2.Analysis

@Year(2020) @Day(5, 2)
class Day05Part2(input: RawInput) : Puzzle<Int>(input) {

    override fun solve(): Int {
        val binarySpacePartitioningList = input.lines().map { parseInput(it) }
        val ids = binarySpacePartitioningList.map { SeatDecoder(7, 3).decode(it) }.sorted()
        val analysis = Analysis()

        ids.forEach(analysis::next)

        return if (analysis.hasResult)
            analysis.result
        else
            throw error("Something went wrong, puzzle can not be solved")
    }
}
