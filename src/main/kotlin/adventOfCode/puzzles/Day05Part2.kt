package adventOfCode.puzzles

import adventOfCode.common.DataReader
import adventOfCode.domain.Day
import adventOfCode.domain.Lines
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.puzzles.day5.common.SeatDecoder
import adventOfCode.puzzles.day5.common.parseInput
import adventOfCode.puzzles.day5.part2.Analysis

@Day(5, 2)
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