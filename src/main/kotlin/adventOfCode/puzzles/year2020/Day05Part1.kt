package adventOfCode.puzzles.year2020

import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.domain.Year
import adventOfCode.puzzles.year2020.day5.common.parseInput
import adventOfCode.puzzles.year2020.day5.part1.findHighestIDSeat

@Year(2020) @Day(5, 1)
class Day05Part1(input: RawInput) : Puzzle<Int>(input) {
    override fun solve(): Int {
        val binarySpacePartitioningList = input.lines().map{ parseInput(it) }
        return findHighestIDSeat(binarySpacePartitioningList)
    }
}
