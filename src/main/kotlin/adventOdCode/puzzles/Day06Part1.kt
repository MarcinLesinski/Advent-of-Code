package adventOdCode.puzzles

import adventOdCode.domain.Lines
import adventOdCode.domain.Puzzle
import adventOdCode.domain.splitBy
import adventOdCode.puzzles.day6.countAnswersWithAtLeastOneVote

class Day06Part1(input: Lines): Puzzle<Lines, Int>(input) {
    override fun solve(): Int {
        val groupAnswers = input.splitBy { it.isBlank() }
        return groupAnswers.sumBy(::countAnswersWithAtLeastOneVote)
    }
}