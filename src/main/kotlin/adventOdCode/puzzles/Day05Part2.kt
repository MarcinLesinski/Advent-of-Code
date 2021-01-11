package adventOdCode.puzzles

import adventOdCode.common.DataReader
import adventOdCode.domain.Lines
import adventOdCode.domain.Puzzle
import adventOdCode.puzzles.day5.common.SeatDecoder
import adventOdCode.puzzles.day5.common.parseInput
import adventOdCode.puzzles.day5.part2.Analysis
import kotlin.math.absoluteValue

class Day05Part2(input: Lines) : Puzzle<Lines, Int>(input) {

    override fun solve(): Int {
        val input = DataReader.readData(5)
        val binarySpacePartitioningList = input.map { parseInput(it) }
        val ids = binarySpacePartitioningList.map { SeatDecoder(7, 3).decode(it) }.sorted()
        val analysis = Analysis()

        ids.forEach(analysis::next)

        return if (analysis.hasResult)
            analysis.result
        else
            throw error("Something went wrong, puzzle can not be solved")
    }
}