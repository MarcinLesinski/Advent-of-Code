package adventOfCode.puzzles.year2022.day08

import adventOfCode.common.Matrix
import adventOfCode.domain.RawInput
import adventOfCode.domain.asLines

class Tree(val height: Int, var visible: Boolean = false, var scenic: Int = 1)

fun forest(input: RawInput): Matrix<Tree> {
    val lines = input.trimIndent().asLines()

    val seed: Array<Array<Tree>> = lines.map{
        it.toCharArray().map{ ch ->
            Tree(ch.digitToInt())
        }.toTypedArray()
    }.toTypedArray()

    return Matrix(lines[0].length, lines.size, seed)
}
