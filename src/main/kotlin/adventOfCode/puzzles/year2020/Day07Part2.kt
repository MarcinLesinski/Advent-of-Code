package adventOfCode.puzzles.year2020

import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.domain.Year
import adventOfCode.puzzles.year2020.day7.Color
import adventOfCode.puzzles.year2020.day7.dataParser.DataParser
import adventOfCode.puzzles.year2020.day7.findByColor

@Year(2020) @Day(7, 2)
class Day07Part2(input: RawInput): Puzzle<Int>(input) {
    override fun solve(): Int {
        val bags = DataParser().parse(input.lines())
        return bags.findByColor(Color("shiny", "gold")).size()
    }
}
