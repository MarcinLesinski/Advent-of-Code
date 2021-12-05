package adventOfCode.puzzles.year2021.day02

import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.domain.Year
import adventOfCode.domain.asLines
import adventOfCode.domain.split
import adventOfCode.puzzles.year2021.day02.part2.Command
import adventOfCode.puzzles.year2021.day02.part2.Down
import adventOfCode.puzzles.year2021.day02.part2.Forward
import adventOfCode.puzzles.year2021.day02.part2.Position
import adventOfCode.puzzles.year2021.day02.part2.Up

@Year(2021)
@Day(2, 2)
internal class Day02Part2(input: RawInput): Puzzle<Int>(input) {
    override fun solve(): Int {
        val position = Position()
        val commands = input.asLines().map{ command(it, position)}

        commands.forEach{ it.run()}

        return position.depth * position.horizontal
    }
}

private fun command(line: String, position: Position): Command {
    val (commandName, valueStr) = line.split()
    val value = valueStr.toInt()

    return when(commandName){
        "forward" -> Forward(value, position)
        "up" -> Up(value, position)
        "down" -> Down(value, position)
        else -> error("Invalid command name")
    }
}
