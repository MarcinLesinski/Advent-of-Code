package adventOfCode.puzzles.year2021.day13

import adventOfCode.common.Matrix
import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.domain.Year
import adventOfCode.domain.asLines
import kotlin.math.max

@Year(2021)
@Day(13, 1)
internal class Day13Part1(input: RawInput) : Puzzle<Int>(input) {

    override fun solve(): Int {
        val (rawPoints, rawFolds) = input.split(System.lineSeparator()+ System.lineSeparator())
        val paper = PaperFactory(rawPoints.asLines()).construct()
        val folds = FoldsFactory(rawFolds.asLines()).construct()
        folds.take(1).forEach {
            when (it) {
                is VerticalFold -> paper.foldVertical(it.line)
                is HorizontalFold -> paper.foldHorizontal(it.line)
            }
            paper.drow()
        }
        return paper.dots()
    }
}
