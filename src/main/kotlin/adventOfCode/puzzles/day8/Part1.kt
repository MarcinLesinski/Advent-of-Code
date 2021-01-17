package adventOfCode.puzzles.day8

import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.puzzles.day8.commands.constructCommand

@Day(8, 1)
class Part1(input: RawInput): Puzzle<Int>(input) {
    override fun solve(): Int {
        val commands = input.lines().map(::constructCommand )
        return LoopDetector().detect(commands).accumulator
    }
}