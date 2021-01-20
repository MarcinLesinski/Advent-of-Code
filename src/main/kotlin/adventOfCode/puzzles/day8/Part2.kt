package adventOfCode.puzzles.day8

import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.puzzles.day8.commands.Command
import adventOfCode.puzzles.day8.commands.Jmp
import adventOfCode.puzzles.day8.commands.Nop
import adventOfCode.puzzles.day8.commands.constructCommand
import adventOfCode.puzzles.day8.loopDetector.Analyzer
import adventOfCode.puzzles.day8.loopDetector.LastItemDetector

@Day(8, 2)
class Part2(input: RawInput): Puzzle<Int>(input) {

    override fun solve(): Int {
        val baseCommands = input.lines().map(::constructCommand)

        for(i in baseCommands.indices){
            val analyzer = Analyzer(LastItemDetector(baseCommands.lastIndex))
            val commands: MutableList<Command> = baseCommands.toMutableList()
            when(val command = commands[i]) {
                is Jmp -> {commands[i] = Nop(command.value) }
                is Nop -> {commands[i] = Jmp(command.value) }
            }
            val result = analyzer.analyze(commands)
            if (result.success){
                return result.accumulator
            }
        }
        error("")
    }
}