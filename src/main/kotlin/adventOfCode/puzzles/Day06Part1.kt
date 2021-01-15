package adventOfCode.puzzles

import adventOfCode.domain.*
import adventOfCode.puzzles.day6.countAnswersWithAtLeastOneVote

@Day(6, 1)
class Day06Part1(input: RawInput): Puzzle<Int>(input) {
    override fun solve(): Int {
        val groupAnswers = input.lines().splitBy { it.isBlank() }
        return groupAnswers.sumBy(::countAnswersWithAtLeastOneVote)
    }
}