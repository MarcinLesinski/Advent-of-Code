package adventOfCode.puzzles.year2022.day08

import adventOfCode.common.Matrix
import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.domain.Year
import adventOfCode.domain.asLines
import java.lang.Integer.max

@Year(2022)
@Day(8, 2)
internal class Day08Part2(input: RawInput): Puzzle<Int>(input)  {
    override fun solve(): Int {

        val lines = input.trimIndent().asLines()

        val seed: Array<Array<Tree>> = lines.map{
            it.toCharArray().map{ ch ->
                Tree(ch.digitToInt())
            }.toTypedArray()
        }.toTypedArray()

        val forest = Matrix(lines[0].length, lines.size, seed)

        forest.forEachColumn {
            scenLine(it)
        }
        forest.forEachRow {
            scenLine(it.toList())
        }

        var max = -1
        lateinit var tree: Tree
        forest.forEachField {
            println("${it.height} ${it.scenic}")
            if (it.scenic > max)
                max = it.scenic
            tree= it
        }
        println(tree.height)

        return max
    }
}

fun scenLine(list: List<Tree>) {
    list.indices.forEach {
        val scenn = scen(it, list)
        list[it].scenic *= scenn
    }
}

fun scen(index: Int, list: List<Tree>): Int {
    val rightView = list.subList(index+1, list.size)
    val lefttView = list.subList(0, index).reversed()
    val house = list[index]

    val count1 = scanSide(house.height, rightView)
    val count2 = scanSide(house.height, lefttView)


    return count1 * count2
}

fun scanSide(height: Int, list: List<Tree>): Int {
    var count = 0
    list.forEach {
        count++
        if (it.height >= height)
            return count
    }

    return count
}
