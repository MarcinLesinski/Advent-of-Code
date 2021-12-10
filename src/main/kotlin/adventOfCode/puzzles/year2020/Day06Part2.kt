package adventOfCode.puzzles.year2020

import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.domain.Year
import adventOfCode.domain.splitBy
import adventOfCode.puzzles.year2020.day6.countAnswersWhichEveryoneVoted

@Year(2020) @Day(6, 2)
class Day06Part2(input: RawInput): Puzzle<Int>(input) {
    override fun solve(): Int {
        val groupAnswers = input.lines().splitBy { it.isBlank() }
        return groupAnswers.sumBy(::countAnswersWhichEveryoneVoted)
    }
}
