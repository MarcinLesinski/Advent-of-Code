package adventOfCode.puzzles.year2024.day01

import adventOfCode.common.typeExtentions.asLinesOfNumbers
import adventOfCode.domain.*
import kotlin.math.abs

@Year(2024)
@Day(1, 1)
class Part1(input: RawInput) : Puzzle<Int>(input) {
    override fun solve(): Int {
        val twoColumnsData = input.lines().asLinesOfNumbers()
        val firstColumn = twoColumnsData.map { it[0] }.sorted()
        val secondColumn = twoColumnsData.map { it[1] }.sorted()
        val sum = firstColumn.zip(secondColumn).map{
            val first = it.first
            val second = it.second
            abs(first - second)
        }.sum()
        return sum
    }
}

@Year(2024)
@Day(1, 2)
class Part2(input: RawInput) : Puzzle<Int>(input) {
    override fun solve(): Int {
        val twoColumnsData = input.lines().asLinesOfNumbers()
        val firstColumn = twoColumnsData.map { it[0] }.sorted()
        val secondColumn = twoColumnsData.map { it[1] }.sorted()

        val sum = firstColumn.map{number ->
            val count = secondColumn.count { it == number  }
            number * count
        }.sum()
        return sum
    }
}