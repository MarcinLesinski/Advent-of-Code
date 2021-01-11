package adventOdCode.puzzles

import adventOdCode.common.DataReader
import adventOdCode.domain.Lines
import adventOdCode.domain.Puzzle
import adventOdCode.puzzles.day5.part1.findHighestIDSeat
import adventOdCode.puzzles.day5.common.parseInput

class Day05Part1(input: Lines) : Puzzle<Lines, Int>(input) {
    override fun solve(): Int {
        val input = DataReader.readData(5)
        val binarySpacePartitioningList = input.map{ parseInput(it) }
        return findHighestIDSeat(binarySpacePartitioningList)
    }
}