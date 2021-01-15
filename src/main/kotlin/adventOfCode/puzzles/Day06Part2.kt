package adventOfCode.puzzles

import adventOfCode.domain.*
import adventOfCode.puzzles.day6.countAnswersWhichEveryoneVoted

@Day(6, 2)
class Day06Part2(input: RawInput): Puzzle<Int>(input) {
    override fun solve(): Int {
        val groupAnswers = input.lines().splitBy { it.isBlank() }
        return groupAnswers.sumBy(::countAnswersWhichEveryoneVoted)
    }
}