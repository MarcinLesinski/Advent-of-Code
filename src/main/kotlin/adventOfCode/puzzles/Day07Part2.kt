package adventOfCode.puzzles

import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.puzzles.day7.Color
import adventOfCode.puzzles.day7.dataParser.DataParser
import adventOfCode.puzzles.day7.findByColor
import adventOfCode.puzzles.day7.suitable

@Day(7, 2)
class Day07Part2(input: RawInput): Puzzle<Int>(input) {
    override fun solve(): Int {
        val bags = DataParser().parse(input.lines())
        return bags.findByColor(Color("shiny", "gold")).size()
    }
}