package adventOfCode.puzzles.year2020

import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.domain.Year
import adventOfCode.domain.splitBy
import adventOfCode.puzzles.year2020.day6.countAnswersWithAtLeastOneVote

@Year(2020) @Day(6, 1)
class Day06Part1(input: RawInput): Puzzle<Int>(input) {
    override fun solve(): Int {
        val groupAnswers = input.lines().splitBy { it.isBlank() }
        return groupAnswers.sumBy(::countAnswersWithAtLeastOneVote)
    }
}
