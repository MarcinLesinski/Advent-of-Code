package adventOfCode.puzzles.year2021.day14

import adventOfCode.common.Matrix
import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.domain.Year
import adventOfCode.domain.asLines
import adventOfCode.domain.split
import kotlin.math.max

@Year(2021)
@Day(14, 1)
internal class Day14Part1(input: RawInput) : Puzzle<Int>(input) {

    override fun solve(): Int {
        var (template, insertionsText) = input.split(System.lineSeparator() + System.lineSeparator())
        val insertions = Factory(insertionsText.asLines()).construct()

        val operations = mutableListOf<Pair<Char, Int>>()
        var index = 0
        repeat(10){
            template.windowed(2, 1).forEach{

                val l = it[0]
                val r = it[1]
                val insertion = insertions.firstOrNull{ insert -> insert.fit(l, r) }
                insertion?.run {
                    operations.add(insertion.insert to index)
                }
                index += 1
            }
            for (i in operations.size - 1 downTo 0) {
                val ch = operations[i].first
                template = template.substring(0, i + 1) + ch + template.substring(i + 1)
            }
            val adssad =template.length
            operations.clear()
        }
        val n = template.count { it == 'N' }
        val c = template.count { it == 'C' }
        val b = template.count { it == 'B' }
        val h = template.count { it == 'H' }
        val ncbh = listOf(n,c,b,h)
        val adssad =template.length
        return template.groupBy { it }.map{it.value.size}.max()!! -
        template.groupBy { it }.map{it.value.size}.min()!!
    }
}


class Factory(private val data: List<String>) {
    fun construct(): List<Insertion> {
        return data.map{
            val (left, right) = it.split(" -> ")
            Insertion(left[0], left[1], right[0])
        }
    }
}

data class Insertion(val before: Char, val after: Char, val insert: Char) {
    fun fit(left: Char, right: Char):Boolean {
        return (left == before) && (right ==after)
    }
}
