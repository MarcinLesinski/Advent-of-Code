package adventOfCode.puzzles

import adventOfCode.domain.*
import adventOfCode.puzzles.day02.part1.InputParser
import adventOfCode.puzzles.day02.part1.PasswordRule
import kotlin.text.lines

@Day(2,1 )
class Day02Part1(input: RawInput): Puzzle<Int>(input) {
    override fun solve(): Int {
        return input.asLines().map{ InputParser.parse(it)}.filter{ isPasswordValid(it) }.count()
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