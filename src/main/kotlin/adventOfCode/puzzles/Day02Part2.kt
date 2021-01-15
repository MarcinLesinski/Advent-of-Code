package adventOfCode.puzzles

import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.puzzles.day02.part2.InputParser
import adventOfCode.puzzles.day02.part2.PasswordRule

@Day(2, 2)
class Day02Part2(input: RawInput): Puzzle<Int>(input) {
    override fun solve(): Int {
        val parse = InputParser.Companion::parse

        return input
            .lines()
            .map(parse)
            .filter(::isPasswordValid)
            .count()
    }

    companion object{
        fun isPasswordValid(passwordRule: PasswordRule):  Boolean{
            val occurrences = passwordRule
                .occurrences
                .map{it-1}
                .filter{passwordRule.password[it] == passwordRule.character}
                .count()

            return occurrences == 1
        }
    }
}