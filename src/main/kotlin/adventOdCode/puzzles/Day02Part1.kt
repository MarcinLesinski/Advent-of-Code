package adventOdCode.puzzles

import adventOdCode.domain.Lines
import adventOdCode.domain.Puzzle
import adventOdCode.puzzles.day02.InputParser
import adventOdCode.puzzles.day02.PasswordRule

class Day02Part1(input: Lines): Puzzle<Lines, Int>(input) {
    override fun solve(): Int {
        return input.map{InputParser.parse(it)}.filter{ isPasswordValid(it) }.count()
    }

    companion object{
        fun isPasswordValid(passwordRule: PasswordRule): Boolean
        {
            val charCount = countCharInString(passwordRule.character, passwordRule.password)
            val validRange = passwordRule.occurrence.atLeast..passwordRule.occurrence.atMost

            return charCount in validRange
        }

        private fun countCharInString(char: Char, string: String): Int{
            return string.count{ it == char }
        }

    }
}