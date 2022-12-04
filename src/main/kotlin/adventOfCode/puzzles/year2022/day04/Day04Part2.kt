package adventOfCode.puzzles.year2022.day04

import adventOfCode.common.commonItems
import adventOfCode.common.fullyContains
import adventOfCode.common.hasCommonPartWith
import adventOfCode.domain.Day
import adventOfCode.domain.Puzzle
import adventOfCode.domain.RawInput
import adventOfCode.domain.Year
import adventOfCode.domain.asLines
import adventOfCode.domain.asNumbers

@Year(2022)
@Day(4, 2)
internal class Day04Part2(input: RawInput): Puzzle<Int>(input)  {
    override fun solve(): Int {
        return input
            .asLines()
            .map {
                println(it)
                val parts = it.split(",", "-")
                println(parts)
                val a = parts[0].toInt()..parts[1].toInt()
                val b = parts[2].toInt()..parts[3].toInt()
                Data(a, b)
            }.count {
                it.a.hasCommonPartWith(it.b)
            }
    }
}
