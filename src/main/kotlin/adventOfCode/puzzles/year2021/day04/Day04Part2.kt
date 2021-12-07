package adventOfCode.puzzles.year2021.day04

import adventOfCode.common.Matrix
import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.domain.Year
import adventOfCode.domain.asLines
import adventOfCode.domain.asNumbers

@Year(2021)
@Day(4, 2)
internal class Day04Part2(input: RawInput) : Puzzle<Int>(input) {
    override fun solve(): Int {
        var result = 0
        val numbers = input.asLines()[0].replace(",", System.lineSeparator()).asNumbers()
        val boards = readBoards(input)
        numbers.forEach{ number ->
            boards.filter{ !it.won }.forEach { board ->
                board.mark(number)
                if (board.won) {
                    result = board.score
                }
            }
        }
        return result
    }
}

