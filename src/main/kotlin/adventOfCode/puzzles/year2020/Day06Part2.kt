package adventOfCode.puzzles.year2020

import adventOfCode.domain.*
import adventOfCode.puzzles.year2020.day6.countAnswersWhichEveryoneVoted

@Year(2020) @Day(6, 2)
class Day06Part2(input: RawInput): Puzzle<Int>(input) {
    override fun solve(): Int {
        val groupAnswers = input.lines().splitBy { it.isBlank() }
        return groupAnswers.sumBy(::countAnswersWhichEveryoneVoted)
    }
}
