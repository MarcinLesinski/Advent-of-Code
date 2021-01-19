package adventOfCode.puzzles.day8

import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.puzzles.day8.commands.constructCommand
import adventOfCode.puzzles.day8.loopDetector.Analyzer
import adventOfCode.puzzles.day8.loopDetector.LoopDetector

@Day(8, 1)
class Part1(input: RawInput) : Puzzle<Int>(input) {
    override fun solve(): Int {
        val commands = input.lines().map(::constructCommand)
        return Analyzer(LoopDetector()).analyze(commands).accumulator
    }
}