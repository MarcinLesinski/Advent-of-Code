package adventOfCode.puzzles.year2021.day13

import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.domain.Year
import adventOfCode.domain.asLines
import adventOfCode.domain.asMatrix
import java.util.ArrayDeque

@Year(2021)
@Day(13, 2)
internal class Day13Part2(input: RawInput) : Puzzle<Int>(input) {

    override fun solve(): Int {
        val (rawPoints, rawFolds) = input.split(System.lineSeparator()+ System.lineSeparator())
        val paper = PaperFactory(rawPoints.asLines()).construct()
        val folds = FoldsFactory(rawFolds.asLines()).construct()
        folds.forEach {
            when (it) {
                is VerticalFold -> paper.foldVertical(it.line)
                is HorizontalFold -> paper.foldHorizontal(it.line)
            }
            paper.drow()
        }
        return paper.dots()
    }
}

