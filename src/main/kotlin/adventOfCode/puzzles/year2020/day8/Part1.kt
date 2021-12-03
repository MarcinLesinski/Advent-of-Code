package adventOfCode.puzzles.year2020.day8

import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.domain.Year
import adventOfCode.puzzles.year2020.day8.commands.constructCommand
import adventOfCode.puzzles.year2020.day8.loopDetector.Analyzer
import adventOfCode.puzzles.year2020.day8.loopDetector.LoopDetector

@Year(2020) @Day(8, 1)
class Part1(input: RawInput) : Puzzle<Int>(input) {
    override fun solve(): Int {
        val commands = input.lines().map(::constructCommand)
        return Analyzer(LoopDetector()).analyze(commands).accumulator
    }
}
