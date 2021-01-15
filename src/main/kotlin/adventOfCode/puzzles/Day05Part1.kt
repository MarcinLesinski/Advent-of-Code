package adventOfCode.puzzles

import adventOfCode.common.DataReader
import adventOfCode.domain.Day
import adventOfCode.domain.Lines
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.puzzles.day5.part1.findHighestIDSeat
import adventOfCode.puzzles.day5.common.parseInput

@Day(5, 1)
class Day05Part1(input: RawInput) : Puzzle<Int>(input) {
    override fun solve(): Int {
        val binarySpacePartitioningList = input.lines().map{ parseInput(it) }
        return findHighestIDSeat(binarySpacePartitioningList)
    }
}