package adventOfCode.puzzles.year2021.day04

import adventOfCode.common.Matrix
import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.domain.Year
import adventOfCode.domain.asLines
import adventOfCode.domain.asNumbers

@Year(2021)
@Day(4, 1)
internal class Day04Part1(input: RawInput) : Puzzle<Int>(input) {
    private var result = null
    override fun solve(): Int {
        val numbers = input.asLines()[0].replace(",", System.lineSeparator()).asNumbers()
        val boards = readBoards(input)
        numbers.forEach{ number ->
            boards.forEach { board ->
                board.mark(number)
                if (board.won)
                    return board.score
            }
        }

        error("end od number and no one won")
    }
}

