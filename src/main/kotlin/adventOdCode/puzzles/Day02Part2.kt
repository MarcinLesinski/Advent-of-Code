package adventOdCode.puzzles

import adventOdCode.domain.Lines
import adventOdCode.domain.Puzzle
import adventOdCode.puzzles.day02.part2.InputParser
import adventOdCode.puzzles.day02.part2.PasswordRule

class Day02Part2(input: Lines): Puzzle<Lines, Int>(input) {
    override fun solve(): Int {
        val parse = InputParser.Companion::parse

        return input
            .map(parse)
            .filter(::isPasswordValid)
            .count()
    }

    companion object{
        fun isPasswordValid(passwordRule: PasswordRule):  Boolean{
            val occurances = passwordRule
                .occurrences
                .map{it-1}
                .filter{passwordRule.password[it] == passwordRule.character}
                .count()

            return occurances == 1
        }
    }
}