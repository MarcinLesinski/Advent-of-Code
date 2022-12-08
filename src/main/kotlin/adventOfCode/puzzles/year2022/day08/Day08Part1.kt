package adventOfCode.puzzles.year2022.day08

import adventOfCode.common.Matrix
import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.domain.Year
import adventOfCode.domain.asLines
import adventOfCode.domain.asMatrix
import java.lang.Integer.max

@Year(2022)
@Day(8, 1)
internal class Day08Part1(input: RawInput) : Puzzle<Int>(input) {

    override fun solve(): Int {

        val forest: Matrix<Tree> = forest(input)
        val maxRow = forest.rows().size - 1
        val maxCol = forest.columns().size - 1

        forest.forEachFieldWithCoords{data, col, row ->
            if((col == 0) or (col == maxCol) or (row == 0) or (row == maxRow) )
                data.visible = true
        }

        forest.forEachColumn { scan(it) }
        forest.forEachRow { scan(it.toList()) }

        return forest.count { it.visible }
    }


}
fun scan(it: List<Tree>){
    it.fold(0){ highest, actualTree ->
        if (actualTree.visible.not()){
            actualTree.visible = actualTree.height > highest
        }

        val newHighest = max(highest, actualTree.height)
        newHighest
    }

    it.reversed().fold(0){ highest, actualTree ->
        if (actualTree.visible.not()){
            actualTree.visible = actualTree.height > highest
        }

        val newHighest = max(highest, actualTree.height)
        newHighest
    }
}


